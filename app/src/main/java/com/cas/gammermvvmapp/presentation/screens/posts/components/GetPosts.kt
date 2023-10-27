package com.cas.gammermvvmapp.presentation.screens.posts.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.cas.gammermvvmapp.domain.model.Response
import com.cas.gammermvvmapp.presentation.screens.login.components.ProgressBar
import com.cas.gammermvvmapp.presentation.screens.posts.PostsViewModel

@Composable
fun GetPosts(viewModel: PostsViewModel = hiltViewModel()) {

    when (val response = viewModel.postsResponse) {
        //Mostrar barra loading
        Response.Loading -> {
            ProgressBar()
        }

        is Response.Failure -> Toast.makeText(
            LocalContext.current,
            response.exception?.message ?: "Unknown error",
            Toast.LENGTH_LONG
        ).show()

        is Response.Success -> {
            PostsContent(posts = response.data)
        }

        null -> {
            Toast.makeText(
                LocalContext.current,
                "Context null Login",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}