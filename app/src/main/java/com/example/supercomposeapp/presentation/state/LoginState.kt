package com.example.supercomposeapp.presentation.state

data class LoginState(
    var emailInput: String = "",
    var passwordInput: String = "",
    var isLoading: Boolean = false,
    var isInputValid: Boolean = false,
    var isPasswordShowing: Boolean = false,
    var errorMessageInput: String? = null,
    var isSuccessfullyLoggedIn: Boolean = false,
    var errorMessageLoginProcess: String? = null

)
