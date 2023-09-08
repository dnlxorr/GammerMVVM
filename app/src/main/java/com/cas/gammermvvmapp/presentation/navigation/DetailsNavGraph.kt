package com.cas.gammermvvmapp.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.cas.gammermvvmapp.presentation.screens.profile_edit.ProfileEditScreen

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController){
    navigation(
        route=Graph.DETAILS,
        startDestination = DetailsScreen.ProfileEdit.route
    ){
        composable(
            route = DetailsScreen.ProfileEdit.route,
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

sealed class DetailsScreen(val route:String){
    object ProfileEdit:DetailsScreen(route = "profile/edit/{user}"){
            fun passUser(user:String) = "profile/edit/$user"

    }
}