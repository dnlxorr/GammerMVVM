package com.cas.gammermvvmapp.presentation.navigation

sealed class AppScreen(val route:String) {

    object Login:AppScreen(route = "login")
    object SignUp:AppScreen(route = "signup")
    object Profile:AppScreen(route = "profile")

}
