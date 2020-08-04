package com.example.quiztrivia.dataservice

import com.example.quiztrivia.optionselection.CategoryMetadata
import com.example.quiztrivia.optionselection.QuestionMetadata

interface DataHandler {
    suspend fun getQuestionMetadata(urlString: String): List<QuestionMetadata>
    suspend fun getCategoryMetadata(urlString: String): List<CategoryMetadata>
}