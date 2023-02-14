package com.jsrm.dogedex.internetConection

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

suspend fun <T> makeNetworkCall(
    call: suspend () -> T
): ResponseStatus<T> = withContext(Dispatchers.IO) {
    try {
        ResponseStatus.Success(call())
    } catch (e: UnknownHostException) {
        ResponseStatus.Error("No hay internet")
    } catch (e: Exception) {
        Log.e("XDDD", e.toString())
        ResponseStatus.Error("Error desconocido")
    }
}
