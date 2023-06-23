package com.cas.gammermvvmapp.presentation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DefaultButton(
    modifier: Modifier,
    text: String,
    errorMsg: String = "",
    onClick: () -> Unit,
    color: Color = Red500,
    textColor: Color = Color.White,
    enable: Boolean = true,
    icon: ImageVector = Icons.Default.ArrowForward
) {
    Button(
        modifier = modifier,
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(backgroundColor = color),
        enabled = enable
    ) {
        Icon(imageVector = icon, contentDescription = "", tint = textColor)
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = text, fontSize = 18.sp, color = textColor)
    }
    Text(
        modifier = Modifier.padding(top = 5.dp),
        text = errorMsg,
        fontSize = 11.sp,
        color = Red700
    )
}