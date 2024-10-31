package com.mindorks.sample.whatsapp.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import com.mindorks.sample.whatsapp.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val DELAY: Long = 2000

@Composable
fun SplashView(modifier: Modifier = Modifier, loadNextScreen: () -> Unit) {
    Surface(color = colorResource(id = R.color.whatsapp_green)) {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Image(painter = painterResource(id = R.drawable.ic_whatsapp_logo), null)
        }
    }

    LaunchedEffect(key1 = null) {
        delay(DELAY)
        loadNextScreen()
    }
}
