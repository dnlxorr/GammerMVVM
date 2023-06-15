package com.cas.gammermvvmapp.presentation.screens.login.viewmodel;

import android.util.Patterns;
import androidx.compose.runtime.*;
import androidx.lifecycle.ViewModel;
import com.cas.gammermvvmapp.domain.model.Response;
import com.cas.gammermvvmapp.domain.usecases.auth.AuthUseCases;
import com.google.firebase.auth.FirebaseUser;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import java.util.regex.Pattern;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010&\u001a\u00020\'J\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020\'J\u0006\u0010+\u001a\u00020\'R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001f\u0010\u001c\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR \u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000fR \u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000f\u00a8\u0006,"}, d2 = {"Lcom/cas/gammermvvmapp/presentation/screens/login/viewmodel/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "authUseCases", "Lcom/cas/gammermvvmapp/domain/usecases/auth/AuthUseCases;", "(Lcom/cas/gammermvvmapp/domain/usecases/auth/AuthUseCases;)V", "_loginFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/cas/gammermvvmapp/domain/model/Response;", "Lcom/google/firebase/auth/FirebaseUser;", "email", "Landroidx/compose/runtime/MutableState;", "", "getEmail", "()Landroidx/compose/runtime/MutableState;", "setEmail", "(Landroidx/compose/runtime/MutableState;)V", "emailErrorMsg", "getEmailErrorMsg", "setEmailErrorMsg", "isEmailValid", "", "setEmailValid", "isEnabledLoginButton", "()Z", "setEnabledLoginButton", "(Z)V", "isPasswordValid", "setPasswordValid", "loginFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getLoginFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "password", "getPassword", "setPassword", "passwordErrorMsg", "getPasswordErrorMsg", "setPasswordErrorMsg", "enabledLoginButton", "", "login", "Lkotlinx/coroutines/Job;", "validateEmail", "validatePassword", "app_debug"})
public final class LoginViewModel extends androidx.lifecycle.ViewModel {
    private final com.cas.gammermvvmapp.domain.usecases.auth.AuthUseCases authUseCases = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.String> email;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.Boolean> isEmailValid;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.String> emailErrorMsg;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.String> password;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.Boolean> isPasswordValid;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.String> passwordErrorMsg;
    private boolean isEnabledLoginButton = false;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.cas.gammermvvmapp.domain.model.Response<com.google.firebase.auth.FirebaseUser>> _loginFlow = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.cas.gammermvvmapp.domain.model.Response<com.google.firebase.auth.FirebaseUser>> loginFlow = null;
    
    @javax.inject.Inject()
    public LoginViewModel(@org.jetbrains.annotations.NotNull()
    com.cas.gammermvvmapp.domain.usecases.auth.AuthUseCases authUseCases) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.String> getEmail() {
        return null;
    }
    
    public final void setEmail(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.Boolean> isEmailValid() {
        return null;
    }
    
    public final void setEmailValid(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.String> getEmailErrorMsg() {
        return null;
    }
    
    public final void setEmailErrorMsg(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.String> getPassword() {
        return null;
    }
    
    public final void setPassword(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.Boolean> isPasswordValid() {
        return null;
    }
    
    public final void setPasswordValid(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.String> getPasswordErrorMsg() {
        return null;
    }
    
    public final void setPasswordErrorMsg(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.String> p0) {
    }
    
    public final boolean isEnabledLoginButton() {
        return false;
    }
    
    public final void setEnabledLoginButton(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.cas.gammermvvmapp.domain.model.Response<com.google.firebase.auth.FirebaseUser>> getLoginFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
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