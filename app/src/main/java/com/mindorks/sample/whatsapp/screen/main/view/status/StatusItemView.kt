package com.mindorks.sample.whatsapp.screen.main.view.status

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mindorks.sample.whatsapp.data.model.Status
import com.mindorks.sample.whatsapp.screen.chat.ui.CircularCoilImage
import com.mindorks.sample.whatsapp.ui.BrightGreen
import com.mindorks.sample.whatsapp.ui.White

@Composable
fun StatusItemView(status: Status) {
    val padding = 16.dp
    Column(Modifier.padding(padding).fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            CircularCoilImage(
                modifier = Modifier.size(40.dp),
                status.imageUrl
            )

            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(status.name, color = White)
                Text(
                    status.time,
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = BrightGreen,
                        textAlign = TextAlign.Center
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}
