package com.example.quiztrivia.dataservice.network


import com.example.quiztrivia.optionselection.CategoryDefinitionList
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

class RetrofitService {
    private val baseURL = "https://opentdb.com/"

    private fun getRetrofit() : Retrofit {
        return Retrofit
              .Builder()
              .baseUrl(baseURL)
              .addConverterFactory(MoshiConverterFactory.create())
              .build()
    }

    interface ApiService {
        @GET("api_category.php")
        suspend fun getResponseAsync(): Deferred<CategoryDefinitionList>
    }

    suspend fun getNetworkResponse(url: String): CategoryDefinitionList {
        val apiService = getRetrofit().create(ApiService::class.java)
        return apiService.getResponseAsync().await()
    }
}

