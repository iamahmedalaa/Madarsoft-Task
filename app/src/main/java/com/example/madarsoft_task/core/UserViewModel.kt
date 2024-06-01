package com.example.madarsoft_task.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.madarsoft_task.data.dataModel.User
import com.example.madarsoft_task.data.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UserViewModel(val userRepository: UserRepository, val dispatcher: CoroutineDispatcher) : ViewModel() {

    private val _state = MutableStateFlow(UserState())
    val state: StateFlow<UserState> = _state.asStateFlow()

    fun dispatch(action: UserAction) {
        viewModelScope.launch(dispatcher) {
            when (action) {
                // ... other update actions for user data (EnterAge, EnterJobTitle, EnterGender)
                UserAction.SaveUser -> {
                    _state.update { it.copy(isLoading = true) }
                    try {
                        userRepository.saveUser(
                            User(
                                name = state.value.name,
                                age = state.value.age,
                                jobTitle = state.value.jobTitle,
                                gender = state.value.gender
                            )
                        )
                        _state.update { it.copy(isLoading = false, error = null) }
                        // Handle successful save (e.g., navigation to Saved Data Screen)
                    } catch (e: Exception) {
                        _state.update { it.copy(isLoading = false, error = e.localizedMessage) }
                    }
                }
                UserAction.ShowSavedData -> {
                    // Trigger navigation to Saved Data Screen (implement in your fragment)
                    // You might use a navigation component or another approach
                }

                else -> {}
            }
        }
    }

    private suspend fun updateState(updater: suspend (UserState) -> UserState) {
        _state.update { updater(it) }
    }
}
