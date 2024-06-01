package com.example.madarsoft_task.core

data class UserState(
    val name: String = "",
    val age: Int = 0,
    val jobTitle: String = "",
    val gender: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
)

sealed class UserAction {
    data class EnterName(val name: String) : UserAction()
    data class EnterAge(val age: Int) : UserAction()
    data class EnterJobTitle(val jobTitle: String) : UserAction()
    data class EnterGender(val gender: String) : UserAction()
    object SaveUser : UserAction()
    object ShowSavedData : UserAction()
}
