package com.example.quiztrivia.optionselection

import android.os.Parcelable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.android.parcel.Parcelize

class OptionSelectionViewModel(): ViewModel() {

    var selectedItemIndexes =  MutableLiveData<SelectedItemIndexes>()

    fun setIndexes(numOfQuestionIndex: Int, categoryIndex: Int, difficultyLevel:Int) {
        selectedItemIndexes.value = SelectedItemIndexes(numOfQuestionIndex, categoryIndex, difficultyLevel)
    }
}
@Parcelize
data class SelectedItemIndexes(
    var numOfQuestions: Int = 0,
    var category: Int = 0,
    var difficultyLevel:Int = 0)
    : Parcelable