package com.cas.gammermvvmapp.presentation.screens.profile

import androidx.lifecycle.ViewModel
import com.cas.gammermvvmapp.domain.usecases.auth.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val authUseCases: AuthUseCases):ViewModel() {

    fun logout(){
        authUseCases.logout()
    }
}