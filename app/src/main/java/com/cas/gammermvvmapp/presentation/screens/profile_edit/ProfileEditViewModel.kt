package com.cas.gammermvvmapp.presentation.screens.profile_edit

import android.content.Context
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
import com.cas.gammermvvmapp.presentation.utils.ComposeFileProvider
import com.cas.gammermvvmapp.presentation.utils.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class ProfileEditViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val usersUseCases: UsersUseCases,
    @ApplicationContext private val context: Context
) : ViewModel() {
    var state by mutableStateOf(ProfileEditState())
        private set

    var usernameErrorMsg by mutableStateOf("")
        private set
    var updateResponese by mutableStateOf<Response<Boolean>?>(null)
        private set

    var saveImageResponese by mutableStateOf<Response<String>?>(null)
        private set


    val data = savedStateHandle.get<String>("user")
    val user = User.fromJson(data!!)

    init {
        state = state.copy(
            username = user.username,
            image = user.image
        )
    }

    val resultingActivityHandler = ResultingActivityHandler()

    var file: File? = null

    fun saveImage() = viewModelScope.launch {
        if (file != null){
            saveImageResponese = Response.Loading
            val resul = usersUseCases.saveImage(file!!)
            saveImageResponese = resul
        }
    }

    fun pickImage() = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("image/*")
        if (result != null) {
            file = ComposeFileProvider.createFileFromUri(context = context,result)
            state = state.copy(image = result.toString())

        }
    }

    fun takePhoto() = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        if (result != null) {
            state = state.copy(image = ComposeFileProvider.getPathFromBitmap(bitmap = result, context = context))
            file = File(state.image)
        }
    }

    fun onUpdateUser(url :String) {
        val myUser = User(
            id = user.id,
            username = state.username,
            image = url
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