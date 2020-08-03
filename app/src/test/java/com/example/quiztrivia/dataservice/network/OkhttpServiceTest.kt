package com.example.quiztrivia.dataservice.network

import com.example.quiztrivia.Outcome
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test


internal class OkhttpServiceTest {

    private val testDataJson = "{\"name\":\"${"hello"}\"}"
    private var url = "/"
    private val server = MockWebServer()
    private val networkService = OkhttpService()


    @Before
    fun setUp() {
        val mockedResponse = MockResponse()
            .setBody(testDataJson)
            .addHeader("Content-Type", "application/json")
        server.enqueue(mockedResponse)
        server.start()
        url = server.url(url).toString()
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getNetworkResponse()  = runBlocking{
        val expectedResponse : Outcome.Success<String> = Outcome.Success(payload = testDataJson)
        val outcome = networkService.getNetworkResponse(url)

        Assert.assertEquals(expectedResponse, outcome)
    }
}

