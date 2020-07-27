package com.example.quiztrivia

sealed class Outcome<out T : Any> {
    data class Success<out T : Any>(val payload: T) : Outcome<T>()
    data class Failure(val error: Error) : Outcome<Nothing>()
}
