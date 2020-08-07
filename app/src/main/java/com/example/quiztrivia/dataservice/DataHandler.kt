package com.example.quiztrivia.dataservice

import com.example.quiztrivia.optionselection.CategoryMetadata
import com.example.quiztrivia.optionselection.QuestionMetadata

interface DataHandler {
    suspend fun getQuestionMetadata(urlString: String): List<QuestionMetadata>
    fun getCategoryMetadata(categoryMetadataResponse: String): List<CategoryMetadata>
    suspend fun getCategoryMetadataResponse(urlString: String): String
}