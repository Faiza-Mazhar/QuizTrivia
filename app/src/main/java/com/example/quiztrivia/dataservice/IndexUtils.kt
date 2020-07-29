package com.example.quiztrivia.dataservice

import com.example.quiztrivia.optionselection.SelectedItemIndexes
import kotlin.random.Random

fun getNumQuestionFromIndex(index: Int): String {
    return when(index) {
        1, 2, 3, 4, 5, 6 -> (index + 4).toString()
        7 -> "15"
        8 -> "20"
        else -> Random.nextInt(10).toString()
    }
}

fun getDifficultyLevelFromIndex(index: Int): String {
    return when(index) {
        1 -> "easy"
        2 -> "medium"
        3 -> "hard"
        else -> ""
    }
}

fun getCategoryNumberFromIndex(index: Int): String {
    return (index + 8).toString()
}

fun getURLString(selectedItemIndexes: SelectedItemIndexes): String {

    var urlString = "amount=${getNumQuestionFromIndex(
        selectedItemIndexes.numOfQuestions
    )}"

    if(selectedItemIndexes.category != 0) {
            urlString += "&category=${getCategoryNumberFromIndex(
                selectedItemIndexes.category
            )}"
    }

    if(selectedItemIndexes.difficultyLevel != 0) {
        urlString += "&difficulty=${getDifficultyLevelFromIndex(
            selectedItemIndexes.difficultyLevel
        )}"
    }

    return "$urlString&type=multiple"
}