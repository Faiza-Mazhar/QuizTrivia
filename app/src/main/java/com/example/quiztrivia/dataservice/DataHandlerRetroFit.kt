package com.example.quiztrivia.dataservice

import com.example.quiztrivia.optionselection.CategoryMetadata
import com.example.quiztrivia.optionselection.QuestionMetadata

class DataHandlerRetroFit(): DataHandler {

    override val dataAdapter: DataAdapter = DataAdapter()

    override suspend fun getQuestionMetadata(urlString: String): List<QuestionMetadata> {
        TODO("Not yet implemented")
    }

    override fun getCategoryMetadata(categoryMetadataResponse: String): List<CategoryMetadata> {
        TODO("Not yet implemented")
    }

    override suspend fun getCategoryMetadataResponse(urlString: String): String {
        TODO("Not yet implemented")
    }

    override fun getCategoryArray(categoryMetadata: List<CategoryMetadata>): Array<String?> {
        TODO("Not yet implemented")
    }


}