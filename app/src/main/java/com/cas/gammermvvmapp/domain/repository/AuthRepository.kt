package com.cas.gammermvvmapp.domain.repository

import com.cas.gammermvvmapp.domain.model.Response
import com.cas.gammermvvmapp.domain.model.User
import com.google.firebase.auth.FirebaseUser

interface AuthRepository {

    val currentUser:FirebaseUser?
    suspend fun login(email:String, password:String):Response<FirebaseUser>
    suspend fun signUp(user:User): Response<FirebaseUser>
    fun logout()

}