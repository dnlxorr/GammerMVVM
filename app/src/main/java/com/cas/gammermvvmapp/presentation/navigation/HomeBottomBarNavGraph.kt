package com.cas.gammermvvmapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cas.gammermvvmapp.presentation.screens.my_posts.MyPostsScreen
import com.cas.gammermvvmapp.presentation.screens.posts.PostsScreen
import com.cas.gammermvvmapp.presentation.screens.profile.ProfileScreen

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