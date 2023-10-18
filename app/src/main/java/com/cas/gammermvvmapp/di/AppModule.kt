package com.cas.gammermvvmapp.di

import com.cas.gammermvvmapp.core.Constants.POSTS
import com.cas.gammermvvmapp.core.Constants.USERS
import com.cas.gammermvvmapp.data.repository.AuthRepositoryImpl
import com.cas.gammermvvmapp.data.repository.PostsRepositoryImpl
import com.cas.gammermvvmapp.data.repository.UsersRepositoryImpl
import com.cas.gammermvvmapp.domain.repository.AuthRepository
import com.cas.gammermvvmapp.domain.repository.PostsRepository
import com.cas.gammermvvmapp.domain.repository.UsersRepository
import com.cas.gammermvvmapp.domain.usecases.auth.*
import com.cas.gammermvvmapp.domain.usecases.posts.Create
import com.cas.gammermvvmapp.domain.usecases.posts.PostsUseCases
import com.cas.gammermvvmapp.domain.usecases.users.CreateNewUser
import com.cas.gammermvvmapp.domain.usecases.users.GetUserById
import com.cas.gammermvvmapp.domain.usecases.users.SaveImage
import com.cas.gammermvvmapp.domain.usecases.users.UpdateUser
import com.cas.gammermvvmapp.domain.usecases.users.UsersUseCases
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    fun provideFirebaseFirestore(): FirebaseFirestore = Firebase.firestore

    @Provides
    fun provideFirebaseStorage(): FirebaseStorage = FirebaseStorage.getInstance()

    @Provides
    @Named(USERS)
    fun provideStorageUsersRef(storage: FirebaseStorage): StorageReference = storage.reference.child(
        USERS)

    @Provides
    @Named(USERS)
    fun provideUsersRef(db: FirebaseFirestore): CollectionReference = db.collection(USERS)

    @Provides
    @Named(POSTS)
    fun provideStoragePostsRef(storage: FirebaseStorage): StorageReference = storage.reference.child(POSTS)

    @Provides
    @Named(POSTS)
    fun providePostsRef(db: FirebaseFirestore): CollectionReference = db.collection(POSTS)

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl

    @Provides
    fun providesUsersRepository(impl: UsersRepositoryImpl): UsersRepository = impl

    @Provides
    fun providesPostsRepository(impl: PostsRepositoryImpl): PostsRepository = impl

    @Provides
    fun provideAuthUseCases(repository: AuthRepository) = AuthUseCases(
        getCurrentUser = GetCurrentUser(repository),
        login = Login(repository),
        logout = Logout(repository),
        signup = Signup(repository)
    )

    @Provides
    fun providesUsersUseCases(repository: UsersRepository) = UsersUseCases(
        createNewUser = CreateNewUser(repository),
        updateUser = UpdateUser(repository),
        getUserById = GetUserById(repository),
        saveImage = SaveImage(repository)
    )

    @Provides
    fun providesPostsUseCases(repository: PostsRepository) = PostsUseCases(
        create = Create(repository),
    )
}