package com.mindorks.sample.whatsapp.screen.chat.ui


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mindorks.sample.whatsapp.R
import com.mindorks.sample.whatsapp.data.model.User
import com.mindorks.sample.whatsapp.ui.DarkGreen
import com.mindorks.sample.whatsapp.ui.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatTopBar(user: User, onBackIconClick: () -> Unit) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = {
                onBackIconClick()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = null,
                    modifier = Modifier.padding(start = 8.dp),
                    tint = Color.White
                )
            }
        },
        actions = {
            CircularCoilImage(
                modifier = Modifier.size(40.dp),
                user.imageUrl
            )
        },
        title = {
            Text(
                text = user.name,
                color = White,
                style = TextStyle(fontSize = 18.sp, textAlign = TextAlign.Center)
            )
        },
        colors = TopAppBarColors(
            containerColor = DarkGreen,
            scrolledContainerColor = DarkGreen,
            navigationIconContentColor = Color.Gray,
            titleContentColor = Color.White,
            actionIconContentColor = Color.White
        )
    )
}