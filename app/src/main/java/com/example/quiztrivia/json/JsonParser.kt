package com.example.quiztrivia.json

import com.example.quiztrivia.optionselection.QuestionsListDefinition

class JsonParser {
    private val parser = MoshiService()

    fun getQuestionDefinition(jsonString : String): QuestionsListDefinition? {
        return parser.fromJson(jsonString, QuestionsListDefinition::class)
    }
}