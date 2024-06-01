package com.example.madarsoft_task.userInterface

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.madarsoft_task.core.UserViewModel

@Composable
fun SavedDataScreen(viewModel: UserViewModel) {
    val userList = viewModel.userRepository.getSavedUsers().collectAsState(initial = emptyList())

    Column(modifier = Modifier.fillMaxSize()) {
        Text("Saved Users:")
        Spacer(modifier = Modifier.height(8.dp))
        if (userList.value.isEmpty()) {
            Text("No users saved yet.")
        } else {
            userList.value.forEach { user ->
                Text(text = "${user.name} - ${user.age} - ${user.jobTitle} - ${user.gender}")
            }
        }
    }
}
