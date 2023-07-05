package com.cas.gammermvvmapp.domain.usecases.auth;

import com.cas.gammermvvmapp.data.repository.AuthRepositoryImpl;
import com.cas.gammermvvmapp.domain.repository.AuthRepository;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0086B\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/cas/gammermvvmapp/domain/usecases/auth/Login;", "", "repository", "Lcom/cas/gammermvvmapp/domain/repository/AuthRepository;", "(Lcom/cas/gammermvvmapp/domain/repository/AuthRepository;)V", "invoke", "Lcom/cas/gammermvvmapp/domain/model/Response;", "Lcom/google/firebase/auth/FirebaseUser;", "email", "", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class Login {
    private final com.cas.gammermvvmapp.domain.repository.AuthRepository repository = null;
    
    @javax.inject.Inject
    public Login(@org.jetbrains.annotations.NotNull
    com.cas.gammermvvmapp.domain.repository.AuthRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String password, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.cas.gammermvvmapp.domain.model.Response<? extends com.google.firebase.auth.FirebaseUser>> continuation) {
        return null;
    }
}