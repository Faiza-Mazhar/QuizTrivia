package com.example.quiztrivia.questiondisplay

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quiztrivia.dataservice.DataHandler
import com.example.quiztrivia.optionselection.QuestionMetadata

class QuestionDisplayViewModel (val dataHandler: DataHandler): ViewModel() {

    val coroutineScope = viewModelScope

    lateinit var questionsMetadata: List<QuestionMetadata>

}