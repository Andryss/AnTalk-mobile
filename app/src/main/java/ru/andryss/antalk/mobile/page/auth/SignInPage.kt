package ru.andryss.antalk.mobile.page.auth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import ru.andryss.antalk.mobile.AppState
import ru.andryss.antalk.mobile.client.SignInRequest
import ru.andryss.antalk.mobile.client.formatError
import ru.andryss.antalk.mobile.client.signIn

@Composable
fun SignInPage(state: AppState) {

    val context = LocalContext.current

    var signInLoading by remember { mutableStateOf(false) }

    var username by remember { mutableStateOf("") }
    var isUsernameError by remember { mutableStateOf(false) }

    var password by remember { mutableStateOf("") }
    var isPasswordError by remember { mutableStateOf(false) }

    var showAlert by remember { mutableStateOf(false) }
    var alertText by remember { mutableStateOf("") }

    fun getUsername() =
        username.trim().lowercase()

    fun getPassword() =
        password.trim()

    fun onSignIn() {
        val usernameValue = getUsername()
        if (usernameValue.isBlank()) {
            isUsernameError = true
            return
        }
        isUsernameError = false

        val passwordValue = getPassword()
        if (passwordValue.isBlank()) {
            isPasswordError = true
            return
        }
        isPasswordError = false

        signInLoading = true
        state.signIn(
            SignInRequest(
                username = usernameValue,
                password = passwordValue
            ),
            onSuccess = { result ->
                state.onSignInSuccess(context, result)
                signInLoading = false
            },
            onError = { error ->
                alertText = formatError(error)
                showAlert = true
                signInLoading = false
            }
        )
    }

    // TODO
}