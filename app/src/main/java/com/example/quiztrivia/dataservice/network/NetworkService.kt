package com.example.quiztrivia.dataservice.network

interface NetworkService {
    suspend fun getNetworkResponse(url: String): String
}