package com.example.quiztrivia.optionselection

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class QuestionDefinition (
    var category: String,
    var type: String,
    var difficulty: String,
    var question: String,
    @Json(name = "correct_answer")
    var correctAnswer: String,
    @Json(name = "incorrect_answers")
    var wrongAnswers: List<String>
)

@JsonClass(generateAdapter = true)
data class QuestionsDefinitionList(var results : List<QuestionDefinition>) {

}

@JsonClass(generateAdapter = true)
data class CategoryDefinition(val id: Int, val name: String)

@JsonClass(generateAdapter = true)
data class CategoryDefinitionList(val trivia_categories: List<CategoryDefinition>)


data class QuestionMetadata (
    var category: String,
    var difficulty: String,
    var question: String,
    var correctAnswer: String,
    var wrongAnswers: List<String>
)

data class CategoryMetadata (
    val id: Int, val name: String
)