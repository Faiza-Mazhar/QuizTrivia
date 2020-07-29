package com.example.quiztrivia.dataservice.json

import com.example.quiztrivia.optionselection.QuestionsDefinitionList

class JsonParser {
    private val parser = MoshiService()

    fun getQuestionDefinition(jsonString : String): QuestionsDefinitionList? {
        return parser.fromJson(jsonString, QuestionsDefinitionList::class)
    }
}