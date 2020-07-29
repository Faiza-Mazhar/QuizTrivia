package com.example.quiztrivia.questiondisplay

import android.util.Log
import com.example.quiztrivia.optionselection.SelectedItemIndexes

class QuestionDisplayController(
    questionDisplayViewModel: QuestionDisplayViewModel,
    questionDisplayView: QuestionDisplayView,
    selectedIndexes: SelectedItemIndexes
    ) {

    init {
        Log.d("faiza", selectedIndexes.toString())
    }
}