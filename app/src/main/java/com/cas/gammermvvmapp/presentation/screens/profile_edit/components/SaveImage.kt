package com.cas.gammermvvmapp.presentation.screens.profile_edit.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.cas.gammermvvmapp.domain.model.Response
import com.cas.gammermvvmapp.presentation.screens.login.components.ProgressBar
import com.cas.gammermvvmapp.presentation.screens.profile_edit.ProfileEditViewModel

@Composable
fun SaveImage(viewModel: ProfileEditViewModel = hiltViewModel()){
    when(val response = viewModel.saveImageResponese){
        Response.Loading->{
            ProgressBar()
        }
        is Response.Success ->{
            viewModel.onUpdateUser(response.data)
        }
        is Response.Failure ->{
          Toast.makeText(LocalContext.current, response.exception?.message?:"Unknown error!", Toast.LENGTH_SHORT).show()
        }

        else -> {}
    }
}