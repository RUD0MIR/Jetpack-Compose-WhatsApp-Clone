package com.mindorks.sample.whatsapp.screen.main.view.chats

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mindorks.sample.whatsapp.data.model.Chat
import com.mindorks.sample.whatsapp.data.model.User
import com.mindorks.sample.whatsapp.screen.chat.ui.CircularCoilImage
import com.mindorks.sample.whatsapp.ui.BrightGreen
import com.mindorks.sample.whatsapp.ui.DarkerGreen
import com.mindorks.sample.whatsapp.ui.Gray
import com.mindorks.sample.whatsapp.ui.White

@Composable
fun ChatsItemView(chat: Chat, loadNextScreen: (User) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                loadNextScreen(
                    User(
                        id = 2,
                        chat.name,
                        chat.url
                    )
                )
            }
            .padding(
                top = 4.dp, bottom = 4.dp
            )) {
        Row(modifier = Modifier.padding(10.dp)) {
            CircularCoilImage(
                modifier = Modifier.size(40.dp),
                chat.url
            )

            Spacer(modifier = Modifier.defaultMinSize(12.dp))
            Column(modifier = Modifier.weight(3.0f, true)) {
                Text(chat.name, color = White)
                Spacer(modifier = Modifier.defaultMinSize(2.dp))
                UserChat(chat)
            }
            Column(modifier = Modifier.weight(1.0f, true), horizontalAlignment = Alignment.End) {
                MessageTime(chat)
                Spacer(modifier = Modifier.defaultMinSize(2.dp))
                UnreadCount(chat)
            }
        }
    }
}

@Composable
fun UserChat(chat: Chat) {

    Text(
        text = chat.chat,
        style = TextStyle(
            fontSize = 16.sp,
            color = Gray
        ),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}


@Composable
fun MessageTime(chat: Chat) {
    Text(
        text = chat.time,
        style = TextStyle(
            fontSize = 12.sp,
            color = BrightGreen
        )
    )
}

@Composable
fun UnreadCount(chat: Chat) {
    if (chat.unreadCount != "0") {
        SetupUnreadCount(chat.unreadCount)
    }
}

@Composable
fun SetupUnreadCount(count: String) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .size(20.dp)
            .background(BrightGreen),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = count,
            style = TextStyle(
                fontSize = 12.sp,
                color = DarkerGreen
            )
        )
    }
}