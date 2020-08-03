package com.example.quiztrivia.dataservice

import com.example.quiztrivia.optionselection.CategoryDefinitionList
import com.example.quiztrivia.optionselection.QuestionsDefinitionList

class DataHandlerRetroFit(): DataHandler {

    override suspend fun getQuestionDefinition(urlString: String): QuestionsDefinitionList {
        TODO("Not yet implemented")
    }

    override suspend fun getCategoryDefinition(urlString: String): CategoryDefinitionList {
        TODO()
    }
}