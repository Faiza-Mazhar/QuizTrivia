package com.example.quiztrivia.dataservice

import com.example.quiztrivia.optionselection.CategoryMetadata
import com.example.quiztrivia.optionselection.QuestionMetadata
import kotlinx.coroutines.ExperimentalCoroutinesApi


class DataManager() {
    private val dataHandler = DataHandlerOkhttp()

    fun getCategoriesMetadata(categoryInfo: String): List<CategoryMetadata> {
        return dataHandler.getCategoryMetadata(categoryInfo)
    }

    fun getCategoriesArray(categoriesMetadata: List<CategoryMetadata>) : Array<String?> {
        return dataHandler.getCategoryArray(categoriesMetadata)
    }

    @ExperimentalCoroutinesApi
    suspend fun getCategoryNetworkResponse() : String {
        return dataHandler.getCategoryMetadataResponse("https://opentdb.com/api_category.php")
    }

    @ExperimentalCoroutinesApi
    suspend fun getQuestionsMetadata(urlString: String) : List<QuestionMetadata> {
        return dataHandler.getQuestionMetadata(urlString)
    }
}


