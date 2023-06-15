package com.cas.gammermvvmapp.presentation.screens.signup

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor():ViewModel() {

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

    private fun enableSignupButton(){
        isEnabledSignupButton = isUsernameValid.value && isEmailValid.value && isPasswordValid.value && isConfirmPasswordValid.value
    }

    fun validateUsername(){
        if (username.value.length>=5){
            isUsernameValid.value = true
            usernameErrorMsg.value = ""
        }else{
            isUsernameValid.value =false
            usernameErrorMsg.value = "5 chars at least!"
        }
        enableSignupButton()
    }

    fun validateEmail(){
        if (Patterns.EMAIL_ADDRESS.matcher(email.value).matches()){
            isEmailValid.value = true
            emailErrorMsg.value = ""
        }else{
            isEmailValid.value =false
            emailErrorMsg.value = "Invalid email!"
        }
        enableSignupButton()
    }

    fun validatePassword(){
        if (password.value.length>=6){
            isPasswordValid.value = true
            passwordErrorMsg.value = ""
        }else{
            isPasswordValid.value = false
            passwordErrorMsg.value = "Use 6 characters or more!"
        }
        enableSignupButton()
    }

    fun validateConfirmPassword(){
        if (password.value==confirmPassword.value){
            isConfirmPasswordValid.value = true
            confirmPasswordErrorMsg.value = ""
        }else{
            isConfirmPasswordValid.value = false
            confirmPasswordErrorMsg.value = "Password do not match!"
        }
        enableSignupButton()
    }

}