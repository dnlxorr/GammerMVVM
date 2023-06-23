package com.cas.gammermvvmapp.domain.repository

import com.cas.gammermvvmapp.domain.model.Response
import com.cas.gammermvvmapp.domain.model.User

interface UsersRepository {

    suspend fun createNewUser(user: User): Response<Boolean>
}