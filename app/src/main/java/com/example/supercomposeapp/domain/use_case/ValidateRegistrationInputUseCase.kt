package com.example.supercomposeapp.domain.use_case

import com.example.supercomposeapp.domain.model.RegistrationValidationType

class ValidateRegistrationInputUseCase() {

    operator fun invoke(
        email: String,
        passwordField: String,
        retypePasswordField: String
    ): RegistrationValidationType {


        if (email.isEmpty() || passwordField.isEmpty() || retypePasswordField.isEmpty()) return RegistrationValidationType.EmptyField

        if ("@" !in email) return RegistrationValidationType.NoEmail

        if (passwordField != retypePasswordField) return RegistrationValidationType.PasswordNotMatch

        return RegistrationValidationType.Valid
    }
}