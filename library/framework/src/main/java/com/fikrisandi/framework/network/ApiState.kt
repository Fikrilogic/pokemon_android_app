package com.fikrisandi.framework.network

sealed class ApiState<out T> {
    data class Success<out T>(val result: T): ApiState<T>()
    data class Error(val error: Throwable): ApiState<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$result]"
            is Error -> "Error[exception=$error]"
        }
    }

    inline fun <R : Any> map(transform: (T) -> R): ApiState<R> {
        return when (this) {
            is Error -> Error(this.error)
            is Success -> Success(transform(this.result))
        }
    }

    suspend inline fun <R : Any> suspendMap(crossinline transform: suspend (T) -> R): ApiState<R> {
        return when (this) {
            is Error -> Error(this.error)
            is Success -> Success(transform(this.result))
        }
    }
}