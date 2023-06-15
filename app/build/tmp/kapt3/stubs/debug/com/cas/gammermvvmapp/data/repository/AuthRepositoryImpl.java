package com.cas.gammermvvmapp.data.repository;

import com.cas.gammermvvmapp.domain.model.Response;
import com.cas.gammermvvmapp.domain.repository.AuthRepository;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\'\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/cas/gammermvvmapp/data/repository/AuthRepositoryImpl;", "Lcom/cas/gammermvvmapp/domain/repository/AuthRepository;", "firebaseAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "(Lcom/google/firebase/auth/FirebaseAuth;)V", "currentUser", "Lcom/google/firebase/auth/FirebaseUser;", "getCurrentUser", "()Lcom/google/firebase/auth/FirebaseUser;", "login", "Lcom/cas/gammermvvmapp/domain/model/Response;", "email", "", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class AuthRepositoryImpl implements com.cas.gammermvvmapp.domain.repository.AuthRepository {
    private final com.google.firebase.auth.FirebaseAuth firebaseAuth = null;
    
    @javax.inject.Inject()
    public AuthRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseAuth firebaseAuth) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public com.google.firebase.auth.FirebaseUser getCurrentUser() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object login(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.cas.gammermvvmapp.domain.model.Response<? extends com.google.firebase.auth.FirebaseUser>> continuation) {
        return null;
    }
}