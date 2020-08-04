package com.example.quiztrivia.questiondisplay

import com.example.quiztrivia.R
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
        questionDisplayView.setSubmitButtonClickListener {
            submitAnswer()
        }

        questionDisplayView.setNextButtonClickListener {
            nextQuestion()
        }
    }

    private fun getQuestionMetadata() {
        questionDisplayViewModel.coroutineScope.launch {
            withContext(Dispatchers.IO) {
                questionDisplayViewModel.questionsMetadata = questionDisplayViewModel.dataManager.getQuestionsMetadata(urlString)
            }

            if(questionDisplayViewModel.questionsMetadata.isNotEmpty()) {
                bindData(questionDisplayViewModel.questionsMetadata[questionDisplayViewModel.currentQuestion])
                updateCurrentQuestionDisplay()
            } else {
                TODO()
            }
        }
    }

    private fun bindData(questionMetadata: QuestionMetadata) {
        questionDisplayView.bind(questionMetadata)
    }

    private fun updateCurrentQuestionDisplay() {
        questionDisplayView.setNumOfQuestion(questionDisplayViewModel.currentQuestion + 1, questionDisplayViewModel.questionsMetadata.size)
    }

    private fun submitAnswer() {
        questionDisplayView.hideQA()
        if(checkAnswer()){
                questionDisplayViewModel.correctQuestion++
                displayRightAnswerReply()
            } else {
                displayWrongAnswerReply()
            }
    }

    private fun nextQuestion() {
        questionDisplayView.hideQuestionReply().showQA()
        if(questionDisplayViewModel.currentQuestion < questionDisplayViewModel.questionsMetadata.size-1) {
            questionDisplayViewModel.currentQuestion++
            bindData(questionDisplayViewModel.questionsMetadata[questionDisplayViewModel.currentQuestion])
            updateCurrentQuestionDisplay()
        } else {
            questionDisplayView.navController.navigate(
                R.id.homeFragment)
        }
    }


    private fun displayRightAnswerReply () {
        questionDisplayView.setQuestionReply("Yeah, Correct Answer")
    }

    private fun displayWrongAnswerReply () {
        questionDisplayView.setQuestionReply("Sorry, right answer is: ${questionDisplayViewModel.questionsMetadata[questionDisplayViewModel.currentQuestion].correctAnswer}")
    }
    private fun checkAnswer(): Boolean {
        val selectedAnswer = questionDisplayView.getSelectedRadioButtonText()
        return selectedAnswer == questionDisplayViewModel.questionsMetadata[questionDisplayViewModel.currentQuestion].correctAnswer
    }
}