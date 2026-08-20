package com.example.data.model

import kotlin.math.*

data class Manhole(
    val id: String, // e.g. "MH-01"
    val name: String,
    val groundElevation: Double, // Ground Level (GL) in meters
    val invertElevation: Double, // Invert Level (IL) in meters
    val inflowRate: Double = 0.0, // Inflow Q in L/s
    val depth: Double = groundElevation - invertElevation
)

data class PipeLink(
    val id: String, // e.g. "P-01"
    val fromManholeId: String,
    val toManholeId: String,
    val lengthMeters: Double, // Length L in m
    val diameterMm: Double, // Diameter D in mm
    val roughnessN: Double = 0.013, // Manning's n (e.g. 0.013 for concrete, 0.010 for PVC)
    val slopePercent: Double, // Slope S in %
    val designFlowLps: Double // Design Flow Q in L/s
) {
    val diameterMeters: Double get() = diameterMm / 1000.0
    val slopeDecimal: Double get() = slopePercent / 100.0

    // Full pipe capacity using Manning's Equation: Q_full = (1/n) * A * R^(2/3) * S^(1/2)
    val areaFull: Double get() = PI * (diameterMeters / 2.0).pow(2)
    val hydraulicRadiusFull: Double get() = diameterMeters / 4.0
    
    val velocityFull: Double get() = if (slopeDecimal > 0) {
        (1.0 / roughnessN) * hydraulicRadiusFull.pow(2.0 / 3.0) * sqrt(slopeDecimal)
    } else 0.0

    val flowCapacityFullLps: Double get() = (velocityFull * areaFull) * 1000.0

    // Partial flow estimation (using iterative hydraulic approximation for circular pipe)
    val flowRatio: Double get() = if (flowCapacityFullLps > 0) (designFlowLps / flowCapacityFullLps).coerceIn(0.01, 1.0) else 0.0
    
    // Approximate depth ratio d/D from flow ratio Q/Q_full
    val depthRatio: Double get() {
        val qRatio = flowRatio
        // Hydraulic empirical relation for d/D from Q/Qfull
        return when {
            qRatio <= 0.0 -> 0.0
            qRatio >= 1.0 -> 1.0
            else -> (qRatio.pow(0.55)).coerceIn(0.05, 1.0)
        }
    }

    val actualDepthMeters: Double get() = depthRatio * diameterMeters
    
    // Partial velocity estimation
    val actualVelocity: Double get() {
        return if (depthRatio > 0) {
            velocityFull * (depthRatio.pow(0.35)).coerceAtLeast(0.1)
        } else 0.0
    }

    // Shear stress tau = gamma * R * S (N/m^2)
    val shearStressPa: Double get() {
        val gamma = 9810.0 // N/m^3
        val partialR = hydraulicRadiusFull * (depthRatio.pow(0.4))
        return gamma * partialR * slopeDecimal
    }

    // Compliance checks
    val isVelocityCompliant: Boolean get() = actualVelocity in 0.6..3.0
    val isFillingRatioCompliant: Boolean get() = depthRatio <= 0.75
    val isSelfCleansing: Boolean get() = actualVelocity >= 0.6 || shearStressPa >= 1.5
}

data class ManningCalculation(
    val diameterMm: Double = 400.0,
    val slopePercent: Double = 0.5,
    val roughnessN: Double = 0.013,
    val targetFlowLps: Double = 45.0,
    val pipeMaterial: String = "PVC-U"
) {
    val diameterM: Double = diameterMm / 1000.0
    val slopeDec: Double = slopePercent / 100.0
    val areaFull: Double = PI * (diameterM / 2.0).pow(2)
    val rHydFull: Double = diameterM / 4.0
    val vFull: Double = if (slopeDec > 0) (1.0 / roughnessN) * rHydFull.pow(2.0 / 3.0) * sqrt(slopeDec) else 0.0
    val qFullLps: Double = (vFull * areaFull) * 1000.0
    
    val qRatio: Double = if (qFullLps > 0) (targetFlowLps / qFullLps).coerceIn(0.01, 1.2) else 0.0
    val dRatio: Double = when {
        qRatio <= 0 -> 0.0
        qRatio >= 1.0 -> 1.0
        else -> (qRatio.pow(0.54)).coerceIn(0.05, 1.0)
    }
    val actualWaterDepthM: Double = dRatio * diameterM
    val actualV: Double = if (dRatio > 0) vFull * (dRatio.pow(0.35)) else 0.0
    val shearStress: Double = 9810.0 * (rHydFull * dRatio.pow(0.4)) * slopeDec
    
    val isSelfCleansing: Boolean = actualV >= 0.6
    val isMaxVelocitySafe: Boolean = actualV <= 3.0
    val isDepthRatioSafe: Boolean = dRatio <= 0.75
}

data class NetworkSummary(
    val totalManholes: Int,
    val totalPipes: Int,
    val totalLengthMeters: Double,
    val totalPeakFlowLps: Double,
    val compliantPipesCount: Int,
    val compliancePercent: Int
)
