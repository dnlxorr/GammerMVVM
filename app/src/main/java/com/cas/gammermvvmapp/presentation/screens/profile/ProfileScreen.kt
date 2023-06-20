package com.cas.gammermvvmapp.presentation.screens.profile

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.cas.gammermvvmapp.presentation.DefaultButton
import com.cas.gammermvvmapp.presentation.navigation.AppScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileScreen(
    navHostController: NavHostController,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {},
        content = {
            DefaultButton(
                modifier = Modifier,
                text = "Cerrar Sesion",
                onClick = {
                    viewModel.logout()
                    navHostController.navigate(AppScreen.Login.route){
                        popUpTo(AppScreen.Profile.route){inclusive = true }
                    }
                }
            )
        },
        bottomBar = {}
    )
}