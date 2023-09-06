package com.cas.gammermvvmapp.presentation.screens.my_posts

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyPostsScreen(navController: NavHostController){
    Scaffold (
        content = {
            Text(text = "MyPostsScreen")
        }
    )
}