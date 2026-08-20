package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.viewmodel.NetworkViewModel
import com.example.ui.screens.MainScreen
import com.example.ui.screens.EditorScreen
import com.example.data.Repository
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()

    // Initialize repository
    Repository.init(applicationContext)

    setContent {
      MyApplicationTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
          val vm: NetworkViewModel = viewModel()
          vm.observeFromRepository()
          AppRoot(vm = vm)
        }
      }
    }
  }
}

@Composable
fun AppRoot(vm: NetworkViewModel) {
  var screen by remember { mutableStateOf("list") }
  var editIndex by remember { mutableStateOf(-1) }

  when (screen) {
    "list" -> MainScreen(viewModel = vm, onShowEditor = { idx -> editIndex = idx; screen = "editor" })
    "editor" -> EditorScreen(viewModel = vm, onDone = { screen = "list" })
  }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  MyApplicationTheme { /* preview not changed */ }
}
