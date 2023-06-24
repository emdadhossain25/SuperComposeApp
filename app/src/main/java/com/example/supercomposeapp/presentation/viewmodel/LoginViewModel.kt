package com.example.supercomposeapp.presentation.viewmodel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.supercomposeapp.domain.model.LoginInputValidationType
import com.example.supercomposeapp.domain.use_case.ValidateLoginInputUseCase
import com.example.supercomposeapp.presentation.state.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginInputUseCase: ValidateLoginInputUseCase
) {
    var loginState by mutableStateOf(LoginState())
        private set


    fun emailInputChange(newValue: String) {
        loginState = loginState.copy(emailInput = newValue)
        checkInputValidation()
    }

    fun passwordInputChange(newValue: String) {
        loginState = loginState.copy(passwordInput = newValue)
        checkInputValidation()
    }

    fun onToggleVisualTransformation() {
        loginState = loginState.copy(isPasswordShown = !loginState.isPasswordShown)
        checkInputValidation()
    }

    fun onLoginClick() {

    }

    private fun checkInputValidation() {
        val validationResult = loginInputUseCase(
            loginState.emailInput,
            loginState.passwordInput
        )

        processInputValidationType(validationResult)

    }

    private fun processInputValidationType(validationResult: LoginInputValidationType) {
        loginState = when (validationResult) {
            LoginInputValidationType.EmptyField -> {
                loginState.copy(errorMessageInput = "Empty Fields", isInputValid = false)
            }
            LoginInputValidationType.NoEmail -> {
                loginState.copy(errorMessageInput = "No valid email", isInputValid = false)
            }
            LoginInputValidationType.Valid -> {
                loginState.copy(errorMessageInput = null, isInputValid = true)
            }
        }
    }

}