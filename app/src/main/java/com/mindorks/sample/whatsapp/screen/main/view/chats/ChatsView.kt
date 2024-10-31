package com.mindorks.sample.whatsapp.screen.main.view.chats

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mindorks.sample.whatsapp.data.local.chatsList
import com.mindorks.sample.whatsapp.data.model.User
import com.mindorks.sample.whatsapp.screen.chat.ui.Divider
import com.mindorks.sample.whatsapp.ui.DarkestGreen

@Composable
fun ChatsView(loadNextScreen: (User) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxSize().background(color = DarkestGreen)) {
        items(chatsList) {chat ->
            ChatsItemView(chat, loadNextScreen)
            Divider()
        }
    }
}