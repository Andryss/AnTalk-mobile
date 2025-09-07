package ru.andryss.antalk.mobile.page.auth

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.andryss.antalk.mobile.AppState

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