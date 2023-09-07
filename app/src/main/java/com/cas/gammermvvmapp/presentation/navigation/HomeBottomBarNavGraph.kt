package com.cas.gammermvvmapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cas.gammermvvmapp.presentation.screens.my_posts.MyPostsScreen
import com.cas.gammermvvmapp.presentation.screens.posts.PostsScreen
import com.cas.gammermvvmapp.presentation.screens.profile.ProfileScreen
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.List
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun HomeBottomBarNavGraph(navController: NavHostController){
    
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = HomeBottomBarScreen.Posts.route
    ) {

        composable(route = HomeBottomBarScreen.Posts.route){
            PostsScreen(navController = navController)
        }

        composable(route = HomeBottomBarScreen.MyPosts.route){
            MyPostsScreen(navController = navController)
        }

        composable(route = HomeBottomBarScreen.Profile.route){
            ProfileScreen(navHostController = navController)
        }
    }
}



sealed class HomeBottomBarScreen(
    val route:String,
    var title: String,
    var icon: ImageVector
){
    object Posts: HomeBottomBarScreen(
        route = "posts",
        title = "Posts",
        icon = Icons.Default.List
    )

    object MyPosts: HomeBottomBarScreen(
        route = "my_posts",
        title = "My Posts",
        icon = Icons.Outlined.List
    )

    object Profile: HomeBottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )
}