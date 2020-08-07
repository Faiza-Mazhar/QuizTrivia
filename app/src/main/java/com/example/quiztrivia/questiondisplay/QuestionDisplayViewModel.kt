package com.example.quiztrivia.questiondisplay

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quiztrivia.dataservice.DataManager
import com.example.quiztrivia.dataservice.getURLString
import com.example.quiztrivia.optionselection.QuestionMetadata
import com.example.quiztrivia.optionselection.SelectedItemIndexes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@ExperimentalCoroutinesApi
class QuestionDisplayViewModel (private val dataManager: DataManager, val selectedItemIndexes: SelectedItemIndexes): ViewModel() {

    private var urlString: String = getURLString(selectedItemIndexes)

    lateinit var questionsMetadata: List<QuestionMetadata>

    var currentQuestion = 0
    var correctQuestion = 0
    var onQuestionMetadataLoaded : (() -> Unit)? = null
    var hasDataLoaded = false

    init {
        getQuestionMetadata()
    }

    private fun getQuestionMetadata() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                questionsMetadata = dataManager.getQuestionsMetadata(urlString)
            }
            onQuestionMetadataLoaded?.invoke()
            hasDataLoaded = true
        }
    }
}