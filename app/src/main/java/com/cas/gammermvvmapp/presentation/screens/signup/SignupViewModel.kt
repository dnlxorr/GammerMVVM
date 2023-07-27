package com.cas.gammermvvmapp.presentation.screens.signup

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cas.gammermvvmapp.domain.model.Response
import com.cas.gammermvvmapp.domain.model.User
import com.cas.gammermvvmapp.domain.usecases.auth.AuthUseCases
import com.cas.gammermvvmapp.domain.usecases.users.UsersUseCases
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(private val authUseCases: AuthUseCases, private val usersUseCases: UsersUseCases) : ViewModel() {

    var email by mutableStateOf("")
    var isEmailValid by mutableStateOf(false)
    var emailErrorMsg by mutableStateOf("")

    var password by mutableStateOf("")
    var isPasswordValid by mutableStateOf(false)
    var passwordErrorMsg by mutableStateOf("")

    var username by mutableStateOf("")
    var isUsernameValid by mutableStateOf(false)
    var usernameErrorMsg by mutableStateOf("")

    var confirmPassword by mutableStateOf("")
    var isConfirmPasswordValid by mutableStateOf(false)
    var confirmPasswordErrorMsg by mutableStateOf("")

    var isEnabledSignupButton = false

    private fun enableSignupButton() {
        isEnabledSignupButton =
            isUsernameValid && isEmailValid && isPasswordValid && isConfirmPasswordValid
    }

    private val _signupFlow = MutableStateFlow<Response<FirebaseUser>?>(null)
    val signupFlow: StateFlow<Response<FirebaseUser>?> = _signupFlow

    var user = User()
    fun signup(user: User) = viewModelScope.launch {
        _signupFlow.value = Response.Loading
        val result = authUseCases.signup(user)
        _signupFlow.value = result
    }
    fun onSignup(){
        user.username = username
        user.email = email
        user.password = password
        signup(user)
    }

    fun createUser() = viewModelScope.launch {
        user.id = authUseCases.getCurrentUser()!!.uid
        usersUseCases.createNewUser(user)
    }

    fun validateUsername() {
        if (username.length >= 5) {
            isUsernameValid = true
            usernameErrorMsg = ""
        } else {
            isUsernameValid = false
            usernameErrorMsg = "5 chars at least!"
        }
        enableSignupButton()
    }

    fun validateEmail() {
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            isEmailValid = true
            emailErrorMsg = ""
        } else {
            isEmailValid = false
            emailErrorMsg = "Invalid email!"
        }
        enableSignupButton()
    }

    fun validatePassword() {
        if (password.length >= 6) {
            isPasswordValid = true
            passwordErrorMsg = ""
        } else {
            isPasswordValid = false
            passwordErrorMsg = "Use 6 characters or more!"
        }
        enableSignupButton()
    }

    fun validateConfirmPassword() {
        if (password == confirmPassword) {
            isConfirmPasswordValid = true
            confirmPasswordErrorMsg = ""
        } else {
            isConfirmPasswordValid = false
            confirmPasswordErrorMsg = "Password do not match!"
        }
        enableSignupButton()
    }

}