package com.example.quiztrivia.dataservice.network

import com.example.quiztrivia.Outcome
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.suspendCancellableCoroutine
import okhttp3.*
import java.io.IOException
import kotlin.coroutines.resume

class OkhttpService : NetworkService {

    private fun getNetworkResponse(url: String, callback: Callback): Call {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(url)
            .build()
        val call = client.newCall(request)
        call.enqueue(callback)
        return call
    }

    @ExperimentalCoroutinesApi
    override suspend fun getNetworkResponse(url: String): Outcome<String> {
        return suspendCancellableCoroutine { continuation ->
            getNetworkResponse(url, object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    val outcome = Outcome.Failure(Error(e.message))
                    continuation.resume(outcome)
                }
                override fun onResponse(call: Call, response: Response) {
                    response.body?.string()?.also {
                        val outcome = Outcome.Success(it)
                        continuation.resume(outcome)
                    }
                }
            })
        }
    }
}