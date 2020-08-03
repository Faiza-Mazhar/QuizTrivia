package com.example.quiztrivia.dataservice

import com.example.quiztrivia.optionselection.CategoryMetadata
import com.example.quiztrivia.optionselection.QuestionMetadata
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class DataManager() {
    private val dataHandler = DataHandlerOkhttp()

    suspend fun getCategoriesMetadata(): List<CategoryMetadata> {
        return dataHandler.getCategoryMetadata("https://opentdb.com/api_category.php")
    }

    fun getCategoriesArray(categoriesMetadata: List<CategoryMetadata>) : Array<String?> {
        return dataHandler.getCategoryArray(categoriesMetadata)
    }

    suspend fun getQuestionsMetadata(urlString: String) : List<QuestionMetadata> {
        return dataHandler.getQuestionMetadata(urlString)
    }
}


