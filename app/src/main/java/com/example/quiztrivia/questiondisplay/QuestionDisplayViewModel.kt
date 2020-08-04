package com.example.quiztrivia.questiondisplay

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quiztrivia.dataservice.DataManager
import com.example.quiztrivia.optionselection.QuestionMetadata

class QuestionDisplayViewModel (val dataManager: DataManager): ViewModel() {

    val coroutineScope = viewModelScope

    lateinit var questionsMetadata: List<QuestionMetadata>

    var currentQuestion = 0

    var correctQuestion = 0

}