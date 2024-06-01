package com.example.madarsoft_task.userInterface

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.madarsoft_task.core.UserAction
import com.example.madarsoft_task.core.UserViewModel

@Composable
fun UserEntryScreen(viewModel: UserViewModel, navigateToSavedData: (() -> Unit?)? = null) {
    val state = viewModel.state.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        if (state.value.error != null) {
            Text(text = state.value.error!!, color = MaterialTheme.colors.error)
        }
        TextField(
            value = state.value.name,
            onValueChange = { viewModel.dispatch(UserAction.EnterName(it)) },
            label = { Text("Name") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = state.value.age.toString(),
            onValueChange = { viewModel.dispatch(UserAction.EnterAge(it.toIntOrNull() ?: 0)) },
            label = { Text("Age") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = state.value.jobTitle,
            onValueChange = { viewModel.dispatch(UserAction.EnterJobTitle(it)) },
            label = { Text("Job Title") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = state.value.gender,
            onValueChange = { viewModel.dispatch(UserAction.EnterGender(it)) },
            label = { Text("Gender") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            viewModel.dispatch(UserAction.SaveUser)
        }, enabled = !state.value.isLoading) {
            if (state.value.isLoading) {
                CircularProgressIndicator(color = MaterialTheme.colors.primary)
            } else {
                Text("Save User")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navigateToSavedData?.invoke() }) {
            Text("Show Saved Data")
        }
    }
}
