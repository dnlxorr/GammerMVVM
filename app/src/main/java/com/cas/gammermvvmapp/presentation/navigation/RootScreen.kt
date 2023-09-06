package com.cas.gammermvvmapp.presentation.navigation

sealed class RootScreen(val route:String){
    object Home: RootScreen("home")
}
