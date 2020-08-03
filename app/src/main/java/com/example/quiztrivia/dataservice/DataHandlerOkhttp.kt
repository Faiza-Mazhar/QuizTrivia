package com.example.quiztrivia.dataservice

import com.example.quiztrivia.Outcome
import com.example.quiztrivia.dataservice.json.JsonParser
import com.example.quiztrivia.dataservice.network.OkhttpService
import com.example.quiztrivia.optionselection.CategoryMetadata
import com.example.quiztrivia.optionselection.QuestionMetadata
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class DataHandlerOkhttp(): DataHandler {

    private val okhttpService = OkhttpService()
    private val jsonParser = JsonParser()
    private val dataAdapter = DataAdapter()

    override suspend fun getQuestionMetadata(urlString: String): List<QuestionMetadata>{
        val response = getNetworkResponse(urlString)
        val questionsDefinitionList = jsonParser.questionsDefinitionList(response)
        return dataAdapter.convertQuestionDefinitionToQuestionMetadata(questionsDefinitionList!!)
    }

    override suspend fun getCategoryMetadata(urlString: String): List<CategoryMetadata>  {
        val response = getNetworkResponse(urlString)
        val categoryDefinitionList = jsonParser.getCategoryDefinitionList(response)
        return dataAdapter.convertCategoryDefinitionToCategoryMetadata(categoryDefinitionList)
    }

    private suspend fun getNetworkResponse(urlString: String): String {
        return when (val outcome = okhttpService.getNetworkResponse(urlString)) {
            is Outcome.Success -> outcome.payload
            is Outcome.Failure -> outcome.error.toString()
        }
    }

    fun getCategoryArray(categoryMetadata: List<CategoryMetadata>) : Array<String?> {
        return dataAdapter.convertCategoryDefinitionListToArray(categoryMetadata)
    }
}