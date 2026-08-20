package com.example.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.engine.Hydraulics
import com.example.engine.Pipe
import com.example.engine.FlowResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class UiState {
  object Idle: UiState()
  object Calculating: UiState()
  data class Result(val manning: FlowResult, val hw: FlowResult): UiState()
}

class NetworkViewModel: ViewModel() {
  private val _pipes = MutableStateFlow<List<Pipe>>(emptyList())
  val pipes: StateFlow<List<Pipe>> = _pipes

  private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
  val uiState: StateFlow<UiState> = _uiState

  fun addSamplePipe() {
    val sample = Pipe(
      id = "P1",
      length = 100.0,
      diameter = 0.3,
      slope = 0.001,
      manningsN = 0.013,
      hwCoeff = 130.0
    )
    _pipes.value = _pipes.value + sample
  }

  fun addPipe(pipe: Pipe) {
    _pipes.value = _pipes.value + pipe
  }

  fun clear() {
    _pipes.value = emptyList()
    _uiState.value = UiState.Idle
  }

  fun analyze(index: Int) {
    val list = _pipes.value
    if (index < 0 || index >= list.size) return
    val pipe = list[index]
    viewModelScope.launch {
      _uiState.value = UiState.Calculating
      // Run CPU-bound work here (small calculations)
      val (manningRes, hwRes) = Hydraulics.analyze(pipe)
      _uiState.value = UiState.Result(manningRes, hwRes)
    }
  }
}
