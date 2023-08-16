package com.cas.gammermvvmapp.data.repository

import com.cas.gammermvvmapp.domain.model.Response
import com.cas.gammermvvmapp.domain.model.User
import com.cas.gammermvvmapp.domain.repository.UsersRepository
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(private val usersRef: CollectionReference) :
    UsersRepository {
    override suspend fun createNewUser(user: User): Response<Boolean> {
        return try {
            user.password =""
            usersRef.document(user.id).set(user).await()
            Response.Success(true)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    override suspend fun updateUser(user:User): Response<Boolean> {
        return try {
            val map: MutableMap<String,Any> = HashMap()
            map["username"]=user.username
            map["image"]=user.image

            user.password =""
            usersRef.document(user.id).update(map).await()
            Response.Success(true)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }

    }

    override fun getUserById(id: String): Flow<User> = callbackFlow{
        val snapshotListener = usersRef.document(id).addSnapshotListener{snapshot, e->
            val user = snapshot?.toObject(User::class.java) ?: User()
            trySend(user)
        }

        awaitClose {
            snapshotListener.remove()
        }
    }
}