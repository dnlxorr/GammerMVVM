package com.cas.gammermvvmapp.presentation.screens.signup.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Lock
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
import com.cas.gammermvvmapp.presentation.screens.signup.SignupViewModel

@Composable
fun SignUpContent(
    navHostController: NavHostController,
    signupViewModel: SignupViewModel = hiltViewModel()
) {

    val signupFlow = signupViewModel.signupFlow.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .height(230.dp)
                .background(Red500)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Image(
                    modifier = Modifier.height(80.dp),
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = "User Image"
                )
            }
        }
        Card(
            modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 130.dp),
            backgroundColor = Darkgray500
        ) {
            Column(modifier = Modifier.padding(horizontal = 20.dp)) {

                Text(
                    modifier = Modifier.padding(
                        top = 20.dp,
                        bottom = 0.dp,
                        start = 0.dp,
                        end = 0.dp
                    ),
                    text = "Sign Up",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Please fill the fields to continue",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
                DefaultTextField(
                    modifier = Modifier.padding(top = 8.dp),
                    value = signupViewModel.username.value,
                    onValueChange = { value -> signupViewModel.username.value = value },
                    label = "User Name",
                    icon = Icons.Default.Person,
                    errorMsg = signupViewModel.usernameErrorMsg.value,
                    validateField = { signupViewModel.validateUsername() }
                )
                DefaultTextField(
                    modifier = Modifier.padding(top = 0.dp),
                    value = signupViewModel.email.value,
                    onValueChange = { value -> signupViewModel.email.value = value },
                    label = "Email",
                    icon = Icons.Default.Email,
                    keyboardType = KeyboardType.Email,
                    errorMsg = signupViewModel.emailErrorMsg.value,
                    validateField = { signupViewModel.validateEmail() }
                )
                DefaultTextField(
                    modifier = Modifier.padding(top = 0.dp),
                    value = signupViewModel.password.value,
                    onValueChange = { signupViewModel.password.value = it },
                    label = "Password",
                    icon = Icons.Default.Lock,
                    keyboardType = KeyboardType.Password,
                    hideText = true,
                    errorMsg = signupViewModel.passwordErrorMsg.value,
                    validateField = { signupViewModel.validatePassword() }
                )
                DefaultTextField(
                    modifier = Modifier.padding(top = 0.dp),
                    value = signupViewModel.confirmPassword.value,
                    onValueChange = { signupViewModel.confirmPassword.value = it },
                    label = "Confirm Password",
                    icon = Icons.Outlined.Lock,
                    keyboardType = KeyboardType.Password,
                    hideText = true,
                    errorMsg = signupViewModel.confirmPasswordErrorMsg.value,
                    validateField = { signupViewModel.validateConfirmPassword() }
                )

                DefaultButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    text = "SIGN UP",
                    onClick = { signupViewModel.onSignup() },
                    enable = signupViewModel.isEnabledSignupButton
                )

            }

        }
    }
    signupFlow.value.let {
        when (it) {
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
                    navHostController.popBackStack(AppScreen.Login.route, inclusive = true)
                    navHostController.navigate(route = AppScreen.Profile.route)
                }
            }

            is Response.Failure -> {
                Toast.makeText(
                    LocalContext.current,
                    it.exception?.message ?: "Unknown erorr",
                    Toast.LENGTH_LONG
                ).show()
            }
            else -> {}
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
            SignUpContent(rememberNavController())
        }
    }
}