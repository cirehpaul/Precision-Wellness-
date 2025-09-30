package com.example.fitness.ui.signup

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.*
import com.example.fitness.domain.dto.UserDetailsDto
import com.example.fitness.domain.dto.toUserEntity
import com.example.fitness.domain.usecase.RegisterUseCase

class RegisterViewModel(val registerUseCase: RegisterUseCase) : ViewModel() {

    private val _username = mutableStateOf("")
    val username: MutableState<String> = _username

    private val _password = mutableStateOf("")
    val password: MutableState<String> = _password

    private val _confirmPassword = mutableStateOf("")
    val confirmPassword: MutableState<String> = _confirmPassword

    private val _enableButton = mutableStateOf(false)
    val enableButton: MutableState<Boolean> = _enableButton

    private val _registerState = mutableStateOf(RegisterState.INITIAL)
    val registerState: MutableState<RegisterState> = _registerState

    fun setUsername(username: String) {
        _username.value = username
        checkButtonState()
    }

    fun setPassword(password: String) {
        _password.value = password
        checkButtonState()
    }

    fun setConfirmPassword(confirmPassword: String) {
        _confirmPassword.value = confirmPassword
        checkButtonState()
    }

    private fun checkButtonState() {
        _enableButton.value = isAllFieldsNotEmpty() && passwordsMatch()
    }

    private fun isAllFieldsNotEmpty(): Boolean {
        return _username.value.isNotEmpty() &&
                _password.value.isNotEmpty() &&
                _confirmPassword.value.isNotEmpty()
    }

    private fun passwordsMatch(): Boolean {
        return _password.value == _confirmPassword.value
    }

    suspend fun registerNewUser() {
        if (isAllFieldsNotEmpty()) {
            if (validateConfirmPass(
                    password = password.value.orEmpty(),
                    confirmPassword = confirmPassword.value.orEmpty()
                )
            ) {
                insertNewUser()
                _registerState.value = RegisterState.SUCCESS
            } else {
                _registerState.value = RegisterState.ERROR
            }
        } else {
            _registerState.value = RegisterState.ERROR
        }
    }

    private suspend fun insertNewUser(){
        registerUseCase(
            userEntity = UserDetailsDto().copy(
                username = username.value,
                password = password.value
            ).toUserEntity()
        )
    }

    private fun validateConfirmPass(password: String, confirmPassword: String): Boolean {
        return (password == confirmPassword)
    }


    data class User(
        val username: String,
        val password: String,
        val confirmpassword: String,
        val isSuccess: Boolean,
    )

    enum class RegisterState {
        INITIAL,
        SUCCESS,
        ERROR
    }

    companion object {
        fun setAgreeToTerms(checked: Boolean) {
            // Implement the logic to set the agreeToTerms value in your ViewModel
            setAgreeToTerms(checked)
        }
    }
}

