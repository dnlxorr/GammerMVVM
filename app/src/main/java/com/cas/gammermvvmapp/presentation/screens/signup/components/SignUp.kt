package com.cas.gammermvvmapp.presentation.screens.signup.components

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
import com.cas.gammermvvmapp.presentation.navigation.AuthScreen
import com.cas.gammermvvmapp.presentation.screens.signup.SignupViewModel

@Composable
fun SignUp(navHostController: NavHostController, signupViewModel: SignupViewModel = hiltViewModel()) {
    when (val signupResponse = signupViewModel.signupResponse) {
        Response.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                CircularProgressIndicator()
            }
        }

        is Response.Success -> {
            LaunchedEffect(Unit) {
                signupViewModel.createUser()
                navHostController.popBackStack(AuthScreen.Login.route, inclusive = true)
                navHostController.navigate(route = AuthScreen.Profile.route)
            }
        }

        is Response.Failure -> {
            Toast.makeText(
                LocalContext.current,
                signupResponse.exception?.message ?: "Unknown erorr",
                Toast.LENGTH_LONG
            ).show()
        }

        else -> {}
    }
}