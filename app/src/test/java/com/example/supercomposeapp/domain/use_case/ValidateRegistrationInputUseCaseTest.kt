package com.example.supercomposeapp.domain.use_case

import com.example.supercomposeapp.domain.model.RegistrationValidationType
import com.google.common.truth.Truth.assertThat

import org.junit.Before
import org.junit.Test

class ValidateRegistrationInputUseCaseTest {
    lateinit var sut: ValidateRegistrationInputUseCase

    @Before
    fun setUp() {
        sut = ValidateRegistrationInputUseCase()
    }


    @Test
    fun `validation type returns empty for email field`() {
        val result = sut.invoke(
            email = "",
            passwordField = "asdf",
            retypePasswordField = "asdf"
        )
        assertThat(result).isEqualTo(RegistrationValidationType.EmptyField)

    }

    @Test
    fun `validation type returns empty for password field`() {
        val result = sut.invoke(
            email = "emdad@ergo-ventures.com",
            passwordField = "",
            retypePasswordField = "asdf"
        )
        assertThat(result).isEqualTo(RegistrationValidationType.EmptyField)

    }

    @Test
    fun `validation type returns empty for retypePassword field`() {
        val result = sut.invoke(
            email = "emdad@ergo-ventures.com",
            passwordField = "asdf",
            retypePasswordField = ""
        )
        assertThat(result).isEqualTo(RegistrationValidationType.EmptyField)

    }

    @Test
    fun `validation type returns noemail for @ Sting inside email`() {
        val result = sut.invoke(
            email = "emdadergo-ventures.com",
            passwordField = "asdf",
            retypePasswordField = "asdf"
        )
        assertThat(result).isEqualTo(RegistrationValidationType.NoEmail)

    }

    @Test
    fun `validation type returns password does not match`() {
        val result = sut.invoke(
            email = "emdad@ergo-ventures.com",
            passwordField = "asdf",
            retypePasswordField = "asdfw"
        )
        assertThat(result).isEqualTo(RegistrationValidationType.PasswordNotMatch)

    }

    @Test
    fun `validation type returns password too short`() {
        val result = sut.invoke(
            email = "emdad@ergo-ventures.com",
            passwordField = "Sasdf",
            retypePasswordField = "Sasdf"
        )
        assertThat(result).isEqualTo(RegistrationValidationType.PasswordTooShort)

    }

    @Test
    fun `validation type returns password missing Number`() {
        val result = sut.invoke(
            email = "emdad@ergo-ventures.com",
            passwordField = "!Sasdfasdfas",
            retypePasswordField = "!Sasdfasdfas"
        )
        assertThat(result).isEqualTo(RegistrationValidationType.PasswordNumberMissing)

    }

    @Test
    fun `validation type returns password missing specialCharacters`() {
        val result = sut.invoke(
            email = "emdad@ergo-ventures.com",
            passwordField = "1Sasdfasdfas",
            retypePasswordField = "1Sasdfasdfas"
        )
        assertThat(result).isEqualTo(RegistrationValidationType.PasswordSpecialCharMissing)

    }

    @Test
    fun `validation type returns valid match`() {
        val result = sut.invoke(
            email = "emdad@ergo-ventures.com",
            passwordField = "2asdf12!",
            retypePasswordField = "2asdf12!"
        )
        assertThat(result).isEqualTo(RegistrationValidationType.Valid)

    }
}