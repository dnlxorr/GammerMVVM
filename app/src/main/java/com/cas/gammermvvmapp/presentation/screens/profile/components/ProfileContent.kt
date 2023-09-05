package com.cas.gammermvvmapp.presentation.screens.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.cas.gammermvvmapp.R
import com.cas.gammermvvmapp.presentation.DefaultButton
import com.cas.gammermvvmapp.presentation.GammerMVVMAppTheme
import com.cas.gammermvvmapp.presentation.navigation.AppScreen
import com.cas.gammermvvmapp.presentation.screens.profile.ProfileViewModel
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun ProfileContent(navHostController: NavHostController,viewModel: ProfileViewModel = hiltViewModel()) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Box {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                painter = painterResource(id = R.drawable.background),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                alpha = 0.6f
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                Text(text = "Welcome", fontWeight = FontWeight.Bold, fontSize = 30.sp)
                Spacer(modifier = Modifier.height(55.dp))
                if(viewModel.userData.image != ""){
                    AsyncImage(
                        modifier = Modifier.size(115.dp).clip(CircleShape),
                        model = viewModel.userData.image,
                        contentDescription = "User Image",
                        contentScale = ContentScale.Crop)
                }else{
                    Image(
                        modifier = Modifier.size(115.dp),
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = ""
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(55.dp))
        Text(
            text = viewModel.userData.username,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
        )
        Text(text = viewModel.userData.email, fontSize = 15.sp, fontStyle = FontStyle.Italic)
        Spacer(modifier = Modifier.height(20.dp))
        DefaultButton(
            modifier = Modifier.width(250.dp),
            text = "Edit info",
            color = Color.White,
            icon = Icons.Default.Edit,
            textColor = Color.Black,
            onClick = {
                navHostController.navigate(
                    AppScreen.ProfileEdit.passUser(viewModel.userData.toJson())
                )
            })
        Spacer(modifier = Modifier.height(10.dp))
        DefaultButton(
            modifier = Modifier.width(250.dp),
            text = "Logout",
            onClick = {
                viewModel.logout()
                navHostController.navigate(AppScreen.Login.route){
                    popUpTo(AppScreen.Profile.route){inclusive=true}
                }
            })
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewProfileContent() {
    GammerMVVMAppTheme(darkTheme = true) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            ProfileContent(rememberNavController())
        }
    }
}