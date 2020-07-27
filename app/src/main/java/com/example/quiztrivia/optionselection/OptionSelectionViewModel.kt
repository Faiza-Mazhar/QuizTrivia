package com.example.quiztrivia.optionselection

import androidx.lifecycle.ViewModel

class OptionSelectionViewModel(): ViewModel() {

    private lateinit var selectedItemIndexes : SelectedItemIndexes

    fun setIndexes(categoryIndex: Int, numOfQuestionIndex: Int, difficultyLevel:Int) {
        selectedItemIndexes = SelectedItemIndexes(categoryIndex, numOfQuestionIndex, difficultyLevel)
    }
}

data class SelectedItemIndexes(var category: Int = 0, var numOfQuestions: Int = 0, var difficultyLevel:Int = 0)