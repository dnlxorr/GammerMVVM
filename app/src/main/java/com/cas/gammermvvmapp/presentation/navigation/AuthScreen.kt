package com.cas.gammermvvmapp.presentation.navigation

sealed class AuthScreen(val route:String) {

    object Login:AuthScreen(route = "login")
    object SignUp:AuthScreen(route = "signup")



    object Profile:AuthScreen(route = "profile")
    object ProfileEdit:AuthScreen(route = "profile/edit/{user}"){
        fun passUser(user:String) = "profile/edit/$user"
    }

}
