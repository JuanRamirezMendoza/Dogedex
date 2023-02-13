package com.jsrm.dogedex.internetConection

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

suspend fun <T> makeNetworkCall(
    call: suspend () -> T,
) = withContext(Dispatchers.IO) {
    try {
        ResponseStatus.Success(call)
    } catch (e: UnknownHostException) {
        ResponseStatus.Error("No hay internet")
    } catch (e: Exception) {
        ResponseStatus.Error("Error desconocido")
    }
}
