package com.example.quiztrivia.network


import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

class RetrofitService : NetworkService {
    private val baseURL = "https://opentdb.com/"
    companion object {
        private const val REMOTE_CONFIG_REFRESH_PERIOD_MILLIS = 600_000L
    }

    private fun getRetrofit(url: String) : Retrofit {
        return Retrofit
              .Builder()
              .baseUrl(url)
              .addCallAdapterFactory(CoroutineCallAdapterFactory())
              .addConverterFactory(ScalarsConverterFactory.create())
              .build()
    }

    interface ApiService {
        @GET("api.php?amount=10")
        suspend fun getResponseAsync(): Deferred<String>
    }

    override suspend fun getNetworkResponse(url: String): String {
        val apiService = getRetrofit(baseURL).create(ApiService::class.java)
        return apiService.getResponseAsync().await()
    }
}
