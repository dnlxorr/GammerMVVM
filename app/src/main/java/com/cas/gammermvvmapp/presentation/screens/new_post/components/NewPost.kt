package com.cas.gammermvvmapp.presentation.screens.new_post.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.cas.gammermvvmapp.domain.model.Response
import com.cas.gammermvvmapp.presentation.navigation.AuthScreen
import com.cas.gammermvvmapp.presentation.navigation.Graph
import com.cas.gammermvvmapp.presentation.screens.login.components.ProgressBar
import com.cas.gammermvvmapp.presentation.screens.login.viewmodel.LoginViewModel
import com.cas.gammermvvmapp.presentation.screens.new_post.NewPostViewModel

@Composable
fun NewPost(viewModel: NewPostViewModel = hiltViewModel()){
    when (val response = viewModel.createPostResponse) {
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
            viewModel.clearForm()
            Toast.makeText(
                LocalContext.current,
                "Post created sussessfully!",
                Toast.LENGTH_LONG
            ).show()
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