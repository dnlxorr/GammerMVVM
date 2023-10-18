package com.cas.gammermvvmapp.presentation.screens.new_post

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cas.gammermvvmapp.R
import com.cas.gammermvvmapp.core.Constants.POSTS
import com.cas.gammermvvmapp.domain.model.Post
import com.cas.gammermvvmapp.domain.model.Response
import com.cas.gammermvvmapp.domain.usecases.auth.AuthUseCases
import com.cas.gammermvvmapp.domain.usecases.posts.PostsUseCases
import com.cas.gammermvvmapp.presentation.utils.ComposeFileProvider
import com.cas.gammermvvmapp.presentation.utils.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class NewPostViewModel @Inject constructor(
    @ApplicationContext
    private val context: Context,
    private val postsUseCases: PostsUseCases,
    private val authUseCases: AuthUseCases
    ) : ViewModel() {

    var state by mutableStateOf(NewPostState())

    var file: File? = null

    //Response
    var createPostResponse by mutableStateOf<Response<Boolean>?>(null)
        private set

    //User session
    val currentUser = authUseCases.getCurrentUser()

    fun createPost(post: Post) = viewModelScope.launch {
        createPostResponse = Response.Loading
        val result = postsUseCases.create(post, file!!)
        createPostResponse = result
    }

    fun onNewPost() {
        val post = Post(
            name = state.name,
            description = state.description,
            category = state.category,
            idUser = currentUser?.uid ?: "",
            image = state.image
        )
        createPost(post)
    }

    val radialOptions = listOf(
        CategoryRadialButton("PC", R.drawable.icon_pc),
        CategoryRadialButton("PS4", R.drawable.icon_ps4),
        CategoryRadialButton("XBOX", R.drawable.icon_xbox),
        CategoryRadialButton("NINTENDO", R.drawable.icon_nintendo),
        CategoryRadialButton("MOBILE", R.drawable.icon_mobile),
    )

    val resultingActivityHandler = ResultingActivityHandler()


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

    fun clearForm() {
        state = state.copy(
            category = "",
            description = "",
            image = "",
            name = ""
        )
        createPostResponse = null
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