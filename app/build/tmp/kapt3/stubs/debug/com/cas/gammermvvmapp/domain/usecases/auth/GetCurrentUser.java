package com.cas.gammermvvmapp.domain.usecases.auth;

import com.cas.gammermvvmapp.domain.repository.AuthRepository;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/cas/gammermvvmapp/domain/usecases/auth/GetCurrentUser;", "", "repository", "Lcom/cas/gammermvvmapp/domain/repository/AuthRepository;", "(Lcom/cas/gammermvvmapp/domain/repository/AuthRepository;)V", "invoke", "Lcom/google/firebase/auth/FirebaseUser;", "app_debug"})
public final class GetCurrentUser {
    private final com.cas.gammermvvmapp.domain.repository.AuthRepository repository = null;
    
    @javax.inject.Inject()
    public GetCurrentUser(@org.jetbrains.annotations.NotNull()
    com.cas.gammermvvmapp.domain.repository.AuthRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.firebase.auth.FirebaseUser invoke() {
        return null;
    }
}