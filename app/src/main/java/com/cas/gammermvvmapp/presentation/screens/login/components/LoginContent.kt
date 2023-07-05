package com.cas.gammermvvmapp.presentation.screens.login.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cas.gammermvvmapp.R
import com.cas.gammermvvmapp.domain.model.Response
import com.cas.gammermvvmapp.presentation.DefaultButton
import com.cas.gammermvvmapp.presentation.DefaultTextField
import com.cas.gammermvvmapp.presentation.Darkgray500
import com.cas.gammermvvmapp.presentation.GammerMVVMAppTheme
import com.cas.gammermvvmapp.presentation.Red500
import com.cas.gammermvvmapp.presentation.navigation.AppScreen
import com.cas.gammermvvmapp.presentation.screens.login.viewmodel.LoginViewModel

@Composable
fun LoginContent(navHostController: NavHostController, viewModel: LoginViewModel = hiltViewModel()) {

    val loginFlow = viewModel.loginFlow.collectAsState()


    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .height(280.dp)
                .background(Red500)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier.height(130.dp),
                    painter = painterResource(id = R.drawable.control),
                    contentDescription = "Control de XBox 360"
                )
                Text(text = "FIREBASE MVVM")
            }
        }
        Card(
            modifier = Modifier.padding(start = 40.dp, end = 40.dp, top = 200.dp),
            backgroundColor = Darkgray500
        ) {
            Column(modifier = Modifier.padding(horizontal = 20.dp)) {

                Text(
                    modifier = Modifier.padding(
                        top = 30.dp,
                        bottom = 0.dp,
                        start = 0.dp,
                        end = 0.dp
                    ),
                    text = "LOGIN",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Please login to continue", fontSize = 12.sp, color = Color.Gray)
                DefaultTextField(
                    modifier = Modifier.padding(top = 25.dp),
                    value = viewModel.email.value,
                    onValueChange = { value -> viewModel.email.value = value },
                    label = "Email",
                    icon = Icons.Default.Email,
                    keyboardType = KeyboardType.Email,
                    errorMsg = viewModel.emailErrorMsg.value,
                    validateField = {
                        viewModel.validateEmail()
                    }


                )
                DefaultTextField(
                    modifier = Modifier.padding(top = 5.dp),
                    value = viewModel.password.value,
                    onValueChange = { viewModel.password.value = it },
                    label = "Password",
                    icon = Icons.Default.Lock,
                    keyboardType = KeyboardType.Password,
                    hideText = true,
                    errorMsg = viewModel.passwordErrorMsg.value,
                    validateField = {
                        viewModel.validatePassword()
                    }
                )

                DefaultButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp),
                    text = "Login",
                    onClick = { viewModel.login() },
                    enable = viewModel.isEnabledLoginButton
                )

            }

        }
    }

    loginFlow.value.let { state ->
        when (state) {
            //Mostrar barra loading
            Response.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,

                    ) {
                    CircularProgressIndicator()
                }
            }

            is Response.Failure -> Toast.makeText(
                LocalContext.current,
                state.exception?.message ?: "Unknown error", Toast.LENGTH_LONG
            ).show()

            is Response.Success -> {
                LaunchedEffect(Unit){
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
            LoginContent(rememberNavController())
        }
    }
}