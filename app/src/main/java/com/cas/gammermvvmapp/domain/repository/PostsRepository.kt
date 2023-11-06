package com.cas.gammermvvmapp.domain.repository

import com.cas.gammermvvmapp.domain.model.Post
import com.cas.gammermvvmapp.domain.model.Response
import kotlinx.coroutines.flow.Flow
import java.io.File

interface PostsRepository{

 fun getPostsByUserId(idUser: String): Flow<Response<List<Post>>>
 fun getPosts(): Flow<Response<List<Post>>>
 suspend fun createPost(post: Post, file: File): Response<Boolean>
 suspend fun update(post: Post, file: File?): Response<Boolean>
 suspend fun delete(idPost: String): Response<Boolean>
 suspend fun like(idPost: String, idUser: String): Response<Boolean>
 suspend fun deleteLike(idPost: String, idUser: String): Response<Boolean>

}