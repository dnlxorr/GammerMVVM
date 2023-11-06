package com.cas.gammermvvmapp.domain.usecases.posts

import com.optic.gamermvvmapp.domain.use_cases.posts.DeleteLikePost
import com.optic.gamermvvmapp.domain.use_cases.posts.DeletePost
import com.optic.gamermvvmapp.domain.use_cases.posts.GetPostsByIdUser
import com.optic.gamermvvmapp.domain.use_cases.posts.LikePost
import com.optic.gamermvvmapp.domain.use_cases.posts.UpdatePost

data class PostsUseCases(
    val create: Create,
    val getPosts: GetPosts,
    val getPostsByIdUser: GetPostsByIdUser,
    val deletePost: DeletePost,
    val updatePost: UpdatePost,
    val likePost: LikePost,
    val deleteLikePost: DeleteLikePost
)
