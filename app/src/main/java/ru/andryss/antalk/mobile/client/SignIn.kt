package ru.andryss.antalk.mobile.client

import android.util.Log
import ru.andryss.antalk.mobile.AppState
import ru.andryss.antalk.mobile.TAG

data class SignInRequest(
    val username: String,
    val password: String,
)

data class SignInResponse(
    val session: SessionInfo
)

data class SessionInfo(
    val id: Long,
    val token: String
)

fun AppState.signIn(
    request: SignInRequest,
    onSuccess: (response: SignInResponse) -> Unit,
    onError: (error: ErrorObject) -> Unit,
) {
    Log.i(TAG, "Send sign in request for ${request.username}")
    httpRequest(
        "POST",
        "/auth/signin",
        mapper.writeValueAsString(request),
        callbackObj<SignInResponse>(
            onSuccess = {
                Log.i(TAG, "Got sign in response, sesion ${it.session.id}")
                onSuccess(it)
            },
            onError = onError
        )
    )
}