package ru.andryss.antalk.mobile.page.auth

import android.app.Activity
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.andryss.antalk.mobile.AppState
import ru.andryss.antalk.mobile.client.SignInResponse


fun AppState.onSignInSuccess(localContext: Context, response: SignInResponse) {
    if (localContext !is Activity) {
        throw IllegalArgumentException("context == LocalContext.current")
    }

    // TODO
}

@Composable
fun MainAuthPage(state: AppState) {
    val navController = rememberNavController()
    state.navController = navController

    NavHost(
        navController = navController,
        startDestination = "signIn",
        builder = {
            composable("signIn") {
                SignInPage(state = state)
            }
        }
    )
}