package ru.andryss.antalk.mobile.page.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.andryss.antalk.mobile.AppState

@Composable
fun MainPage(state: AppState) {
    val navController = rememberNavController()
    state.navController = navController

    NavHost(
        navController = navController,
        startDestination = "home",
        builder = {
            composable("home") {
                HomePage(state = state)
            }
        }
    )
}

