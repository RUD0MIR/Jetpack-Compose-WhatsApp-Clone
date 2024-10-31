package com.mindorks.sample.whatsapp.screen.chat.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.mindorks.sample.whatsapp.R
import com.mindorks.sample.whatsapp.data.model.User
import com.mindorks.sample.whatsapp.ui.topBarColor

@OptIn(ExperimentalMaterial3Api::class, ExperimentalCoilApi::class)
@Composable
fun ChatTopBar(user: User, onBackIconClick: () -> Unit) {

    Column {
        TopAppBar(
            modifier = Modifier.background(topBarColor),
            navigationIcon = {
                IconButton(onClick = {
                    onBackIconClick()
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_back),
                        contentDescription = null, //TODO
                        modifier = Modifier.padding(start = 8.dp),
                        tint = Color.White
                    )
                }
            },
            actions = {
                Box(modifier = Modifier.size(40.dp).clip(CircleShape)) {
                    Image(
                        painter = rememberImagePainter(user.imageUrl),
                        contentDescription = null,
                    )
                }
            },
            title = {
                Text(
                    text = user.name,
                    color = Color.White,
                    style = TextStyle(fontSize = 18.sp, textAlign = TextAlign.Center)
                )
            }
        )
    }
}