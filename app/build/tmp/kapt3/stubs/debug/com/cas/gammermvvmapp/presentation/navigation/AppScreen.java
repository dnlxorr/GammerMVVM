package com.cas.gammermvvmapp.presentation.navigation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\n\u000b\f\u00a8\u0006\r"}, d2 = {"Lcom/cas/gammermvvmapp/presentation/navigation/AppScreen;", "", "route", "", "(Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "Login", "Profile", "SignUp", "Lcom/cas/gammermvvmapp/presentation/navigation/AppScreen$Login;", "Lcom/cas/gammermvvmapp/presentation/navigation/AppScreen$Profile;", "Lcom/cas/gammermvvmapp/presentation/navigation/AppScreen$SignUp;", "app_debug"})
public abstract class AppScreen {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String route = null;
    
    private AppScreen(java.lang.String route) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRoute() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/cas/gammermvvmapp/presentation/navigation/AppScreen$Login;", "Lcom/cas/gammermvvmapp/presentation/navigation/AppScreen;", "()V", "app_debug"})
    public static final class Login extends com.cas.gammermvvmapp.presentation.navigation.AppScreen {
        @org.jetbrains.annotations.NotNull
        public static final com.cas.gammermvvmapp.presentation.navigation.AppScreen.Login INSTANCE = null;
        
        private Login() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/cas/gammermvvmapp/presentation/navigation/AppScreen$SignUp;", "Lcom/cas/gammermvvmapp/presentation/navigation/AppScreen;", "()V", "app_debug"})
    public static final class SignUp extends com.cas.gammermvvmapp.presentation.navigation.AppScreen {
        @org.jetbrains.annotations.NotNull
        public static final com.cas.gammermvvmapp.presentation.navigation.AppScreen.SignUp INSTANCE = null;
        
        private SignUp() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/cas/gammermvvmapp/presentation/navigation/AppScreen$Profile;", "Lcom/cas/gammermvvmapp/presentation/navigation/AppScreen;", "()V", "app_debug"})
    public static final class Profile extends com.cas.gammermvvmapp.presentation.navigation.AppScreen {
        @org.jetbrains.annotations.NotNull
        public static final com.cas.gammermvvmapp.presentation.navigation.AppScreen.Profile INSTANCE = null;
        
        private Profile() {
            super(null);
        }
    }
}