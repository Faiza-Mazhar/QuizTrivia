package com.example.quiztrivia.dataservice

import com.example.quiztrivia.Outcome
import com.example.quiztrivia.dataservice.json.JsonParser
import com.example.quiztrivia.dataservice.network.OkhttpService
import com.example.quiztrivia.optionselection.CategoryDefinitionList
import com.example.quiztrivia.optionselection.QuestionsDefinitionList
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class DataHandlerOkhttp(): DataHandler {
    private val okhttpService = OkhttpService()
    private val jsonParser = JsonParser()
    override fun getQuestionDefinition(urlString: String): QuestionsDefinitionList {
        TODO("Not yet implemented")
    }

    override suspend fun getCategoryDefinition(urlString: String): CategoryDefinitionList? {
        val response = getNetworkResponse(urlString)
        return jsonParser.getCategoryDefinitionList(response)
    }

    private suspend fun getNetworkResponse(urlString: String): String {
        return when (val outcome = okhttpService.getNetworkResponse(urlString)) {
            is Outcome.Success -> outcome.payload
            is Outcome.Failure -> outcome.error.toString()
        }
    }
}