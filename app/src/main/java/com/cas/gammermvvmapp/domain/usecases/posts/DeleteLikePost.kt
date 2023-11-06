package com.optic.gamermvvmapp.domain.use_cases.posts

import com.optic.gamermvvmapp.domain.model.Post
import com.optic.gamermvvmapp.domain.repository.PostsRepository
import java.io.File
import javax.inject.Inject

class DeleteLikePost @Inject constructor(private val repository: PostsRepository){

    suspend operator fun invoke(idPost: String, idUser: String) = repository.deleteLike(idPost, idUser)

}