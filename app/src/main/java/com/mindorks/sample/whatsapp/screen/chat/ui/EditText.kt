package com.mindorks.sample.whatsapp.screen.chat.ui


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.mindorks.sample.whatsapp.R
import com.mindorks.sample.whatsapp.ui.topBarColor
import kotlinx.coroutines.launch


@Composable
fun EditText(onMessageSend: (String) -> Unit) {

    val textState = remember { mutableStateOf(TextFieldValue()) }
    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()

    Box(Modifier.background(topBarColor)) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            TextField(
                value = textState.value,
                modifier = Modifier.weight(1f, true),
                onValueChange = {
                    textState.value = it
                })
            Spacer(modifier = Modifier.defaultMinSize(12.dp))

            IconButton(
                modifier = Modifier.weight(0.05f, true),
                onClick = {
                    onMessageSend(textState.value.text)

                    scope.launch {
                        scrollState.animateScrollTo(0)
                    }
                },
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_send), contentDescription = null)
            }
        }
    }
}