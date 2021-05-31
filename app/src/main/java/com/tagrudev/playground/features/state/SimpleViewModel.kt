package com.tagrudev.playground.features.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SimpleViewModel : ViewModel() {
  var names: List<String> by mutableStateOf(listOf("Liam", "Noah", "Oliver"))
    private set

  fun addName(name: String) {
      names = names + listOf(name)
  }
}
