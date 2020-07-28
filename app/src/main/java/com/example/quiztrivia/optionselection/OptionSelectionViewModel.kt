package com.example.quiztrivia.optionselection

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OptionSelectionViewModel(): ViewModel() {

    var selectedItemIndexes =  MutableLiveData<SelectedItemIndexes>()
    lateinit var urlString : String

    fun setIndexes(numOfQuestionIndex: Int, categoryIndex: Int, difficultyLevel:Int) {
        selectedItemIndexes.value = SelectedItemIndexes(numOfQuestionIndex, categoryIndex, difficultyLevel)
    }

    fun setURLString(url: String) {
        urlString = url
    }
}

data class SelectedItemIndexes(var numOfQuestions: Int = 0, var category: Int = 0, var difficultyLevel:Int = 0)