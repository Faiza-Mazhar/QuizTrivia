package com.example.quiztrivia.dataservice

import com.example.quiztrivia.optionselection.QuestionsDefinitionList

interface DataHandler {
    fun getQuestionDefinition(urlString: String): QuestionsDefinitionList
}