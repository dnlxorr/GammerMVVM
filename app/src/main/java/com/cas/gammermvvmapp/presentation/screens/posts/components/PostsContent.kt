package com.cas.gammermvvmapp.presentation.screens.posts.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cas.gammermvvmapp.domain.model.Post

@Composable
fun PostsContent(
    posts: List<Post>
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 50.dp)
        ){
        items(items = posts) { post ->
            PostCard(post = post)
        }
    }
}