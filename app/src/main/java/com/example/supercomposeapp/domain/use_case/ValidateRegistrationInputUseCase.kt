package com.example.supercomposeapp.domain.use_case

import com.example.supercomposeapp.domain.model.RegistrationValidationType
import com.example.supercomposeapp.util.containsNumbers
import com.example.supercomposeapp.util.containsSpecialCharacters
import com.example.supercomposeapp.util.containsUpperCase

class ValidateRegistrationInputUseCase() {

    operator fun invoke(
        email: String,
        passwordField: String,
        retypePasswordField: String
    ): RegistrationValidationType {


        if (email.isEmpty() || passwordField.isEmpty() || retypePasswordField.isEmpty()) return RegistrationValidationType.EmptyField

        if ("@" !in email) return RegistrationValidationType.NoEmail

        if (passwordField != retypePasswordField) return RegistrationValidationType.PasswordNotMatch

        if (passwordField.count() < 8) return RegistrationValidationType.PasswordTooShort

        if (!passwordField.containsNumbers()) return RegistrationValidationType.PasswordNumberMissing

        if (!passwordField.containsUpperCase()) return RegistrationValidationType.PasswordUpperCaseMissing

        if (!passwordField.containsSpecialCharacters()) return RegistrationValidationType.PasswordSpecialCharMissing

        return RegistrationValidationType.Valid
    }
}