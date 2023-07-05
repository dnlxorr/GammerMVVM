package com.cas.gammermvvmapp.presentation.screens.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cas.gammermvvmapp.domain.model.User
import com.cas.gammermvvmapp.domain.usecases.auth.AuthUseCases
import com.cas.gammermvvmapp.domain.usecases.users.UsersUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val authUseCases: AuthUseCases, private val usersUseCases: UsersUseCases):ViewModel() {

    var userData by mutableStateOf(User())
        private set

    init{
        getUserById()
    }
    private fun getUserById() = viewModelScope.launch {
        usersUseCases.getUserById(authUseCases.getCurrentUser()!!.uid).collect(){
            userData = it
        }
    }
    fun logout(){
        authUseCases.logout()
    }
}