package com.jsrm.dogedex.internetConection

sealed class ResponseStatus<T>() {
    class Success<T>(val data: T) : ResponseStatus<T>()
    class Loading<T>() : ResponseStatus<T>()
    class Error<T>(val message: String) : ResponseStatus<T>()
}