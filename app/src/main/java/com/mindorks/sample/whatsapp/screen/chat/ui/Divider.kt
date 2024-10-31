package com.mindorks.sample.whatsapp.screen.chat.ui

import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mindorks.sample.whatsapp.ui.DarkerGreen

@Composable
fun Divider(modifier: Modifier = Modifier) {
    HorizontalDivider(
        thickness = 1.dp,
        color = DarkerGreen
    )
}