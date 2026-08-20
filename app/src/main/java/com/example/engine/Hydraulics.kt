package com.example.engine

import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Simple hydraulics engine with Manning and Hazen-Williams for full circular pipes.
 * Units: meters (m), seconds (s), meters^3/second (m3/s)
 */

data class Pipe(
  val id: String,
  val length: Double,    // m
  val diameter: Double,  // m
  val slope: Double,     // unitless (m/m)
  val manningsN: Double, // Manning's roughness
  val hwCoeff: Double    // Hazen-Williams C
)

data class FlowResult(
  val q: Double,        // m3/s
  val velocity: Double, // m/s
  val headLoss: Double  // m (over the pipe length)
)

object Hydraulics {
  // Hydraulic radius for full circular pipe R = D/4
  private fun hydraulicRadius(d: Double) = d / 4.0

  // Cross-sectional area for circular pipe
  private fun area(d: Double) = PI * d * d / 4.0

  /**
   * Manning equation for full circular pipe (SI units):
   * Q = (1/n) * A * R^(2/3) * S^(1/2)
   * where S is the slope (head loss per length).
   */
  fun manning(pipe: Pipe): FlowResult {
    val A = area(pipe.diameter)
    val R = hydraulicRadius(pipe.diameter)
    val n = pipe.manningsN
    val S = pipe.slope
    val q = (1.0 / n) * A * R.pow(2.0 / 3.0) * sqrt(S)
    val v = if (A > 0) q / A else 0.0
    val headLoss = S * pipe.length
    return FlowResult(q, v, headLoss)
  }

  /**
   * Hazen-Williams empirical formula (approximate) for full circular pipe in SI:
   * Q = 0.849 * C * A * R^0.63 * S^0.54
   * Reference: unit-consistent approximation for m and s.
   */
  fun hazenWilliams(pipe: Pipe): FlowResult {
    val A = area(pipe.diameter)
    val R = hydraulicRadius(pipe.diameter)
    val C = pipe.hwCoeff
    val S = pipe.slope
    val q = 0.849 * C * A * R.pow(0.63) * S.pow(0.54)
    val v = if (A > 0) q / A else 0.0
    val headLoss = S * pipe.length
    return FlowResult(q, v, headLoss)
  }

  /**
   * Utility: run both methods and return pair of results for comparison.
   */
  fun analyze(pipe: Pipe): Pair<FlowResult, FlowResult> {
    return Pair(manning(pipe), hazenWilliams(pipe))
  }
}
