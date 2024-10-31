package com.mindorks.sample.whatsapp.screen.main.view

import androidx.compose.foundation.background
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.mindorks.sample.whatsapp.ui.topBarColor

data class ScreenState(var state: Screen = Screen.CALLS) {

    enum class Screen(
        val title: String = "Tab"
    ) {
        CALLS(title = "Calls"),
        CHATS(title = "Chats"),
        STATUS(title = "Status")
    }
}

@Composable
fun TabsPanel(
    screenState: ScreenState,
    onNavigate: (ScreenState.Screen) -> Unit,
) {
    val (selectedTab, setSelectedTab) = remember {
        mutableIntStateOf(
            ScreenState.Screen.entries.indexOf(screenState.state)
        )
    }

    val tabs = ScreenState.Screen.entries

    TabRow(
        modifier = Modifier.background(topBarColor),
        selectedTabIndex = selectedTab,
        tabs = {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    text = { Text(text = tab.title.uppercase(), color = Color.White) },
                    selected = index == selectedTab,
                    onClick = {
                        setSelectedTab(index)
                        onNavigate(tab)
                    }
                )
            }
        }
    )
}