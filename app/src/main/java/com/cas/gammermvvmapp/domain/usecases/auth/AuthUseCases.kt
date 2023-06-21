package com.cas.gammermvvmapp.domain.usecases.auth



data class AuthUseCases (

    val getCurrentUser:GetCurrentUser,
    val login: Login,
    val logout: Logout,
    val signup: Signup
    )