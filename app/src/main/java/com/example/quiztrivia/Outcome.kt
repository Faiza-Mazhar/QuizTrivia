package com.example.quiztrivia

sealed class Outcome<out T> {

    data class Success<T>(val payload: T) : Outcome<T>()

    data class Failure(val error: Error) : Outcome<Nothing>()
}
