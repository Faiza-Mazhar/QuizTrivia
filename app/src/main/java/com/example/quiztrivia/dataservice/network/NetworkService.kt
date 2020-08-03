package com.example.quiztrivia.dataservice.network

import com.example.quiztrivia.Outcome

interface NetworkService {
    suspend fun getNetworkResponse(url: String): Outcome<String>
}