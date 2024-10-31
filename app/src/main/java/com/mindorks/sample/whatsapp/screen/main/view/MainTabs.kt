package com.mindorks.sample.whatsapp.screen.main.view


import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.mindorks.sample.whatsapp.ui.BrightGreen
import com.mindorks.sample.whatsapp.ui.DarkGreen
import com.mindorks.sample.whatsapp.ui.Gray

data class ScreenState(var state: Screen = Screen.CALLS) {

    enum class Screen(
        val title: String = "Tab"
    ) {
        STATUS(title = "Status"),
        CHATS(title = "Chats"),
        CALLS(title = "Calls"),
    }
}

@Composable
fun TabsPanel(
    screenState: ScreenState,
    onNavigate: (ScreenState.Screen) -> Unit,
) {
    val (selectedTabIndex, setSelectedTab) = remember {
        mutableIntStateOf(
            ScreenState.Screen.entries.indexOf(screenState.state)
        )
    }

    val tabs = ScreenState.Screen.entries

    TabRow(
        containerColor = DarkGreen,
        selectedTabIndex = selectedTabIndex,
        tabs = {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    text = {
                        Text(
                            text = tab.title.uppercase(),
                            color = if (index == selectedTabIndex) BrightGreen else Gray
                        )
                    },
                    selected = index == selectedTabIndex,
                    onClick = {
                        setSelectedTab(index)
                        onNavigate(tab)
                    }
                )
            }
        },
        divider = {}
    )
}
