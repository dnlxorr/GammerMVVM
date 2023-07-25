package com.cas.gammermvvmapp.presentation.screens.login.viewmodel;

import android.util.Patterns;
import androidx.compose.runtime.*;
import androidx.lifecycle.ViewModel;
import com.cas.gammermvvmapp.domain.model.Response;
import com.cas.gammermvvmapp.domain.usecases.auth.AuthUseCases;
import com.cas.gammermvvmapp.presentation.screens.login.LoginState;
import com.google.firebase.auth.FirebaseUser;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u000200J\u000e\u00101\u001a\u00020.2\u0006\u00102\u001a\u00020\bJ\u000e\u00103\u001a\u00020.2\u0006\u00104\u001a\u00020\bJ\u0006\u00105\u001a\u00020.J\u0006\u00106\u001a\u00020.R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR+\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00108F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R+\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00108F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u0014R;\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001b2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b!\u0010\u000f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R+\u0010\"\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b%\u0010\u000f\u001a\u0004\b#\u0010\u000b\"\u0004\b$\u0010\rR+\u0010\'\u001a\u00020&2\u0006\u0010\u0007\u001a\u00020&8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b,\u0010\u000f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u00a8\u00067"}, d2 = {"Lcom/cas/gammermvvmapp/presentation/screens/login/viewmodel/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "authUseCases", "Lcom/cas/gammermvvmapp/domain/usecases/auth/AuthUseCases;", "(Lcom/cas/gammermvvmapp/domain/usecases/auth/AuthUseCases;)V", "currentUser", "Lcom/google/firebase/auth/FirebaseUser;", "<set-?>", "", "emailErrorMsg", "getEmailErrorMsg", "()Ljava/lang/String;", "setEmailErrorMsg", "(Ljava/lang/String;)V", "emailErrorMsg$delegate", "Landroidx/compose/runtime/MutableState;", "", "isEmailValid", "()Z", "setEmailValid", "(Z)V", "isEmailValid$delegate", "isEnabledLoginButton", "setEnabledLoginButton", "isPasswordValid", "setPasswordValid", "isPasswordValid$delegate", "Lcom/cas/gammermvvmapp/domain/model/Response;", "loginResponse", "getLoginResponse", "()Lcom/cas/gammermvvmapp/domain/model/Response;", "setLoginResponse", "(Lcom/cas/gammermvvmapp/domain/model/Response;)V", "loginResponse$delegate", "passwordErrorMsg", "getPasswordErrorMsg", "setPasswordErrorMsg", "passwordErrorMsg$delegate", "Lcom/cas/gammermvvmapp/presentation/screens/login/LoginState;", "state", "getState", "()Lcom/cas/gammermvvmapp/presentation/screens/login/LoginState;", "setState", "(Lcom/cas/gammermvvmapp/presentation/screens/login/LoginState;)V", "state$delegate", "enabledLoginButton", "", "login", "Lkotlinx/coroutines/Job;", "onEmailInput", "email", "onPasswordInput", "password", "validateEmail", "validatePassword", "app_debug"})
public final class LoginViewModel extends androidx.lifecycle.ViewModel {
    private final com.cas.gammermvvmapp.domain.usecases.auth.AuthUseCases authUseCases = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState state$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState isEmailValid$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState emailErrorMsg$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState isPasswordValid$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState passwordErrorMsg$delegate = null;
    private boolean isEnabledLoginButton = false;
    @org.jetbrains.annotations.Nullable
    private final androidx.compose.runtime.MutableState loginResponse$delegate = null;
    private final com.google.firebase.auth.FirebaseUser currentUser = null;
    
    @javax.inject.Inject
    public LoginViewModel(@org.jetbrains.annotations.NotNull
    com.cas.gammermvvmapp.domain.usecases.auth.AuthUseCases authUseCases) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.cas.gammermvvmapp.presentation.screens.login.LoginState getState() {
        return null;
    }
    
    private final void setState(com.cas.gammermvvmapp.presentation.screens.login.LoginState p0) {
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
    
    @org.jetbrains.annotations.Nullable
    public final com.cas.gammermvvmapp.domain.model.Response<com.google.firebase.auth.FirebaseUser> getLoginResponse() {
        return null;
    }
    
    public final void setLoginResponse(@org.jetbrains.annotations.Nullable
    com.cas.gammermvvmapp.domain.model.Response<? extends com.google.firebase.auth.FirebaseUser> p0) {
    }
    
    public final void onEmailInput(@org.jetbrains.annotations.NotNull
    java.lang.String email) {
    }
    
    public final void onPasswordInput(@org.jetbrains.annotations.NotNull
    java.lang.String password) {
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