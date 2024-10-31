package com.mindorks.sample.whatsapp.screen.chat.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CircularCoilImage(modifier: Modifier = Modifier, url: String) {
    Box(
        modifier = modifier
            .clip(CircleShape)
    ) {
        Image(
            painter = rememberImagePainter(url),
            contentScale = ContentScale.Crop,
            contentDescription = null,
        )
    }
}