package com.cas.gammermvvmapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.cas.gammermvvmapp.presentation.screens.home.HomeScreen
import com.cas.gammermvvmapp.presentation.screens.profile.ProfileScreen
import com.cas.gammermvvmapp.presentation.screens.profile_edit.ProfileEditScreen

@Composable
fun RootNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ){

        authNavGraph(navController)

        composable(route = RootScreen.Home.route){
            HomeScreen()
        }

        composable(
            route = AuthScreen.ProfileEdit.route,
            arguments = listOf(navArgument("user"){
                type = NavType.StringType
            })
        ){
            it.arguments?.getString("user")?.let {
                ProfileEditScreen(navHostController = navController,it)
            }
        }
    }

}

sealed class RootScreen(val route:String){
    object Home: RootScreen("home")
}