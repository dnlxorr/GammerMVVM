package com.cas.gammermvvmapp.domain.repository

import com.cas.gammermvvmapp.domain.model.Response
import com.cas.gammermvvmapp.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UsersRepository {

    suspend fun createNewUser(user: User): Response<Boolean>
    suspend fun updateUser(user:User): Response<Boolean>
    fun getUserById(id:String): Flow<User>
}