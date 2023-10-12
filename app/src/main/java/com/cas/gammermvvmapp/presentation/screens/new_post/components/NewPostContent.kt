package com.cas.gammermvvmapp.presentation.screens.new_post.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.cas.gammermvvmapp.R
import com.cas.gammermvvmapp.presentation.DefaultTextField
import com.cas.gammermvvmapp.presentation.Red500
import com.cas.gammermvvmapp.presentation.components.DialogProfilePicture
import com.cas.gammermvvmapp.presentation.screens.new_post.NewPostViewModel


@Composable
fun NewPostContent(viewModel: NewPostViewModel = hiltViewModel()) {

    val state = viewModel.state
    viewModel.resultingActivityHandler.handle()

    var dialogState = remember {
        mutableStateOf(false)
    }

    DialogProfilePicture(
        status = dialogState,
        takePhoto = { viewModel.takePhoto() },
        pickImage = { viewModel.pickImage() }
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .height(180.dp)
                    .background(Red500)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (viewModel.state.image != "") {
                        AsyncImage(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(170.dp)
                                .clickable {
                                    dialogState.value = true
                                },
                            model = viewModel.state.image,
                            contentDescription = "Selected image",
                            contentScale = ContentScale.Crop
                        )
                    } else {
                        Image(
                            modifier = Modifier
                                .height(80.dp)
                                .clickable {
                                    dialogState.value = true
                                },
                            painter = painterResource(id = R.drawable.add_image),
                            contentDescription = "User Image"
                        )
                        Text(fontSize = 20.sp, fontWeight = FontWeight.Bold, text = "Select Image")
                    }
                }
            }

            DefaultTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp, start = 20.dp, end = 20.dp),
                value = state.name,
                onValueChange = { viewModel.onNameInput(it) },
                label = "Name of the game",
                icon = Icons.Default.Face,
                errorMsg = "",
                validateField = {

                }
            )
            DefaultTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 0.dp, start = 20.dp, end = 20.dp),
                value = state.description,
                onValueChange = { viewModel.onDescriptionInput(it) },
                label = "Description",
                icon = Icons.Default.List,
                errorMsg = "",
                validateField = {

                }
            )
            Text(
                modifier = Modifier.padding(vertical = 10.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                text = "Categories"
            )

            viewModel.radialOptions.forEach { option ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .padding(horizontal = 16.dp)
                        .selectable(
                            selected = (state.category == option.category),
                            onClick = { viewModel.onCategoryInput(option.category) }
                        ),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    RadioButton(
                        selected = (state.category == option.category),
                        onClick = { viewModel.onCategoryInput(option.category) },
                    )
                    Row {
                        Text(
                            modifier = Modifier
                                .width(100.dp)
                                .padding(top = 7.dp),
                            text = option.category
                        )
                        Image(
                            modifier = Modifier.height(40.dp),
                            painter = painterResource(id = option.image),
                            contentDescription = ""
                        )
                    }

                }
            }
        }
    }

}