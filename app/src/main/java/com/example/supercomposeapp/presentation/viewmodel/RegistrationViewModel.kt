package com.example.supercomposeapp.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.supercomposeapp.domain.model.RegistrationValidationType
import com.example.supercomposeapp.domain.use_case.ValidateRegistrationInputUseCase
import com.example.supercomposeapp.presentation.state.RegistrationState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    val registrationInputUseCase: ValidateRegistrationInputUseCase
) {
    var registrationState by mutableStateOf(RegistrationState())
        private set

    fun emailInputChange(newValue: String) {
        registrationState = registrationState.copy(emailInput = newValue)
        checkInputValidation()

    }

    fun passwordInputChange(newValue: String) {
        registrationState = registrationState.copy(passwordInput = newValue)
        checkInputValidation()

    }

    fun repeatPasswordInputChange(newValue: String) {
        registrationState = registrationState.copy(passwordRepeatedInput = newValue)
        checkInputValidation()

    }

    fun onToggleVisualTransformationForPassword() {
        registrationState =
            registrationState.copy(isPasswordShown = !registrationState.isPasswordShown)
        checkInputValidation()
    }

    fun onToggleVisualTransformationForRepeatPassword() {
        registrationState =
            registrationState.copy(isRepeatPasswordShown = !registrationState.isRepeatPasswordShown)
        checkInputValidation()
    }

    fun onRegistrationClick() {

    }

    private fun checkInputValidation() {
        val validationResult = registrationInputUseCase(
            email = registrationState.emailInput,
            passwordField = registrationState.passwordInput,
            retypePasswordField = registrationState.passwordRepeatedInput
        )

        processInputValidationType(validationResult)


    }

    private fun processInputValidationType(validationResult: RegistrationValidationType) {
        registrationState = when (validationResult) {
            RegistrationValidationType.EmptyField -> {
                registrationState.copy(errorMessageInput = "Empty Fields", isValidInput = false)

            }
            RegistrationValidationType.NoEmail -> {
                registrationState.copy(errorMessageInput = "Email Not Valid", isValidInput = false)
            }
            RegistrationValidationType.PasswordNotMatch -> {
                registrationState.copy(
                    errorMessageInput = "Passwords Not Match", isValidInput = false
                )
            }
            RegistrationValidationType.PasswordUpperCaseMissing -> {
                registrationState.copy(
                    errorMessageInput = "Password's Uppercase Missing", isValidInput = false
                )
            }
            RegistrationValidationType.PasswordNumberMissing -> {
                registrationState.copy(
                    errorMessageInput = "Password's Number Missing", isValidInput = false
                )
            }
            RegistrationValidationType.PasswordSpecialCharMissing -> {
                registrationState.copy(
                    errorMessageInput = "Password's Special Character Missing", isValidInput = false
                )
            }
            RegistrationValidationType.PasswordTooShort -> {
                registrationState.copy(
                    errorMessageInput = "Password's Too Short", isValidInput = false
                )
            }
            RegistrationValidationType.Valid -> {
                registrationState.copy(
                    errorMessageInput = null, isValidInput = true
                )
            }
        }
    }


}