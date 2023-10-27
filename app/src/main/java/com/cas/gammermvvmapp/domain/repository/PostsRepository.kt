package com.cas.gammermvvmapp.domain.repository

import com.cas.gammermvvmapp.domain.model.Post
import com.cas.gammermvvmapp.domain.model.Response
import kotlinx.coroutines.flow.Flow
import java.io.File

interface PostsRepository{

 fun getPosts(): Flow<Response<List<Post>>>
 suspend fun createPost(post: Post, file: File): Response<Boolean>
}