package com.cas.gammermvvmapp.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cas.gammermvvmapp.presentation.GammerMVVMAppTheme
import com.cas.gammermvvmapp.presentation.Red500
import com.cas.gammermvvmapp.presentation.screens.login.LogingScreen
import com.cas.gammermvvmapp.presentation.screens.signup.SignUpScreen

@Composable
fun DefaultTopBar(
    title: String,
    upAvailable: Boolean,
    navHostController: NavHostController? = null//  NULL SAFETY: Avoid null pointer exception
) {

    TopAppBar(
        title = {
            Text(
                text = title,
                fontSize = 19.sp
            )
        },
        backgroundColor = Red500,
        navigationIcon = {
            if (upAvailable) {
                IconButton(onClick = { navHostController?.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            }

        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewSignUpScreen(){
    GammerMVVMAppTheme(darkTheme = true) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            SignUpScreen(navHostController = rememberNavController())
        }
    }
}