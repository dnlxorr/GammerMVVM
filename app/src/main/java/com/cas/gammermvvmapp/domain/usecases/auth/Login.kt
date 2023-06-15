package com.cas.gammermvvmapp.domain.usecases.auth

import com.cas.gammermvvmapp.data.repository.AuthRepositoryImpl
import com.cas.gammermvvmapp.domain.repository.AuthRepository
import javax.inject.Inject

class Login @Inject constructor(private val repository: AuthRepository){

    suspend operator fun invoke(email: String, password: String) = repository.login(email, password)
}