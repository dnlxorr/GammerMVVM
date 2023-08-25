package com.cas.gammermvvmapp.presentation.screens.profile_edit

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cas.gammermvvmapp.domain.model.Response
import com.cas.gammermvvmapp.domain.model.User
import com.cas.gammermvvmapp.domain.usecases.users.UsersUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileEditViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val usersUseCases: UsersUseCases
) : ViewModel() {
    var state by mutableStateOf(ProfileEditState())
        private set

    var usernameErrorMsg by mutableStateOf("")
        private set
    var updateResponese by mutableStateOf<Response<Boolean>?>(null)
        private set
    
    var imageUri by mutableStateOf<Uri?>(null)
    var hasImage by mutableStateOf(false)


    val data = savedStateHandle.get<String>("user")
    val user = User.fromJson(data!!)

    init {
        state = state.copy(username = user.username)
    }

    fun onGalleryResult(uri: Uri){
        imageUri = uri
    }
    fun onCameraResult(result: Boolean){
        hasImage = result
    }
    fun onUpdateUser(){
        val myUser = User(
            id = user.id,
            username = state.username,
            image = ""
        )
        updateUser(myUser)
    }
    fun updateUser(user: User) = viewModelScope.launch {
        updateResponese = Response.Loading
        val result = usersUseCases.updateUser(user)
        updateResponese = result
    }

    fun validateUsername() {
        usernameErrorMsg = (if (state.username.length >= 5) "" else "5 chars at least!")
    }

    fun onUsernameInput(username: String) {
        state = state.copy(username = username)
    }
}