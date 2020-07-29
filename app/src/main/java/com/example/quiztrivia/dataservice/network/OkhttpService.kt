package com.example.quiztrivia.dataservice.network

import okhttp3.OkHttpClient
import okhttp3.Request
import ru.gildor.coroutines.okhttp.await

class OkhttpService : NetworkService {

    private val client: OkHttpClient = OkHttpClient.Builder().build()
    private lateinit var request: Request

    override suspend fun getNetworkResponse(url: String): String {
        request = Request.Builder().url(url).build()
        val result = client.newCall(request).await()
        return result.body()?.string().toString()
    }
}