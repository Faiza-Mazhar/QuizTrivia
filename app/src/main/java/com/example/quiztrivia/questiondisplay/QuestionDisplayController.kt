package com.example.quiztrivia.questiondisplay

import com.example.quiztrivia.optionselection.QuestionMetadata
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class QuestionDisplayController(
    private val questionDisplayViewModel: QuestionDisplayViewModel,
    private val questionDisplayView: QuestionDisplayView
    ) {

    init {
            questionDisplayView.hideQA()
            questionDisplayView.hideSubmitButton()
            questionDisplayView.hideNumQuestion()
            questionDisplayView.hideCategoryDifficulty()
            questionDisplayViewModel.onQuestionMetadataLoaded = {
                setupDisplay()
            }

        questionDisplayView.setSubmitButtonClickListener {
            submitAnswer()
        }

        questionDisplayView.setNextButtonClickListener {
            nextQuestion()
        }

        questionDisplayView.setTryAgainButtonClickListener {
            questionDisplayViewModel.getQuestionMetadata()
        }
    }

    private fun setupDisplay() {
        if (questionDisplayViewModel.questionsMetadata.isNotEmpty()) {
            questionDisplayView.showQA()
            questionDisplayView.showSubmitButton()
            questionDisplayView.showNumQuestion()
            questionDisplayView.showCategoryDifficulty()
            questionDisplayView.hideProgressbar()
            bindData(questionDisplayViewModel.questionsMetadata[questionDisplayViewModel.currentQuestion])
            updateCurrentQuestionDisplay()
        } else {
            questionDisplayView.hideProgressbar()
            questionDisplayView.showTryAgainButton()
        }
    }

    private fun bindData(questionMetadata: QuestionMetadata) {
        questionDisplayView.bind(questionMetadata)

    }

    private fun updateCurrentQuestionDisplay() {
        questionDisplayView.setNumOfQuestion(
            questionDisplayViewModel.currentQuestion + 1,
            questionDisplayViewModel.questionsMetadata.size)
    }

    private fun submitAnswer() {
        if(checkAnswer()){
                questionDisplayViewModel.correctQuestion++
                displayRightAnswerReply()
            } else {
                displayWrongAnswerReply()
            }
        questionDisplayView.hideSubmitButton()
        questionDisplayView.showNextButton()
    }

    private fun nextQuestion() {
        if(questionDisplayViewModel.currentQuestion < questionDisplayViewModel.questionsMetadata.size-1) {
            questionDisplayViewModel.currentQuestion++
            bindData(questionDisplayViewModel.questionsMetadata[questionDisplayViewModel.currentQuestion])
            updateCurrentQuestionDisplay()
            questionDisplayView.hideQuestionReply()
            questionDisplayView.showSubmitButton()
            questionDisplayView.hideNextButton()
        } else {
            navigateToGameFinish()
        }
    }

    private fun navigateToGameFinish() {
        val finalScore = FinalScore(
            questionDisplayViewModel.correctQuestion,
            questionDisplayViewModel.questionsMetadata.size
        )
        questionDisplayView.navigateToGameFinish(finalScore)
    }


    private fun displayRightAnswerReply () {
        questionDisplayView.setQuestionReply(getRightAnswerReply())
    }

    private fun displayWrongAnswerReply () {
        questionDisplayView.setQuestionReply(getWrongAnswerReply())
    }

    private fun getWrongAnswerReply(): String {
        return "Sorry, right answer is: ${questionDisplayViewModel.questionsMetadata[questionDisplayViewModel.currentQuestion].correctAnswer}"
    }

    private fun getRightAnswerReply(): String {
        return "Yeah, You answer is correct"
    }
    private fun checkAnswer(): Boolean {
        val selectedAnswer = questionDisplayView.getSelectedRadioButtonText()
        return selectedAnswer == questionDisplayViewModel.questionsMetadata[questionDisplayViewModel.currentQuestion].correctAnswer
    }
}