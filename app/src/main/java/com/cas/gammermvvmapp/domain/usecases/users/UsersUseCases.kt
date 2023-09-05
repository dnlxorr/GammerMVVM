package com.cas.gammermvvmapp.domain.usecases.users

data class UsersUseCases(
    val createNewUser: CreateNewUser,
    val updateUser: UpdateUser,
    val getUserById: GetUserById,
    val saveImage: SaveImage
)
