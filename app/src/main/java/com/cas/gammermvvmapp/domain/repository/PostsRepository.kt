package com.cas.gammermvvmapp.domain.repository

import com.cas.gammermvvmapp.domain.model.Post
import com.cas.gammermvvmapp.domain.model.Response
import java.io.File

interface PostsRepository{
 suspend fun createPost(post: Post, file: File): Response<Boolean>
}