package com.example.supercomposeapp.domain.use_case

import com.example.supercomposeapp.domain.model.LoginInputValidationType
import com.google.common.truth.Truth
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ValidateLoginInputUseCaseTest {

    lateinit var sut: ValidateLoginInputUseCase;

    @Before
    fun setUp() {
        sut = ValidateLoginInputUseCase()
    }

    @Test
    fun `check empty email return LoginValidationTYpe_EmptyField`() {
        Truth.assertThat(sut("", "password")).isEqualTo(
            LoginInputValidationType.EmptyField
        )
    }

    @Test
    fun `check password return LoginValidationTYpe_EmptyField`() {
        Truth.assertThat(sut("emdad@ergo.com", "")).isEqualTo(
            LoginInputValidationType.EmptyField
        )
    }
    @Test
    fun `check  LoginValidationTYpe_NoEmail`() {
        Truth.assertThat(sut("asfsf.com", "adfadfasf")).isEqualTo(
            LoginInputValidationType.NoEmail
        )
    }

    @Test
    fun `check  LoginValidationTYpe_Valid`() {
        Truth.assertThat(sut("asfsf@gmail.com", "adfadfasf")).isEqualTo(
            LoginInputValidationType.Valid
        )
    }
}