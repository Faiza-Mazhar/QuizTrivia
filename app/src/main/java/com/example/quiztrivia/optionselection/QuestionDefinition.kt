package com.example.quiztrivia.optionselection

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class QuestionDefinition (
    var category: String,
    var type: String,
    var difficulty: String,
    var question: String,
 //   @SerializedName("correct_answer")
    @Json(name = "correct_answer")
    var correctAnswer: String,
//    @SerializedName("incorrect_answers")
    @Json(name = "incorrect_answers")
    var wrongAnswers: List<String>
)

@JsonClass(generateAdapter = true)
data class QuestionsListDefinition( var results : List<QuestionDefinition>)

data class QuestionMetadata (
    var category: String,
    var difficulty: String,
    var question: String,
    var correctAnswer: String,
    var wrongAnswers: List<String>
)

data class QuestionListMetadata (
    var questions: List<QuestionListMetadata>
)