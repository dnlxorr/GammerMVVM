package com.cas.gammermvvmapp.presentation.screens.login.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.cas.gammermvvmapp.domain.model.Response
import com.cas.gammermvvmapp.presentation.navigation.AppScreen
import com.cas.gammermvvmapp.presentation.screens.login.viewmodel.LoginViewModel

@Composable
fun Login(navHostController: NavHostController,viewModel: LoginViewModel = hiltViewModel()){
    when (val loginResponse = viewModel.loginResponse) {
        //Mostrar barra loading
        Response.Loading -> {
            ProgressBar()
        }

        is Response.Failure -> Toast.makeText(
            LocalContext.current,
            loginResponse.exception?.message ?: "Unknown error", Toast.LENGTH_LONG
        ).show()

        is Response.Success -> {
            LaunchedEffect(Unit) {
                navHostController.navigate(route = AppScreen.Profile.route)
            }
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