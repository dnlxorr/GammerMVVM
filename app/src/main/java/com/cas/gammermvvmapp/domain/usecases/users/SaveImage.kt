package com.cas.gammermvvmapp.domain.usecases.users

import com.cas.gammermvvmapp.domain.repository.UsersRepository
import java.io.File
import javax.inject.Inject

class SaveImage @Inject constructor(private val repository: UsersRepository) {


    suspend operator fun invoke(file: File) = repository.saveImage(file)
}