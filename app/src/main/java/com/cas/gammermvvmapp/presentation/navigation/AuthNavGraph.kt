package com.cas.gammermvvmapp.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.cas.gammermvvmapp.presentation.screens.login.LogingScreen
import com.cas.gammermvvmapp.presentation.screens.signup.SignUpScreen

fun NavGraphBuilder.authNavGraph(navController: NavHostController){
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Login.route
    ){
        composable(route = AuthScreen.Login.route){
            LogingScreen(navController)
        }
        composable(route = AuthScreen.SignUp.route){
            SignUpScreen(navHostController = navController)
        }
    }
}

sealed class AuthScreen(val route:String) {

    object Login:AuthScreen(route = "login")
    object SignUp:AuthScreen(route = "signup")



    object Profile:AuthScreen(route = "profile")
    object ProfileEdit:AuthScreen(route = "profile/edit/{user}"){
        fun passUser(user:String) = "profile/edit/$user"
    }

}