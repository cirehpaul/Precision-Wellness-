package com.example.fitness.ui.login

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.*
import com.example.fitness.common.Constant
import com.example.fitness.domain.dto.UserDetailsDto
import com.example.fitness.domain.usecase.LoginUseCase

class LoginViewModel(val loginUseCase: LoginUseCase) : ViewModel() {

    private val _username = mutableStateOf("")
        val username: MutableState<String> = _username

        private val _password = mutableStateOf("")
        val password: MutableState<String> = _password

        private val _enableButton = mutableStateOf(false)
        val enableButton: MutableState<Boolean> = _enableButton

        private val _loginState = mutableStateOf(LoginState.INITIAL)
        val loginState: MutableState<LoginState> = _loginState

        fun setUsername(username: String) {
            _username.value = username
            if(isAllFieldNotEmpty()){
                _enableButton.value = true
            }
        }

        fun setPassword(password: String) {
            _password.value = password
            if(isAllFieldNotEmpty()){
                _enableButton.value = true
            }
        }

    suspend fun performLogin() {
        if(isAllFieldNotEmpty()){
            //TODO check if the username and password is correct
            // connected to database
            val userDto = validateLogin(username = username.value, password = password.value)
            if(userDto.username.isNotEmpty()){
                Constant.isLogin.value = true
                //check if user was already finish with onboarding setup - up to body Type
                if(userDto.bodygoals.isNotEmpty()){
                    Constant.isShowBottomNav.value = true //show bottom nav
                    _loginState.value = LoginState.SUCCESS_SKIP_TO_DASHBOARD
                }else{
                    //normal login
                    _loginState.value = LoginState.SUCCESS
                }
            }else{
                _loginState.value = LoginState.ERROR
            }
        }else{
            _loginState.value = LoginState.ERROR
        }
    }

    //check if all fields are not empty
    private fun isAllFieldNotEmpty(): Boolean {
        return (!_username.value.isNullOrEmpty() && !_password.value.isNullOrEmpty())
    }

    //example this is from checking in the database
    private suspend fun validateLogin(username: String, password: String): UserDetailsDto {
        //check if there is user existing in database
       return loginUseCase(username, password).apply{
           //set UserId for update later
           Constant.userId.longValue = id
        }
    }
}

data class User(
    val username: String,
    val password: String,
    val isSuccess: Boolean,
)

enum class LoginState{

    INITIAL,
    LOADING,
    SUCCESS_SKIP_TO_DASHBOARD,
    SUCCESS,
    ERROR;
}

