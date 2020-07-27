package com.example.quiztrivia.network

interface NetworkService {
    suspend fun getNetworkResponse(url: String): String
}