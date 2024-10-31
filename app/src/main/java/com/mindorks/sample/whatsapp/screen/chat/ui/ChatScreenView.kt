package com.mindorks.sample.whatsapp.screen.chat.ui

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.mindorks.sample.whatsapp.data.local.chat
import com.mindorks.sample.whatsapp.data.model.User


@Composable
fun ChatScreenView(user: User, onBackIconClick: () -> Unit, onMessageSend: (String) -> Unit) {
    Scaffold(
        bottomBar = { EditText(onMessageSend) },
        topBar = {
            ChatTopBar(user, onBackIconClick)
        },
        content = {
            ChatsScrollView(chat.toList())
            it
       },
    )
}