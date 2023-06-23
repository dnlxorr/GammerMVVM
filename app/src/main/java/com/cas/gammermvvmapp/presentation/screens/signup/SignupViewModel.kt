package com.cas.gammermvvmapp.presentation.screens.signup

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
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

    var email: MutableState<String> = mutableStateOf("")
    var isEmailValid: MutableState<Boolean> = mutableStateOf(false)
    var emailErrorMsg: MutableState<String> = mutableStateOf("")

    var password: MutableState<String> = mutableStateOf("")
    var isPasswordValid: MutableState<Boolean> = mutableStateOf(false)
    var passwordErrorMsg: MutableState<String> = mutableStateOf("")

    var username: MutableState<String> = mutableStateOf("")
    var isUsernameValid: MutableState<Boolean> = mutableStateOf(false)
    var usernameErrorMsg: MutableState<String> = mutableStateOf("")

    var confirmPassword: MutableState<String> = mutableStateOf("")
    var isConfirmPasswordValid: MutableState<Boolean> = mutableStateOf(false)
    var confirmPasswordErrorMsg: MutableState<String> = mutableStateOf("")

    var isEnabledSignupButton = false

    private fun enableSignupButton() {
        isEnabledSignupButton =
            isUsernameValid.value && isEmailValid.value && isPasswordValid.value && isConfirmPasswordValid.value
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
        user.username = username.value
        user.email = email.value
        user.password = password.value
        signup(user)
    }

    fun createUser() = viewModelScope.launch {
        user.id = authUseCases.getCurrentUser()!!.uid
        usersUseCases.createNewUser(user)
    }

    fun validateUsername() {
        if (username.value.length >= 5) {
            isUsernameValid.value = true
            usernameErrorMsg.value = ""
        } else {
            isUsernameValid.value = false
            usernameErrorMsg.value = "5 chars at least!"
        }
        enableSignupButton()
    }

    fun validateEmail() {
        if (Patterns.EMAIL_ADDRESS.matcher(email.value).matches()) {
            isEmailValid.value = true
            emailErrorMsg.value = ""
        } else {
            isEmailValid.value = false
            emailErrorMsg.value = "Invalid email!"
        }
        enableSignupButton()
    }

    fun validatePassword() {
        if (password.value.length >= 6) {
            isPasswordValid.value = true
            passwordErrorMsg.value = ""
        } else {
            isPasswordValid.value = false
            passwordErrorMsg.value = "Use 6 characters or more!"
        }
        enableSignupButton()
    }

    fun validateConfirmPassword() {
        if (password.value == confirmPassword.value) {
            isConfirmPasswordValid.value = true
            confirmPasswordErrorMsg.value = ""
        } else {
            isConfirmPasswordValid.value = false
            confirmPasswordErrorMsg.value = "Password do not match!"
        }
        enableSignupButton()
    }

}