package com.example.supercomposeapp.presentation.state

data class RegistrationState(
    var emailInput: String = "",
    val passwordInput: String = "",
    val passwordRepeatedInput: String = "",
    val isPasswordShown: Boolean = false,
    val isRepeatPasswordShown: Boolean = false,
    val errorMessageInput: String? = null,
    val errorMessageRegistration: String? = null,
    val isLoading: Boolean = false,
    val isValidInput: Boolean = false,
    val isSuccessfullyRegistered: Boolean = false

)
