package com.mindorks.sample.whatsapp.screen.main.view.status

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mindorks.sample.whatsapp.data.local.statusList
import com.mindorks.sample.whatsapp.screen.chat.ui.Divider
import com.mindorks.sample.whatsapp.ui.DarkestGreen

@Composable
fun StatusView() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = DarkestGreen)
    ) {
        items(statusList) {status ->
            StatusItemView(status)
            Divider()
        }
    }
}