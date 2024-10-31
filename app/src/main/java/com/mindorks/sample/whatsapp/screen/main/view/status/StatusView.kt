package com.mindorks.sample.whatsapp.screen.main.view.status

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mindorks.sample.whatsapp.data.local.statusList
import com.mindorks.sample.whatsapp.ui.LightGreen

@Composable
fun StatusView() {
    LazyColumn(modifier = Modifier.background(color = LightGreen)) {
        items(statusList) {status ->
            StatusItemView(status)
            Divider()
        }
    }
}