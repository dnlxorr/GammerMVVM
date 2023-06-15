package com.cas.gammermvvmapp.presentation.screens.signup;

import android.util.Patterns;
import androidx.compose.runtime.MutableState;
import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\b\u0010,\u001a\u00020-H\u0002J\u0006\u0010.\u001a\u00020-J\u0006\u0010/\u001a\u00020-J\u0006\u00100\u001a\u00020-J\u0006\u00101\u001a\u00020-R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0015\u0010\tR \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\tR\u001a\u0010\u0018\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00140\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\tR \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00140\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\tR \u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\tR \u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0007\"\u0004\b%\u0010\tR \u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u0007\"\u0004\b(\u0010\tR \u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0007\"\u0004\b+\u0010\t\u00a8\u00062"}, d2 = {"Lcom/cas/gammermvvmapp/presentation/screens/signup/SignupViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "confirmPassword", "Landroidx/compose/runtime/MutableState;", "", "getConfirmPassword", "()Landroidx/compose/runtime/MutableState;", "setConfirmPassword", "(Landroidx/compose/runtime/MutableState;)V", "confirmPasswordErrorMsg", "getConfirmPasswordErrorMsg", "setConfirmPasswordErrorMsg", "email", "getEmail", "setEmail", "emailErrorMsg", "getEmailErrorMsg", "setEmailErrorMsg", "isConfirmPasswordValid", "", "setConfirmPasswordValid", "isEmailValid", "setEmailValid", "isEnabledSignupButton", "()Z", "setEnabledSignupButton", "(Z)V", "isPasswordValid", "setPasswordValid", "isUsernameValid", "setUsernameValid", "password", "getPassword", "setPassword", "passwordErrorMsg", "getPasswordErrorMsg", "setPasswordErrorMsg", "username", "getUsername", "setUsername", "usernameErrorMsg", "getUsernameErrorMsg", "setUsernameErrorMsg", "enableSignupButton", "", "validateConfirmPassword", "validateEmail", "validatePassword", "validateUsername", "app_debug"})
public final class SignupViewModel extends androidx.lifecycle.ViewModel {
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
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.String> username;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.Boolean> isUsernameValid;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.String> usernameErrorMsg;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.String> confirmPassword;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.Boolean> isConfirmPasswordValid;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.String> confirmPasswordErrorMsg;
    private boolean isEnabledSignupButton = false;
    
    @javax.inject.Inject()
    public SignupViewModel() {
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
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.String> getUsername() {
        return null;
    }
    
    public final void setUsername(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.Boolean> isUsernameValid() {
        return null;
    }
    
    public final void setUsernameValid(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.String> getUsernameErrorMsg() {
        return null;
    }
    
    public final void setUsernameErrorMsg(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.String> getConfirmPassword() {
        return null;
    }
    
    public final void setConfirmPassword(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.Boolean> isConfirmPasswordValid() {
        return null;
    }
    
    public final void setConfirmPasswordValid(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.String> getConfirmPasswordErrorMsg() {
        return null;
    }
    
    public final void setConfirmPasswordErrorMsg(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.String> p0) {
    }
    
    public final boolean isEnabledSignupButton() {
        return false;
    }
    
    public final void setEnabledSignupButton(boolean p0) {
    }
    
    private final void enableSignupButton() {
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