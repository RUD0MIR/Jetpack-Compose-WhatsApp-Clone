package com.mindorks.sample.whatsapp.screen.main.view.call

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.mindorks.sample.whatsapp.data.model.Call
import com.mindorks.sample.whatsapp.ui.BrightGreen
import com.mindorks.sample.whatsapp.ui.Gray
import com.mindorks.sample.whatsapp.ui.White

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CallItem(call: Call) {
    val padding = 16.dp
    val imageSize = 40.dp

    Box(
        Modifier
            .padding(padding)
            .fillMaxWidth(),
    ) {
        Box(
            modifier = Modifier
                .align(CenterStart)
                .size(imageSize)
                .clip(CircleShape)
        ) {
            Image(
                painter = rememberImagePainter(call.imageUrl),
                contentDescription = null,
            )
        }
        Column(
            modifier = Modifier
                .padding(start = imageSize + padding)
                .align(CenterStart)
        ) {
            Text(call.name, color = White)

            Row {
                Image(
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(12.dp),
                    painter = painterResource(call.voiceStatus),
                    contentDescription = null,
                )

                Text(
                    call.time,
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Gray,
                        textAlign = TextAlign.Center
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
        
        Spacer(modifier = Modifier.size(width = 128.dp, height = 15.dp))

        Icon(
            modifier = Modifier
                .size(32.dp)
                .align(CenterEnd),
            imageVector = Icons.Default.Call,
            tint = BrightGreen,
            contentDescription = null
        )
    }
}
