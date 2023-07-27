package com.cas.gammermvvmapp.presentation.screens.login.viewmodel

import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cas.gammermvvmapp.domain.model.Response
import com.cas.gammermvvmapp.domain.usecases.auth.AuthUseCases
import com.cas.gammermvvmapp.presentation.screens.login.LoginState
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCases: AuthUseCases): ViewModel() {

    //FormState
    var state by mutableStateOf(LoginState())
        private set

    //var email: String by mutableStateOf("") //se declara el tipo de dato String pero no hace falta, se podria quitar
    var isEmailValid by mutableStateOf(false)
        private set
    var emailErrorMsg by mutableStateOf("")
        private set
    //var password by mutableStateOf("")
    var isPasswordValid by mutableStateOf(false)
        private set
    var passwordErrorMsg by mutableStateOf("")
        private set

    var isEnabledLoginButton = false

    //Login Response
    var loginResponse by mutableStateOf<Response<FirebaseUser>?>(null)
        private set

    private val currentUser: FirebaseUser? = authUseCases.getCurrentUser()
    init {
        if (currentUser != null){
            loginResponse = Response.Success(currentUser)
        }
    }

    fun onEmailInput(email:String){
        state = state.copy(email = email)
    }

    fun onPasswordInput(password:String){
        state = state.copy(password = password)
    }

    fun login() = viewModelScope.launch {
        loginResponse = Response.Loading
        val result = authUseCases.login(state.email,state.password)
        loginResponse = result
    }

    fun enabledLoginButton(){
        isEnabledLoginButton = isEmailValid && isPasswordValid
    }

    fun validateEmail(){
        if (Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            isEmailValid = true
            emailErrorMsg = ""
        }else{
            isEmailValid = false
            emailErrorMsg = "Invalid email!"
        }
        enabledLoginButton()
    }

    fun validatePassword(){
        if (state.password.length>=6){
            isPasswordValid = true
            passwordErrorMsg = ""
        }else{
            isPasswordValid = false
            passwordErrorMsg = "Use 6 characters or more!"
        }
        enabledLoginButton()
    }

}