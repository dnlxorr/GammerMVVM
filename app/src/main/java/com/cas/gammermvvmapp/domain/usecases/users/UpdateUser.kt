package com.cas.gammermvvmapp.domain.usecases.users

import com.cas.gammermvvmapp.domain.repository.UsersRepository
import javax.inject.Inject

class UpdateUser @Inject constructor(private val repository: UsersRepository) {
    suspend operator fun invoke(user: User) = repository.update(user)

}