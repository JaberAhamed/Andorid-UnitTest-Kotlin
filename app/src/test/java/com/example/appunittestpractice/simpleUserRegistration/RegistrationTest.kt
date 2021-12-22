package com.example.appunittestpractice.simpleUserRegistration



import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationTest {

    @Test
    fun `empty user name return false`() {
        val result = Registration.validRegistrationInput(
            "",
            "123",
            "123"
        )

        assertThat(result).isFalse()
    }

    @Test
    fun `user name length below 3 return false`() {
        val result = Registration.validRegistrationInput(
            "Pa",
            "123",
            ""
        )

        assertThat(result).isFalse()
    }

    @Test
    fun `empty userPassword is return false`() {
        val result = Registration.validRegistrationInput(
            "Parl",
            "",
            "123"
        )

        assertThat(result).isFalse()
    }
    @Test
    fun `both userPassword not match return false`() {
        val result = Registration.validRegistrationInput(
            "Parl",
            "123",
            ""
        )

        assertThat(result).isFalse()
    }

    @Test
    fun `password length below two return false`() {
        val result = Registration.validRegistrationInput(
            "Parl",
            "12",
            "122"
        )

        assertThat(result).isFalse()
    }

    @Test
    fun `username and both password is match return true`() {
        val result = Registration.validRegistrationInput(
            "Philips",
            "12345",
            "12345"
        )

        assertThat(result).isTrue()
    }

    @Test
    fun `username already contain`() {
        val result = Registration.validRegistrationInput(
            "Carl",
            "12345",
            "12345"
        )

        assertThat(result).isFalse()
    }
}