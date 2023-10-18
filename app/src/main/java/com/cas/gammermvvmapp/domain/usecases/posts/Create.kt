package com.cas.gammermvvmapp.domain.usecases.posts

import com.cas.gammermvvmapp.domain.model.Post
import com.cas.gammermvvmapp.domain.model.Response
import com.cas.gammermvvmapp.domain.repository.PostsRepository
import java.io.File
import javax.inject.Inject

class Create @Inject constructor(private val repository: PostsRepository) {
    suspend operator fun invoke(post: Post, file: File): Response<Boolean> {
        return repository.createPost(post, file)
    }
}