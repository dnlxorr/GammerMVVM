package com.cas.gammermvvmapp.presentation.screens.profile_edit.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.cas.gammermvvmapp.R
import com.cas.gammermvvmapp.presentation.Darkgray500
import com.cas.gammermvvmapp.presentation.DefaultButton
import com.cas.gammermvvmapp.presentation.DefaultTextField
import com.cas.gammermvvmapp.presentation.Red500
import com.cas.gammermvvmapp.presentation.screens.profile_edit.ProfileEditViewModel
import com.cas.gammermvvmapp.presentation.screens.signup.SignupViewModel
@Composable
fun ProfileEditContent (
        navHostController: NavHostController,
        profielEditViewModel: ProfileEditViewModel = hiltViewModel()
    ) {

        val state = profielEditViewModel.state

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
                        text = "Change username",
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
                        value = state.username,
                        onValueChange = { profielEditViewModel.onUsernameInput(it) },
                        label = "User Name",
                        icon = Icons.Default.Person,
                        errorMsg = profielEditViewModel.usernameErrorMsg,
                        validateField = { profielEditViewModel.validateUsername() }
                    )


                    DefaultButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp, bottom = 40.dp),
                        text = "UPDATE",
                        onClick = { profielEditViewModel.onUpdateUser()},
                    )

                }

            }
        }


    }
