package com.cas.gammermvvmapp.presentation.screens.signup

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cas.gammermvvmapp.presentation.components.DefaultTopBar
import com.cas.gammermvvmapp.presentation.screens.signup.components.SignUpContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SignUpScreen(navHostController: NavHostController) {
    Scaffold(topBar = { DefaultTopBar(title = "New User", upAvailable = true, navHostController = navHostController)},
            content = {
                SignUpContent(navHostController)
                },
            bottomBar = {})
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewSignUpScreen(){
    SignUpScreen(rememberNavController())
}