package com.cas.gammermvvmapp.presentation.screens.profile_edit.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.cas.gammermvvmapp.domain.model.Response
import com.cas.gammermvvmapp.presentation.screens.login.components.ProgressBar
import com.cas.gammermvvmapp.presentation.screens.profile_edit.ProfileEditViewModel

@Composable
fun Update(viewModel: ProfileEditViewModel = hiltViewModel()) {
    when (val updateResponse = viewModel.updateResponese) {
        Response.Loading -> {
            ProgressBar()
        }

        is Response.Success -> {
            Toast.makeText(
                LocalContext.current,
                "user info successfully updated!",
                Toast.LENGTH_SHORT
            ).show()
        }

        is Response.Failure -> {
            Toast.makeText(
                LocalContext.current,
                updateResponse.exception?.message ?: "Uknown error!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}