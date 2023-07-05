package com.cas.gammermvvmapp.di;

import com.cas.gammermvvmapp.data.repository.AuthRepositoryImpl;
import com.cas.gammermvvmapp.data.repository.UsersRepositoryImpl;
import com.cas.gammermvvmapp.domain.repository.AuthRepository;
import com.cas.gammermvvmapp.domain.repository.UsersRepository;
import com.cas.gammermvvmapp.domain.usecases.auth.*;
import com.cas.gammermvvmapp.domain.usecases.users.CreateNewUser;
import com.cas.gammermvvmapp.domain.usecases.users.GetUserById;
import com.cas.gammermvvmapp.domain.usecases.users.UsersUseCases;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.ktx.Firebase;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u0012H\u0007\u00a8\u0006\u0016"}, d2 = {"Lcom/cas/gammermvvmapp/di/AppModule;", "", "()V", "provideAuthRepository", "Lcom/cas/gammermvvmapp/domain/repository/AuthRepository;", "impl", "Lcom/cas/gammermvvmapp/data/repository/AuthRepositoryImpl;", "provideAuthUseCases", "Lcom/cas/gammermvvmapp/domain/usecases/auth/AuthUseCases;", "repository", "provideFirebaseAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "provideFirebaseFirestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "provideUsersRef", "Lcom/google/firebase/firestore/CollectionReference;", "db", "providesUsersRepository", "Lcom/cas/gammermvvmapp/domain/repository/UsersRepository;", "Lcom/cas/gammermvvmapp/data/repository/UsersRepositoryImpl;", "providesUsersUseCases", "Lcom/cas/gammermvvmapp/domain/usecases/users/UsersUseCases;", "app_debug"})
@dagger.Module
public final class AppModule {
    @org.jetbrains.annotations.NotNull
    public static final com.cas.gammermvvmapp.di.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.google.firebase.firestore.FirebaseFirestore provideFirebaseFirestore() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.google.firebase.firestore.CollectionReference provideUsersRef(@org.jetbrains.annotations.NotNull
    com.google.firebase.firestore.FirebaseFirestore db) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.google.firebase.auth.FirebaseAuth provideFirebaseAuth() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.cas.gammermvvmapp.domain.repository.AuthRepository provideAuthRepository(@org.jetbrains.annotations.NotNull
    com.cas.gammermvvmapp.data.repository.AuthRepositoryImpl impl) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.cas.gammermvvmapp.domain.repository.UsersRepository providesUsersRepository(@org.jetbrains.annotations.NotNull
    com.cas.gammermvvmapp.data.repository.UsersRepositoryImpl impl) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.cas.gammermvvmapp.domain.usecases.auth.AuthUseCases provideAuthUseCases(@org.jetbrains.annotations.NotNull
    com.cas.gammermvvmapp.domain.repository.AuthRepository repository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.cas.gammermvvmapp.domain.usecases.users.UsersUseCases providesUsersUseCases(@org.jetbrains.annotations.NotNull
    com.cas.gammermvvmapp.domain.repository.UsersRepository repository) {
        return null;
    }
}