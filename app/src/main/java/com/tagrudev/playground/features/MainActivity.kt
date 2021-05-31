package com.tagrudev.playground.features

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.tagrudev.playground.features.state.StateHoistingComponent
import com.tagrudev.playground.ui.theme.PlaygroundTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      PlaygroundTheme {
        StateHoistingComponent()
      }
    }
  }
}
