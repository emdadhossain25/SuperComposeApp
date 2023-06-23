package com.example.supercomposeapp.domain.model

enum class RegistrationValidationType {
    EmptyField,
    NoEmail,
    PasswordNotMatch,
    PasswordUpperCaseMissing,
    PasswordNumberMissing,
    PasswordSpecialCharMissing,
    PasswordTooShort,
    Valid

}