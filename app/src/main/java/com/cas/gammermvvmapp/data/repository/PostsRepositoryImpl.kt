package com.cas.gammermvvmapp.data.repository

import android.net.Uri
import com.cas.gammermvvmapp.core.Constants.POSTS
import com.cas.gammermvvmapp.domain.model.Post
import com.cas.gammermvvmapp.domain.model.Response
import com.cas.gammermvvmapp.domain.repository.PostsRepository
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import java.io.File
import javax.inject.Inject
import javax.inject.Named

class PostsRepositoryImpl @Inject constructor(
    @Named(POSTS)
    private val postsRef: CollectionReference,
    @Named(POSTS)
    private val storagePostsRef: StorageReference
) : PostsRepository {
    override fun getPosts(): Flow<Response<List<Post>>> = callbackFlow {
        val snapshotListener = postsRef.addSnapshotListener{ snapshot, e->
            val postResponse = if(snapshot != null){
                val posts = snapshot.toObjects(Post::class.java)
                Response.Success(posts)
            }else{
                Response.Failure(e)
            }
            trySend(postResponse)
        }
        awaitClose {
            snapshotListener.remove()
        }

    }

    override suspend fun createPost(post: Post, file: File): Response<Boolean> {
        return try {
            val fromFile = Uri.fromFile(file)
            val ref = storagePostsRef.child(file.name)
            val uploadTask = ref.putFile(fromFile).await()
            val url = ref.downloadUrl.await()
            post.image = url.toString()
            postsRef.add(post).await()
            Response.Success(true)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }

}