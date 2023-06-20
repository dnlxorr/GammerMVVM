package com.cas.gammermvvmapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cas.gammermvvmapp.presentation.screens.login.LogingScreen
import com.cas.gammermvvmapp.presentation.screens.profile.ProfileScreen
import com.cas.gammermvvmapp.presentation.screens.signup.SignUpScreen

@Composable
fun AppNavigation(navHostController: NavHostController) {

    NavHost(navController = navHostController, startDestination = AppScreen.Login.route){
        composable(route = AppScreen.Login.route){
            LogingScreen(navHostController)
        }
        composable(route = AppScreen.SignUp.route){
            SignUpScreen(navHostController = navHostController)
        }
        composable(route = AppScreen.Profile.route){
            ProfileScreen(navHostController = navHostController)
        }
    }

}