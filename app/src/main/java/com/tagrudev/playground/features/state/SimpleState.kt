package com.tagrudev.playground.features.state

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment

@Composable
fun StateWithViewModel(simpleViewModel: SimpleViewModel) {
}

/*
  Learning State hoisting, Probably not the best example though
  The pattern where the state goes down, and events go up is called a unidirectional data flow.
*/
@Composable
fun StateHoistingComponent() {
  var name = rememberSaveable { mutableStateOf("") }

  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.SpaceBetween
  ) {
    DisplayName(name = name.value, clearName = { name.value = "" })
    DisplayNameControl(name = name.value, setName = { name.value = it })
  }

}

@Composable
fun DisplayNameControl(name: String, setName: (String) -> Unit) {
  if (name.isEmpty()) {
    Button(onClick = { setName("Bye Tosho") }) {
      Text("Set thy name")
    }
  }
}

@Composable
fun DisplayName(name: String, clearName: () -> Unit) {
  if (!name.isEmpty()) {
    Text(text = "Name is no longer blank: $name")

    Button(onClick = { clearName() }) {
      Text("Clear thy name")
    }
  }
}

// Learning remember
// Simple state manegement
@Composable
fun SimpleState() {
  var isEnabled = remember { mutableStateOf(false) }

  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.SpaceBetween
  ) {

    if (isEnabled.value) {
      Text("I am enabled now")
    } else {
      Text(text = "Sorry I am not enabled yet")
    }

    Button(onClick = { isEnabled.value = !isEnabled.value }) {
      Text(text = if (isEnabled.value) "Disable me" else "Enable me")
    }
  }
}

