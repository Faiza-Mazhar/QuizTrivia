package com.example.quiztrivia.dataservice

import com.example.quiztrivia.Outcome
import com.example.quiztrivia.dataservice.json.JsonParser
import com.example.quiztrivia.dataservice.network.NetworkService
import com.example.quiztrivia.dataservice.network.OkhttpService
import com.example.quiztrivia.optionselection.CategoryMetadata
import com.example.quiztrivia.optionselection.QuestionMetadata
import kotlinx.coroutines.ExperimentalCoroutinesApi

class DataHandlerOkhttp(): DataHandler {

    private val okhttpService: NetworkService = OkhttpService()
    private val jsonParser = JsonParser()
    private val dataAdapter = DataAdapter()

    @ExperimentalCoroutinesApi
    override suspend fun getQuestionMetadata(urlString: String): List<QuestionMetadata>{
        val networkResponse = getNetworkResponse(urlString)
        val questionsDefinitionList = jsonParser.questionsDefinitionList(networkResponse)
        return dataAdapter.convertQuestionDefinitionToQuestionMetadata(questionsDefinitionList!!)
    }
    
    override fun getCategoryMetadata(categoryMetadataResponse: String): List<CategoryMetadata>  {
        val categoryDefinitionList = jsonParser.getCategoryDefinitionList(categoryMetadataResponse)
        return dataAdapter.convertCategoryDefinitionToCategoryMetadata(categoryDefinitionList)
    }

    @ExperimentalCoroutinesApi
    override suspend fun getCategoryMetadataResponse(urlString: String): String {
        return getNetworkResponse(urlString)
    }

    @ExperimentalCoroutinesApi
    private suspend fun getNetworkResponse(urlString: String): String {
        return when (val outcome = okhttpService.getNetworkResponse(urlString)) {
            is Outcome.Success -> outcome.payload
            is Outcome.Failure -> outcome.error.toString()
        }
    }

    override fun getCategoryArray(categoryMetadata: List<CategoryMetadata>) : Array<String?> {
        return dataAdapter.convertCategoryMetadataListToArray(categoryMetadata)
    }
}