package com.cas.gammermvvmapp.domain.usecases.auth

import com.cas.gammermvvmapp.domain.model.User
import com.cas.gammermvvmapp.domain.repository.AuthRepository
import javax.inject.Inject

class Signup @Inject constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(user: User) = repository.signUp(user)

}