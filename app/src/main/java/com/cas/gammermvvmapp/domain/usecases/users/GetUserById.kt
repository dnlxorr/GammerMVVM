package com.cas.gammermvvmapp.domain.usecases.users

import com.cas.gammermvvmapp.domain.repository.UsersRepository
import javax.inject.Inject

class GetUserById @Inject constructor(private val repository: UsersRepository){

    operator fun invoke(id:String) = repository.getUserById(id)
}