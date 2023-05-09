package com.jsrm.dogedex.internetConection

import android.util.Log
import com.jsrm.dogedex.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

suspend fun <T> makeNetworkCall(
    call: suspend () -> T
): ResponseStatus<T> = withContext(Dispatchers.IO) {
    try {
        ResponseStatus.Success(call())
    } catch (e: UnknownHostException) {
        ResponseStatus.Error(R.string.there_is_no_internet_connection)
    } catch (e: Exception) {
        val errorMessage = when(e.message){
            "sign_up_error" -> R.string.error_sign_up
            "sign_in_error" -> R.string.sign_in_error
            "user_already_exists" -> R.string.user_already_exists
            else -> R.string.unknown_error
        }
        ResponseStatus.Error(errorMessage)
    }
}
