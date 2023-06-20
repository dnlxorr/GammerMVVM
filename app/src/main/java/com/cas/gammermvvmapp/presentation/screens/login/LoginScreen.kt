package com.cas.gammermvvmapp.presentation.screens.login

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cas.gammermvvmapp.presentation.screens.login.components.LoginBottomBar
import com.cas.gammermvvmapp.presentation.screens.login.components.LoginContent
import com.cas.gammermvvmapp.presentation.GammerMVVMAppTheme
import com.cas.gammermvvmapp.presentation.screens.login.viewmodel.LoginViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LogingScreen(navHostController: NavHostController) {

    Scaffold(
        topBar = {},
        content = {
            LoginContent(navHostController)
        },
        bottomBar = { LoginBottomBar(navHostController) }
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    GammerMVVMAppTheme(darkTheme = true) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            LogingScreen(rememberNavController())
        }
    }
}