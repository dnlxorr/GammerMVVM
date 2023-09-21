package com.cas.gammermvvmapp.presentation.screens.new_post

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.cas.gammermvvmapp.presentation.components.DefaultTopBar
import com.cas.gammermvvmapp.presentation.screens.new_post.components.NewPostContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NewPostScreen(navController: NavHostController) {

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "New Post",
                upAvailable = true,
                navHostController = navController
            )
        },
        content = {
            NewPostContent()
        }
    )
}