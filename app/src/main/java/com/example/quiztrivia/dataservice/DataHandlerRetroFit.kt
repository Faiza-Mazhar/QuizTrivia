package com.example.quiztrivia.dataservice

import com.example.quiztrivia.optionselection.CategoryMetadata
import com.example.quiztrivia.optionselection.QuestionMetadata

class DataHandlerRetroFit(): DataHandler {

    override suspend fun getQuestionMetadata(urlString: String): List<QuestionMetadata> {
        TODO("Not yet implemented")
    }

    override suspend fun getCategoryMetadata(urlString: String): List<CategoryMetadata> {
        TODO()
    }
}