package ru.andryss.antalk.mobile

import android.app.Application
import android.content.Context
import androidx.navigation.NavHostController
import okhttp3.OkHttpClient
import ru.andryss.antalk.mobile.util.PropertyNames.Companion.ANTALK_CONNECT_TIMEOUT
import ru.andryss.antalk.mobile.util.PropertyNames.Companion.ANTALK_REQUEST_TIMEOUT
import java.util.Properties
import java.util.concurrent.TimeUnit

class AppState : Application() {
    lateinit var properties: Properties
    lateinit var httpClient: OkHttpClient
    lateinit var navController: NavHostController
    lateinit var userInfo: UserInfo
}

data class UserInfo(
    var sessionId: Long,
    var sessionToken: String
)

fun AppState.configureWith(applicationContext: Context) {
    // Load properties
    properties = Properties().apply {
        load(applicationContext.assets.open("app.properties"))
    }

    // Initialize http client
    httpClient = OkHttpClient.Builder()
        .connectTimeout(properties.getProperty(ANTALK_CONNECT_TIMEOUT, "5").toLong(), TimeUnit.SECONDS)
        .callTimeout(properties.getProperty(ANTALK_REQUEST_TIMEOUT, "10").toLong(), TimeUnit.SECONDS)
        .build()

    // Fetch user info
    userInfo = UserInfo(
        sessionId = -1,
        sessionToken = "mock-token"
    )
}
