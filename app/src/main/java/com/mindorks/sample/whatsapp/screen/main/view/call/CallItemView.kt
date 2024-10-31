package com.mindorks.sample.whatsapp.screen.main.view.call

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.mindorks.sample.whatsapp.data.model.Call
import com.mindorks.sample.whatsapp.ui.Green

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CallItem(call: Call) {

    val padding = 16.dp

    Column(
        Modifier
            .padding(padding)
            .fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {

            Box(modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
            ) {
                Image(
                    painter = rememberImagePainter(call.imageUrl),
                    contentDescription = null,
                )
            }
            Column(modifier = Modifier.padding(start = padding)) {
                Text(call.name)
                Text(
                    call.time,
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Green,
                        textAlign = TextAlign.Center
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = CenterEnd) {
                Image(
                    painter = rememberImagePainter(call.voiceStatus),
                    contentDescription = null,
                )
            }
        }
    }
}
