package com.example.quiztrivia.dataservice

import com.example.quiztrivia.optionselection.CategoryDefinitionList
import com.example.quiztrivia.optionselection.QuestionsDefinitionList

interface DataHandler {
    suspend fun getQuestionDefinition(urlString: String): QuestionsDefinitionList?
    suspend fun getCategoryDefinition(urlString: String): CategoryDefinitionList?
}