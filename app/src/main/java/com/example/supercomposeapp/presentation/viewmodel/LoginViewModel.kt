package com.example.supercomposeapp.presentation.viewmodel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.supercomposeapp.domain.model.LoginInputValidationType
import com.example.supercomposeapp.domain.reository.IAuthRepository
import com.example.supercomposeapp.domain.use_case.ValidateLoginInputUseCase
import com.example.supercomposeapp.presentation.state.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginInputUseCase: ValidateLoginInputUseCase,
    private val authRepository: IAuthRepository
) : ViewModel() {
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
        loginState = loginState.copy(isPasswordShowing = !loginState.isPasswordShowing)
        checkInputValidation()
    }

    fun onLoginClick() {
        loginState = loginState.copy(isLoading = true)
        viewModelScope.launch {
            loginState = try {
                val loginResult = authRepository.login(
                    email = loginState.emailInput,
                    password = loginState.passwordInput
                )
                loginState.copy(isSuccessfullyLoggedIn = loginResult)
            } catch (e: Exception) {
                loginState.copy(errorMessageLoginProcess = "Could Not Login")
            } finally {
                loginState = loginState.copy(isLoading = false)
            }
        }
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