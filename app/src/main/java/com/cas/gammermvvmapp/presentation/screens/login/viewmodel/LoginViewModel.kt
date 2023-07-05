package com.cas.gammermvvmapp.presentation.screens.login.viewmodel

import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cas.gammermvvmapp.domain.model.Response
import com.cas.gammermvvmapp.domain.usecases.auth.AuthUseCases
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCases: AuthUseCases): ViewModel() {

    var email: MutableState<String> = mutableStateOf("")
    var isEmailValid: MutableState<Boolean> = mutableStateOf(false)
    var emailErrorMsg: MutableState<String> = mutableStateOf("")

    var password: MutableState<String> = mutableStateOf("")
    var isPasswordValid: MutableState<Boolean> = mutableStateOf(false)
    var passwordErrorMsg: MutableState<String> = mutableStateOf("")

    var isEnabledLoginButton = false

    private val _loginFlow = MutableStateFlow<Response<FirebaseUser>?>(null)
    val loginFlow:StateFlow<Response<FirebaseUser>?> = _loginFlow

    private val currentUser: FirebaseUser? = authUseCases.getCurrentUser()
    init {
        if (currentUser != null){
            _loginFlow.value = Response.Success(currentUser)
        }
    }

    fun login() = viewModelScope.launch {
        _loginFlow.value = Response.Loading
        val result = authUseCases.login(email.value,password.value)
        _loginFlow.value = result
    }

    fun enabledLoginButton(){
        isEnabledLoginButton = isEmailValid.value && isPasswordValid.value
    }

    fun validateEmail(){
        if (Patterns.EMAIL_ADDRESS.matcher(email.value).matches()){
            isEmailValid.value = true
            emailErrorMsg.value = ""
        }else{
            isEmailValid.value =false
            emailErrorMsg.value = "Invalid email!"
        }
        enabledLoginButton()
    }

    fun validatePassword(){
        if (password.value.length>=6){
            isPasswordValid.value = true
            passwordErrorMsg.value = ""
        }else{
            isPasswordValid.value = false
            passwordErrorMsg.value = "Use 6 characters or more!"
        }
        enabledLoginButton()
    }

}