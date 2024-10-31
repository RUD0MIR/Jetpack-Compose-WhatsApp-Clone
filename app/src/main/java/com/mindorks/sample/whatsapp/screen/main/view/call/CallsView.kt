package com.mindorks.sample.whatsapp.screen.main.view.call

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mindorks.sample.whatsapp.data.local.calls
import com.mindorks.sample.whatsapp.ui.LightGreen

@Composable
fun CallsView() {
    LazyColumn(modifier = Modifier.background(color = LightGreen)) {
        items(calls) {call ->
            CallItem(call)
            Divider()
        }

    }
}