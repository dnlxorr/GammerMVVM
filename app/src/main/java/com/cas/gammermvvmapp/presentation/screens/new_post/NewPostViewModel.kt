package com.cas.gammermvvmapp.presentation.screens.new_post

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cas.gammermvvmapp.R
import com.cas.gammermvvmapp.presentation.utils.ComposeFileProvider
import com.cas.gammermvvmapp.presentation.utils.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class NewPostViewModel @Inject constructor(
    @ApplicationContext private val context: Context

) : ViewModel() {

    var state by mutableStateOf(NewPostState())

    var file: File? = null


    val radialOptions = listOf(
        CategoryRadialButton("PC", R.drawable.icon_pc),
        CategoryRadialButton("PS4", R.drawable.icon_ps4),
        CategoryRadialButton("XBOX", R.drawable.icon_xbox),
        CategoryRadialButton("NINTENDO", R.drawable.icon_nintendo),
        CategoryRadialButton("MOBILE", R.drawable.icon_mobile),
    )

    val resultingActivityHandler = ResultingActivityHandler()

    fun onNewPost() {
        Log.d("onNewPost", "name: ${state.name}")
        Log.d("onNewPost", "description: ${state.description}")
        Log.d("onNewPost", "image: ${state.image}")
        Log.d("onNewPost", "category: ${state.category}")
    }

    fun pickImage() = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("image/*")
        if (result != null) {
            file = ComposeFileProvider.createFileFromUri(context = context, result)
            state = state.copy(image = result.toString())

        }
    }

    fun takePhoto() = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        if (result != null) {
            state = state.copy(
                image = ComposeFileProvider.getPathFromBitmap(
                    bitmap = result,
                    context = context
                )
            )
            file = File(state.image)
        }
    }

    fun onNameInput(name: String) {
        state = state.copy(name = name)
    }

    fun onCategoryInput(category: String) {
        state = state.copy(category = category)
    }

    fun onDescriptionInput(description: String) {
        state = state.copy(description = description)
    }

    fun onImageInput(image: String) {
        state = state.copy(image = image)
    }
}

data class CategoryRadialButton(
    var category: String,
    var image: Int
)