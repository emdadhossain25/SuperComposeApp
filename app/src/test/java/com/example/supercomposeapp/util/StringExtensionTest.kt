package com.example.supercomposeapp.util


import com.google.common.truth.Truth.assertThat
import org.junit.Test

class StringExtensionTest {


    @Test
    fun `test whether string contains numbers should return false`() {
        val result = "".containsNumbers()
        assertThat(result).isFalse()
    }

    @Test
    fun `test whether string contains numbers return true`() {
        val result = "helloemdad123".containsNumbers()
        assertThat(result).isTrue()
    }

    @Test
    fun `test whether string contains upperCase`() {
        val result = "TestThat".containsUpperCase()
        assertThat(result).isTrue()
    }

    @Test
    fun `test whether string contains special characters`() {
        val result = "emdad!".containsSpecialCharacters()
        assertThat(result).isTrue()
    }
}