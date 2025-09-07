package ru.andryss.antalk.mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ru.andryss.antalk.mobile.page.main.MainPage
import ru.andryss.antalk.mobile.theme.AnTalkTheme

const val TAG = "trousseau-mobile"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appState = application as AppState
        appState.configureWith(applicationContext)

        enableEdgeToEdge()
        setContent {
            AnTalkTheme {
                MainPage(state = appState)
            }
        }
    }
}
