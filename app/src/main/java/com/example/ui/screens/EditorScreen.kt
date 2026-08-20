package com.example.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.engine.Pipe
import com.example.ui.viewmodel.NetworkViewModel

@Composable
fun EditorScreen(viewModel: NetworkViewModel, onDone: () -> Unit) {
  val idState = remember { mutableStateOf("") }
  val lengthState = remember { mutableStateOf(100.0.toString()) }
  val diameterState = remember { mutableStateOf(0.3.toString()) }
  val slopeState = remember { mutableStateOf(0.001.toString()) }
  val nState = remember { mutableStateOf(0.013.toString()) }
  val cState = remember { mutableStateOf(130.0.toString()) }

  Column(modifier = Modifier.padding(16.dp)) {
    OutlinedTextField(value = idState.value, onValueChange = { idState.value = it }, label = { Text(stringResource(id = R.string.pipe_id)) }, modifier = Modifier.fillMaxWidth())
    OutlinedTextField(value = lengthState.value, onValueChange = { lengthState.value = it }, label = { Text(stringResource(id = R.string.length_m)) }, modifier = Modifier.fillMaxWidth())
    OutlinedTextField(value = diameterState.value, onValueChange = { diameterState.value = it }, label = { Text(stringResource(id = R.string.diameter_m)) }, modifier = Modifier.fillMaxWidth())
    OutlinedTextField(value = slopeState.value, onValueChange = { slopeState.value = it }, label = { Text(stringResource(id = R.string.slope)) }, modifier = Modifier.fillMaxWidth())
    OutlinedTextField(value = nState.value, onValueChange = { nState.value = it }, label = { Text(stringResource(id = R.string.mannings_n)) }, modifier = Modifier.fillMaxWidth())
    OutlinedTextField(value = cState.value, onValueChange = { cState.value = it }, label = { Text(stringResource(id = R.string.hazen_williams_c)) }, modifier = Modifier.fillMaxWidth())

    Button(onClick = {
      val pipe = Pipe(
        id = if (idState.value.isBlank()) "P${System.currentTimeMillis() % 10000}" else idState.value,
        length = lengthState.value.toDoubleOrNull() ?: 0.0,
        diameter = diameterState.value.toDoubleOrNull() ?: 0.0,
        slope = slopeState.value.toDoubleOrNull() ?: 0.0,
        manningsN = nState.value.toDoubleOrNull() ?: 0.013,
        hwCoeff = cState.value.toDoubleOrNull() ?: 100.0
      )
      viewModel.addPipe(pipe)
      onDone()
    }, modifier = Modifier.padding(top = 12.dp)) {
      Text(text = stringResource(id = R.string.save))
    }

    Button(onClick = { onDone() }, modifier = Modifier.padding(top = 8.dp)) { Text(text = stringResource(id = R.string.cancel)) }
  }
}
