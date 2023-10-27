package com.cas.gammermvvmapp.domain.usecases.posts

import com.cas.gammermvvmapp.domain.repository.PostsRepository
import javax.inject.Inject

class GetPosts @Inject constructor(private val repository: PostsRepository) {
    operator fun invoke() = repository.getPosts()
}