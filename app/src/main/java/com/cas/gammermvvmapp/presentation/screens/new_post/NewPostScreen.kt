package com.cas.gammermvvmapp.presentation.screens.new_post

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.cas.gammermvvmapp.presentation.DefaultButton
import com.cas.gammermvvmapp.presentation.components.DefaultTopBar
import com.cas.gammermvvmapp.presentation.screens.new_post.components.NewPostContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NewPostScreen(navController: NavHostController, viewModel: NewPostViewModel = hiltViewModel()) {

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
        },
        bottomBar = {
            DefaultButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Post",
                onClick = { viewModel.onNewPost() })
        }
    )
}