package com.example.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.data.model.Manhole
import com.example.data.model.ManningCalculation
import com.example.data.model.NetworkSummary
import com.example.data.model.PipeLink
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

enum class AppNavTab(val title: String, val icon: String) {
    HOME("Home", "🏠"),
    MANNING("Manning", "📐"),
    NETWORK("Network", "🏗️"),
    PROFILE("Profile", "📊"),
    REPORTS("Reports", "📋")
}

data class HydroUiState(
    val currentTab: AppNavTab = AppNavTab.HOME,
    val manholes: List<Manhole> = emptyList(),
    val pipes: List<PipeLink> = emptyList(),
    val manningCalc: ManningCalculation = ManningCalculation(),
    val selectedPipe: PipeLink? = null,
    val isAddManholeDialogOpen: Boolean = false,
    val isAddPipeDialogOpen: Boolean = false,
    val searchFilter: String = ""
) {
    val summary: NetworkSummary get() {
        val totalLength = pipes.sumOf { it.lengthMeters }
        val peakFlow = pipes.maxOfOrNull { it.designFlowLps } ?: 0.0
        val compliantCount = pipes.count { it.isVelocityCompliant && it.isFillingRatioCompliant }
        val percent = if (pipes.isNotEmpty()) (compliantCount * 100) / pipes.size else 100
        return NetworkSummary(
            totalManholes = manholes.size,
            totalPipes = pipes.size,
            totalLengthMeters = totalLength,
            totalPeakFlowLps = peakFlow,
            compliantPipesCount = compliantCount,
            compliancePercent = percent
        )
    }
}

class HydroViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HydroUiState())
    val uiState: StateFlow<HydroUiState> = _uiState.asStateFlow()

    init {
        loadDefaultSampleData()
    }

    private fun loadDefaultSampleData() {
        val sampleManholes = listOf(
            Manhole(id = "MH-01", name = "North Inflow Terminal", groundElevation = 104.50, invertElevation = 102.30, inflowRate = 18.5),
            Manhole(id = "MH-02", name = "Commercial Junction A", groundElevation = 103.80, invertElevation = 101.55, inflowRate = 32.0),
            Manhole(id = "MH-03", name = "Central Avenue Node", groundElevation = 102.90, invertElevation = 100.70, inflowRate = 45.0),
            Manhole(id = "MH-04", name = "Residential Main B", groundElevation = 102.10, invertElevation = 99.80, inflowRate = 58.0),
            Manhole(id = "MH-05", name = "Outfall Lift Station", groundElevation = 101.20, invertElevation = 98.75, inflowRate = 72.5)
        )

        val samplePipes = listOf(
            PipeLink(id = "P-01", fromManholeId = "MH-01", toManholeId = "MH-02", lengthMeters = 75.0, diameterMm = 300.0, roughnessN = 0.013, slopePercent = 1.00, designFlowLps = 24.5),
            PipeLink(id = "P-02", fromManholeId = "MH-02", toManholeId = "MH-03", lengthMeters = 85.0, diameterMm = 400.0, roughnessN = 0.013, slopePercent = 1.00, designFlowLps = 48.0),
            PipeLink(id = "P-03", fromManholeId = "MH-03", toManholeId = "MH-04", lengthMeters = 90.0, diameterMm = 450.0, roughnessN = 0.013, slopePercent = 1.00, designFlowLps = 65.0),
            PipeLink(id = "P-04", fromManholeId = "MH-04", toManholeId = "MH-05", lengthMeters = 105.0, diameterMm = 500.0, roughnessN = 0.013, slopePercent = 1.00, designFlowLps = 82.0)
        )

        _uiState.update {
            it.copy(
                manholes = sampleManholes,
                pipes = samplePipes,
                selectedPipe = samplePipes.firstOrNull()
            )
        }
    }

    fun setTab(tab: AppNavTab) {
        _uiState.update { it.copy(currentTab = tab) }
    }

    fun selectPipe(pipe: PipeLink) {
        _uiState.update { it.copy(selectedPipe = pipe) }
    }

    fun updateManning(diameterMm: Double, slopePercent: Double, roughnessN: Double, targetFlowLps: Double, material: String) {
        _uiState.update {
            it.copy(
                manningCalc = ManningCalculation(
                    diameterMm = diameterMm,
                    slopePercent = slopePercent,
                    roughnessN = roughnessN,
                    targetFlowLps = targetFlowLps,
                    pipeMaterial = material
                )
            )
        }
    }

    fun addManhole(id: String, name: String, groundEl: Double, invertEl: Double, inflow: Double) {
        val newMh = Manhole(
            id = id.ifBlank { "MH-${_uiState.value.manholes.size + 1}" },
            name = name.ifBlank { "Node ${_uiState.value.manholes.size + 1}" },
            groundElevation = groundEl,
            invertElevation = invertEl,
            inflowRate = inflow
        )
        _uiState.update { it.copy(manholes = it.manholes + newMh, isAddManholeDialogOpen = false) }
    }

    fun deleteManhole(id: String) {
        _uiState.update {
            it.copy(
                manholes = it.manholes.filter { mh -> mh.id != id },
                pipes = it.pipes.filter { pipe -> pipe.fromManholeId != id && pipe.toManholeId != id }
            )
        }
    }

    fun addPipe(fromId: String, toId: String, length: Double, diameter: Double, roughness: Double, slope: Double, flow: Double) {
        val newPipe = PipeLink(
            id = "P-0${_uiState.value.pipes.size + 1}",
            fromManholeId = fromId,
            toManholeId = toId,
            lengthMeters = length,
            diameterMm = diameter,
            roughnessN = roughness,
            slopePercent = slope,
            designFlowLps = flow
        )
        _uiState.update { it.copy(pipes = it.pipes + newPipe, isAddPipeDialogOpen = false) }
    }

    fun deletePipe(id: String) {
        _uiState.update {
            it.copy(
                pipes = it.pipes.filter { p -> p.id != id },
                selectedPipe = if (it.selectedPipe?.id == id) null else it.selectedPipe
            )
        }
    }

    fun setAddManholeDialog(open: Boolean) {
        _uiState.update { it.copy(isAddManholeDialogOpen = open) }
    }

    fun setAddPipeDialog(open: Boolean) {
        _uiState.update { it.copy(isAddPipeDialogOpen = open) }
    }

    fun setSearchFilter(query: String) {
        _uiState.update { it.copy(searchFilter = query) }
    }
}
