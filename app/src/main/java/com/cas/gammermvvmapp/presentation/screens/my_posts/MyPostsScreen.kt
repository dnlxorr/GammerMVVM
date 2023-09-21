package com.cas.gammermvvmapp.presentation.screens.my_posts

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.cas.gammermvvmapp.presentation.navigation.DetailsScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyPostsScreen(navController: NavHostController){
    Scaffold (
        content = {
            Text(text = "MyPostsScreen")
        },
        floatingActionButton = {

            FloatingActionButton(
                modifier = Modifier.padding(bottom = 50.dp),
                onClick = { navController.navigate(DetailsScreen.NewPost.route)}
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "")
            }
        }
    )
}