package com.cas.gammermvvmapp.presentation.screens.login.viewmodel;

import android.util.Patterns;
import androidx.compose.runtime.*;
import androidx.lifecycle.ViewModel;
import com.cas.gammermvvmapp.domain.model.Response;
import com.cas.gammermvvmapp.domain.usecases.auth.AuthUseCases;
import com.google.firebase.auth.FirebaseUser;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u000201J\u0006\u00102\u001a\u00020/J\u0006\u00103\u001a\u00020/R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R+\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0010R+\u0010\u0018\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u00178F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001d\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR+\u0010\u001f\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u00178F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b!\u0010\u0012\u001a\u0004\b\u001f\u0010\u0019\"\u0004\b \u0010\u001bR\u001f\u0010\"\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070#\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R+\u0010&\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b)\u0010\u0012\u001a\u0004\b\'\u0010\u000e\"\u0004\b(\u0010\u0010R+\u0010*\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b-\u0010\u0012\u001a\u0004\b+\u0010\u000e\"\u0004\b,\u0010\u0010\u00a8\u00064"}, d2 = {"Lcom/cas/gammermvvmapp/presentation/screens/login/viewmodel/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "authUseCases", "Lcom/cas/gammermvvmapp/domain/usecases/auth/AuthUseCases;", "(Lcom/cas/gammermvvmapp/domain/usecases/auth/AuthUseCases;)V", "_loginFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/cas/gammermvvmapp/domain/model/Response;", "Lcom/google/firebase/auth/FirebaseUser;", "currentUser", "<set-?>", "", "email", "getEmail", "()Ljava/lang/String;", "setEmail", "(Ljava/lang/String;)V", "email$delegate", "Landroidx/compose/runtime/MutableState;", "emailErrorMsg", "getEmailErrorMsg", "setEmailErrorMsg", "emailErrorMsg$delegate", "", "isEmailValid", "()Z", "setEmailValid", "(Z)V", "isEmailValid$delegate", "isEnabledLoginButton", "setEnabledLoginButton", "isPasswordValid", "setPasswordValid", "isPasswordValid$delegate", "loginFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getLoginFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "password", "getPassword", "setPassword", "password$delegate", "passwordErrorMsg", "getPasswordErrorMsg", "setPasswordErrorMsg", "passwordErrorMsg$delegate", "enabledLoginButton", "", "login", "Lkotlinx/coroutines/Job;", "validateEmail", "validatePassword", "app_debug"})
public final class LoginViewModel extends androidx.lifecycle.ViewModel {
    private final com.cas.gammermvvmapp.domain.usecases.auth.AuthUseCases authUseCases = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState email$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState isEmailValid$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState emailErrorMsg$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState password$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState isPasswordValid$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState passwordErrorMsg$delegate = null;
    private boolean isEnabledLoginButton = false;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.cas.gammermvvmapp.domain.model.Response<com.google.firebase.auth.FirebaseUser>> _loginFlow = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.cas.gammermvvmapp.domain.model.Response<com.google.firebase.auth.FirebaseUser>> loginFlow = null;
    private final com.google.firebase.auth.FirebaseUser currentUser = null;
    
    @javax.inject.Inject
    public LoginViewModel(@org.jetbrains.annotations.NotNull
    com.cas.gammermvvmapp.domain.usecases.auth.AuthUseCases authUseCases) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEmail() {
        return null;
    }
    
    public final void setEmail(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final boolean isEmailValid() {
        return false;
    }
    
    public final void setEmailValid(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEmailErrorMsg() {
        return null;
    }
    
    public final void setEmailErrorMsg(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPassword() {
        return null;
    }
    
    public final void setPassword(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final boolean isPasswordValid() {
        return false;
    }
    
    public final void setPasswordValid(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPasswordErrorMsg() {
        return null;
    }
    
    public final void setPasswordErrorMsg(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final boolean isEnabledLoginButton() {
        return false;
    }
    
    public final void setEnabledLoginButton(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.cas.gammermvvmapp.domain.model.Response<com.google.firebase.auth.FirebaseUser>> getLoginFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job login() {
        return null;
    }
    
    public final void enabledLoginButton() {
    }
    
    public final void validateEmail() {
    }
    
    public final void validatePassword() {
    }
}