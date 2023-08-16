package com.cas.gammermvvmapp.di

import com.cas.gammermvvmapp.core.Constants.USERS
import com.cas.gammermvvmapp.data.repository.AuthRepositoryImpl
import com.cas.gammermvvmapp.data.repository.UsersRepositoryImpl
import com.cas.gammermvvmapp.domain.repository.AuthRepository
import com.cas.gammermvvmapp.domain.repository.UsersRepository
import com.cas.gammermvvmapp.domain.usecases.auth.*
import com.cas.gammermvvmapp.domain.usecases.users.CreateNewUser
import com.cas.gammermvvmapp.domain.usecases.users.GetUserById
import com.cas.gammermvvmapp.domain.usecases.users.UpdateUser
import com.cas.gammermvvmapp.domain.usecases.users.UsersUseCases
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    fun provideFirebaseFirestore(): FirebaseFirestore = Firebase.firestore

    @Provides
    fun provideUsersRef(db: FirebaseFirestore): CollectionReference = db.collection(USERS)

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl

    @Provides
    fun providesUsersRepository(impl: UsersRepositoryImpl): UsersRepository = impl

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
        getUserById = GetUserById(repository)
    )
}