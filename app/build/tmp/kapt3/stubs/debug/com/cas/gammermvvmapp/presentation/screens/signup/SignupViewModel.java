package com.cas.gammermvvmapp.presentation.screens.signup;

import android.util.Patterns;
import androidx.compose.runtime.MutableState;
import androidx.lifecycle.ViewModel;
import com.cas.gammermvvmapp.domain.model.Response;
import com.cas.gammermvvmapp.domain.model.User;
import com.cas.gammermvvmapp.domain.usecases.auth.AuthUseCases;
import com.cas.gammermvvmapp.domain.usecases.users.UsersUseCases;
import com.google.firebase.auth.FirebaseUser;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010>\u001a\u00020?J\b\u0010@\u001a\u00020AH\u0002J\u0006\u0010B\u001a\u00020AJ\u000e\u0010C\u001a\u00020?2\u0006\u00102\u001a\u000203J\u0006\u0010D\u001a\u00020AJ\u0006\u0010E\u001a\u00020AJ\u0006\u0010F\u001a\u00020AJ\u0006\u0010G\u001a\u00020AR\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001d\u0010\u0011R \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R\u001a\u0010 \u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010$\u001a\b\u0012\u0004\u0012\u00020\u001c0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000f\"\u0004\b%\u0010\u0011R \u0010&\u001a\b\u0012\u0004\u0012\u00020\u001c0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u000f\"\u0004\b\'\u0010\u0011R \u0010(\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u000f\"\u0004\b*\u0010\u0011R \u0010+\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u000f\"\u0004\b-\u0010\u0011R\u001f\u0010.\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0/\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u001a\u00102\u001a\u000203X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R \u00108\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u000f\"\u0004\b:\u0010\u0011R \u0010;\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u000f\"\u0004\b=\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006H"}, d2 = {"Lcom/cas/gammermvvmapp/presentation/screens/signup/SignupViewModel;", "Landroidx/lifecycle/ViewModel;", "authUseCases", "Lcom/cas/gammermvvmapp/domain/usecases/auth/AuthUseCases;", "usersUseCases", "Lcom/cas/gammermvvmapp/domain/usecases/users/UsersUseCases;", "(Lcom/cas/gammermvvmapp/domain/usecases/auth/AuthUseCases;Lcom/cas/gammermvvmapp/domain/usecases/users/UsersUseCases;)V", "_signupFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/cas/gammermvvmapp/domain/model/Response;", "Lcom/google/firebase/auth/FirebaseUser;", "confirmPassword", "Landroidx/compose/runtime/MutableState;", "", "getConfirmPassword", "()Landroidx/compose/runtime/MutableState;", "setConfirmPassword", "(Landroidx/compose/runtime/MutableState;)V", "confirmPasswordErrorMsg", "getConfirmPasswordErrorMsg", "setConfirmPasswordErrorMsg", "email", "getEmail", "setEmail", "emailErrorMsg", "getEmailErrorMsg", "setEmailErrorMsg", "isConfirmPasswordValid", "", "setConfirmPasswordValid", "isEmailValid", "setEmailValid", "isEnabledSignupButton", "()Z", "setEnabledSignupButton", "(Z)V", "isPasswordValid", "setPasswordValid", "isUsernameValid", "setUsernameValid", "password", "getPassword", "setPassword", "passwordErrorMsg", "getPasswordErrorMsg", "setPasswordErrorMsg", "signupFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getSignupFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "user", "Lcom/cas/gammermvvmapp/domain/model/User;", "getUser", "()Lcom/cas/gammermvvmapp/domain/model/User;", "setUser", "(Lcom/cas/gammermvvmapp/domain/model/User;)V", "username", "getUsername", "setUsername", "usernameErrorMsg", "getUsernameErrorMsg", "setUsernameErrorMsg", "createUser", "Lkotlinx/coroutines/Job;", "enableSignupButton", "", "onSignup", "signup", "validateConfirmPassword", "validateEmail", "validatePassword", "validateUsername", "app_debug"})
public final class SignupViewModel extends androidx.lifecycle.ViewModel {
    private final com.cas.gammermvvmapp.domain.usecases.auth.AuthUseCases authUseCases = null;
    private final com.cas.gammermvvmapp.domain.usecases.users.UsersUseCases usersUseCases = null;
    @org.jetbrains.annotations.NotNull
    private androidx.compose.runtime.MutableState<java.lang.String> email;
    @org.jetbrains.annotations.NotNull
    private androidx.compose.runtime.MutableState<java.lang.Boolean> isEmailValid;
    @org.jetbrains.annotations.NotNull
    private androidx.compose.runtime.MutableState<java.lang.String> emailErrorMsg;
    @org.jetbrains.annotations.NotNull
    private androidx.compose.runtime.MutableState<java.lang.String> password;
    @org.jetbrains.annotations.NotNull
    private androidx.compose.runtime.MutableState<java.lang.Boolean> isPasswordValid;
    @org.jetbrains.annotations.NotNull
    private androidx.compose.runtime.MutableState<java.lang.String> passwordErrorMsg;
    @org.jetbrains.annotations.NotNull
    private androidx.compose.runtime.MutableState<java.lang.String> username;
    @org.jetbrains.annotations.NotNull
    private androidx.compose.runtime.MutableState<java.lang.Boolean> isUsernameValid;
    @org.jetbrains.annotations.NotNull
    private androidx.compose.runtime.MutableState<java.lang.String> usernameErrorMsg;
    @org.jetbrains.annotations.NotNull
    private androidx.compose.runtime.MutableState<java.lang.String> confirmPassword;
    @org.jetbrains.annotations.NotNull
    private androidx.compose.runtime.MutableState<java.lang.Boolean> isConfirmPasswordValid;
    @org.jetbrains.annotations.NotNull
    private androidx.compose.runtime.MutableState<java.lang.String> confirmPasswordErrorMsg;
    private boolean isEnabledSignupButton = false;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.cas.gammermvvmapp.domain.model.Response<com.google.firebase.auth.FirebaseUser>> _signupFlow = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.cas.gammermvvmapp.domain.model.Response<com.google.firebase.auth.FirebaseUser>> signupFlow = null;
    @org.jetbrains.annotations.NotNull
    private com.cas.gammermvvmapp.domain.model.User user;
    
    @javax.inject.Inject
    public SignupViewModel(@org.jetbrains.annotations.NotNull
    com.cas.gammermvvmapp.domain.usecases.auth.AuthUseCases authUseCases, @org.jetbrains.annotations.NotNull
    com.cas.gammermvvmapp.domain.usecases.users.UsersUseCases usersUseCases) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.String> getEmail() {
        return null;
    }
    
    public final void setEmail(@org.jetbrains.annotations.NotNull
    androidx.compose.runtime.MutableState<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.Boolean> isEmailValid() {
        return null;
    }
    
    public final void setEmailValid(@org.jetbrains.annotations.NotNull
    androidx.compose.runtime.MutableState<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.String> getEmailErrorMsg() {
        return null;
    }
    
    public final void setEmailErrorMsg(@org.jetbrains.annotations.NotNull
    androidx.compose.runtime.MutableState<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.String> getPassword() {
        return null;
    }
    
    public final void setPassword(@org.jetbrains.annotations.NotNull
    androidx.compose.runtime.MutableState<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.Boolean> isPasswordValid() {
        return null;
    }
    
    public final void setPasswordValid(@org.jetbrains.annotations.NotNull
    androidx.compose.runtime.MutableState<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.String> getPasswordErrorMsg() {
        return null;
    }
    
    public final void setPasswordErrorMsg(@org.jetbrains.annotations.NotNull
    androidx.compose.runtime.MutableState<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.String> getUsername() {
        return null;
    }
    
    public final void setUsername(@org.jetbrains.annotations.NotNull
    androidx.compose.runtime.MutableState<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.Boolean> isUsernameValid() {
        return null;
    }
    
    public final void setUsernameValid(@org.jetbrains.annotations.NotNull
    androidx.compose.runtime.MutableState<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.String> getUsernameErrorMsg() {
        return null;
    }
    
    public final void setUsernameErrorMsg(@org.jetbrains.annotations.NotNull
    androidx.compose.runtime.MutableState<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.String> getConfirmPassword() {
        return null;
    }
    
    public final void setConfirmPassword(@org.jetbrains.annotations.NotNull
    androidx.compose.runtime.MutableState<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.Boolean> isConfirmPasswordValid() {
        return null;
    }
    
    public final void setConfirmPasswordValid(@org.jetbrains.annotations.NotNull
    androidx.compose.runtime.MutableState<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.String> getConfirmPasswordErrorMsg() {
        return null;
    }
    
    public final void setConfirmPasswordErrorMsg(@org.jetbrains.annotations.NotNull
    androidx.compose.runtime.MutableState<java.lang.String> p0) {
    }
    
    public final boolean isEnabledSignupButton() {
        return false;
    }
    
    public final void setEnabledSignupButton(boolean p0) {
    }
    
    private final void enableSignupButton() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.cas.gammermvvmapp.domain.model.Response<com.google.firebase.auth.FirebaseUser>> getSignupFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.cas.gammermvvmapp.domain.model.User getUser() {
        return null;
    }
    
    public final void setUser(@org.jetbrains.annotations.NotNull
    com.cas.gammermvvmapp.domain.model.User p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job signup(@org.jetbrains.annotations.NotNull
    com.cas.gammermvvmapp.domain.model.User user) {
        return null;
    }
    
    public final void onSignup() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job createUser() {
        return null;
    }
    
    public final void validateUsername() {
    }
    
    public final void validateEmail() {
    }
    
    public final void validatePassword() {
    }
    
    public final void validateConfirmPassword() {
    }
}