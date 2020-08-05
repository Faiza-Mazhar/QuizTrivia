package com.example.quiztrivia.optionselection

import android.os.Parcelable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quiztrivia.dataservice.DataManager
import kotlinx.android.parcel.Parcelize

class OptionSelectionViewModel(val dataManager: DataManager): ViewModel() {

    var selectedItemIndexes = SelectedItemIndexes()
    val coroutineScope = viewModelScope
    lateinit var categoriesMetadata: List<CategoryMetadata>
    var categoryArray: Array<String?>? = null

    fun setIndexes(numOfQuestionIndex: Int, categoryIndex: Int, difficultyLevel:Int) {
        selectedItemIndexes = SelectedItemIndexes(numOfQuestionIndex, categoryIndex, difficultyLevel)
    }


}
@Parcelize
data class SelectedItemIndexes(
    var numOfQuestions: Int = 0,
    var category: Int = 0,
    var difficultyLevel:Int = 0)
    : Parcelable