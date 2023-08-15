package com.cas.gammermvvmapp.presentation.screens.profile_edit

import android.view.View
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.cas.gammermvvmapp.domain.model.User
import com.cas.gammermvvmapp.presentation.screens.signup.SignupState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileEditViewModel @Inject constructor(private val savedStateHandle: SavedStateHandle): ViewModel() {
    var state by mutableStateOf(ProfileEditState())
        private set

    var usernameErrorMsg by mutableStateOf("")
        private set

    val data = savedStateHandle.get<String>("user")
    val user = User.fromJson(data!!)

    init {
        state = state.copy(username = user.username)
    }

    fun validateUsername() {
        usernameErrorMsg = if (state.username.length >= 5) {
            ""
        } else {
            "5 chars at least!"
        }
    }
    fun onUsernameInput(username: String) {
        state = state.copy(username = username)
    }
}