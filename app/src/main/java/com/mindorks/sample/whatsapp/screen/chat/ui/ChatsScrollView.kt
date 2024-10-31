package com.mindorks.sample.whatsapp.screen.chat.ui


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mindorks.sample.whatsapp.data.model.Conversation
import com.mindorks.sample.whatsapp.data.model.User
import com.mindorks.sample.whatsapp.ui.DarkGray
import com.mindorks.sample.whatsapp.ui.DarkestGreen
import com.mindorks.sample.whatsapp.ui.Green
import com.mindorks.sample.whatsapp.ui.White

@Composable
fun ChatsScrollView(modifier: Modifier = Modifier, chat: List<Conversation>) {
    LazyColumn(
        modifier = modifier
            .fillMaxHeight()
            .background(color = DarkestGreen)
            .padding(horizontal = 16.dp)
            .padding(top = 8.dp)
    ) {
        items(chat) {
            if (it.id == 2) {
                Message(
                    text = it.chat,
                    isRightAligned = true,
                    color = Green
                )
            } else {
                Message(
                    text = it.chat,
                    isRightAligned = false,
                    color = DarkGray
                )
            }
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun Message(text: String, isRightAligned: Boolean, color: Color) {
    Row(
        Modifier.fillMaxWidth()
    ) {
        val spacersWeight = 0.2f

        if (isRightAligned) {
            Spacer(modifier = Modifier.weight(spacersWeight))
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .clip(RoundedCornerShape(8.dp))
                .background(color)
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = text,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = White
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        if (!isRightAligned) {
            Spacer(modifier = Modifier.weight(spacersWeight))
        }
    }
}

@Preview
@Composable
private fun ChatScreenPreview() {
    ChatScreenView(
        user = User(id = 0, name = "name", imageUrl = ""),
        onBackIconClick = {}
    ) {}
}