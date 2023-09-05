package com.cas.gammermvvmapp.presentation.screens.profile_edit

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.cas.gammermvvmapp.domain.usecases.users.UpdateUser
import com.cas.gammermvvmapp.presentation.components.DefaultTopBar
import com.cas.gammermvvmapp.presentation.screens.profile.components.ProfileContent
import com.cas.gammermvvmapp.presentation.screens.profile_edit.components.ProfileEditContent
import com.cas.gammermvvmapp.presentation.screens.profile_edit.components.SaveImage
import com.cas.gammermvvmapp.presentation.screens.profile_edit.components.Update
import com.cas.gammermvvmapp.presentation.screens.signup.components.SignUpContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileEditScreen(
    navHostController: NavHostController,
    user: String){

    Scaffold(topBar = { DefaultTopBar(title = "Edit Profile", upAvailable = true, navHostController = navHostController) },
        content = {
            ProfileEditContent(navHostController)
        },
        bottomBar = {}
    )
    SaveImage()
    Update()
}