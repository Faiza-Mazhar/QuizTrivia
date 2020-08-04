package com.example.quiztrivia.questiondisplay

import com.example.quiztrivia.dataservice.getURLString
import com.example.quiztrivia.optionselection.QuestionMetadata
import com.example.quiztrivia.optionselection.SelectedItemIndexes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@ExperimentalCoroutinesApi
class QuestionDisplayController(
    private val questionDisplayViewModel: QuestionDisplayViewModel,
    private val questionDisplayView: QuestionDisplayView,
    selectedIndexes: SelectedItemIndexes
    ) {

    private var urlString: String = getURLString(selectedIndexes)
    init {
        getQuestionMetadata()
    }

    private fun getQuestionMetadata() {
        questionDisplayViewModel.coroutineScope.launch {
            withContext(Dispatchers.IO) {
                questionDisplayViewModel.questionsMetadata = questionDisplayViewModel.dataManager.getQuestionsMetadata(urlString)
            }

            bindData(questionDisplayViewModel.questionsMetadata[0])
            questionDisplayView.setNumOfQuestion(0, questionDisplayViewModel.questionsMetadata.size)
        }
    }

    private fun bindData(questionMetadata: QuestionMetadata) {
        questionDisplayView.bind(questionMetadata)
    }

}