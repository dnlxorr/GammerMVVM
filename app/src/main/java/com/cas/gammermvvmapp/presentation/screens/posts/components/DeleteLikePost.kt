package com.cas.gammermvvmapp.presentation.screens.posts.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.cas.gammermvvmapp.domain.model.Response
import com.cas.gammermvvmapp.presentation.screens.login.components.ProgressBar
import com.cas.gammermvvmapp.presentation.screens.posts.PostsViewModel

@Composable
fun DeleteLikePost(viewModel: PostsViewModel = hiltViewModel()) {

    when(val response = viewModel.deleteLikeResponse) {
        // MOSTRAR QUE SE ESTA REALIZANDO LA PETICION Y TODAVIA ESTA EN PROCESO
        Response.Loading -> {
            ProgressBar()
        }
        is Response.Success -> {

        }
        is Response.Failure -> {
            Toast.makeText(LocalContext.current, response.exception?.message ?: "Error desconido", Toast.LENGTH_LONG).show()
        }

        else -> {}
    }

}