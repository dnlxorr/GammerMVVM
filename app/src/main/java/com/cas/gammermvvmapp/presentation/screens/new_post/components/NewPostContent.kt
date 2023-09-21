package com.cas.gammermvvmapp.presentation.screens.new_post.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cas.gammermvvmapp.R
import com.cas.gammermvvmapp.presentation.DefaultTextField
import com.cas.gammermvvmapp.presentation.Red500

data class CategoryRadialButton(
    var catergory: String,
    var image: Int
)

@Composable
fun NewPostContent() {

    val radialOptions = listOf(
        CategoryRadialButton("PC", R.drawable.icon_pc),
        CategoryRadialButton("PS4", R.drawable.icon_ps4),
        CategoryRadialButton("XBOX", R.drawable.icon_xbox),
        CategoryRadialButton("NINTENDO", R.drawable.icon_nintendo),
        CategoryRadialButton("MOBILE", R.drawable.icon_mobile),
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
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
                    Image(
                        modifier = Modifier
                            .height(130.dp)
                            .padding(top = 20.dp),
                        painter = painterResource(id = R.drawable.add_image),
                        contentDescription = "Select Image"
                    )
                    Text(fontSize = 20.sp, fontWeight = FontWeight.Bold, text = "Select Image")
                }
            }

            DefaultTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp, start = 20.dp, end = 20.dp),
                value = "",
                onValueChange = { },
                label = "Name of the game",
                icon = Icons.Default.Face,
                errorMsg = "",
                validateField = {

                }
            )
            DefaultTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, start = 20.dp, end = 20.dp),
                value = "",
                onValueChange = { },
                label = "Description",
                icon = Icons.Default.List,
                errorMsg = "",
                validateField = {

                }
            )
            Text(
                modifier = Modifier.padding(vertical = 15.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                text = "Categories"
            )
        }
    }

}