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

    var email: String by mutableStateOf("") //se declara el tipo de dato pero no hace falta, se podria quitar
    var isEmailValid by mutableStateOf(false)
    var emailErrorMsg by mutableStateOf("")

    var password by mutableStateOf("")
    var isPasswordValid by mutableStateOf(false)
    var passwordErrorMsg by mutableStateOf("")

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
        val result = authUseCases.login(email,password)
        _loginFlow.value = result
    }

    fun enabledLoginButton(){
        isEnabledLoginButton = isEmailValid && isPasswordValid
    }

    fun validateEmail(){
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            isEmailValid = true
            emailErrorMsg = ""
        }else{
            isEmailValid = false
            emailErrorMsg = "Invalid email!"
        }
        enabledLoginButton()
    }

    fun validatePassword(){
        if (password.length>=6){
            isPasswordValid = true
            passwordErrorMsg = ""
        }else{
            isPasswordValid = false
            passwordErrorMsg = "Use 6 characters or more!"
        }
        enabledLoginButton()
    }

}