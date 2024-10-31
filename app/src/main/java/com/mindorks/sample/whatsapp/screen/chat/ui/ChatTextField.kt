package com.mindorks.sample.whatsapp.screen.chat.ui


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mindorks.sample.whatsapp.R
import com.mindorks.sample.whatsapp.ui.BrightGreen
import com.mindorks.sample.whatsapp.ui.DarkestGreen
import com.mindorks.sample.whatsapp.ui.Gray
import com.mindorks.sample.whatsapp.ui.White
import kotlinx.coroutines.launch


@Composable
fun ChatTextField(onMessageSend: (String) -> Unit) {
    val textState = remember { mutableStateOf(TextFieldValue()) }
    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()

    Row(
        modifier = Modifier
            .background(DarkestGreen)
            .fillMaxWidth()
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        TextField(
            value = textState.value,
            modifier = Modifier
                .clip(RoundedCornerShape(32.dp))
                .weight(1f),
            onValueChange = {
                textState.value = it
            },
            placeholder = {
                Text(text = "Message", color = Gray)
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = White,
                focusedIndicatorColor = Color.Transparent
            )
        )

        Spacer(modifier = Modifier.width(4.dp))

        IconButton(
            modifier = Modifier
                .clip(CircleShape)
                .background(BrightGreen),
            onClick = {
                onMessageSend(textState.value.text)
                scope.launch {
                    scrollState.animateScrollTo(0)
                }
            },
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.ic_send),
                tint = White,
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
private fun ChatTextFieldPreview() {
    ChatTextField() {}
}