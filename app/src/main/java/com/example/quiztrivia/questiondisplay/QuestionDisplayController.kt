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
    private val selectedIndexes: SelectedItemIndexes
    ) {

    private var urlString: String = getURLString(selectedIndexes)
    init {

        questionDisplayView
            .hideQA()
            .hideSubmitButton()
            .hideNumQuestion()

        getQuestionMetadata()
        questionDisplayView.setSubmitButtonClickListener {
            submitAnswer()
        }

        questionDisplayView.setNextButtonClickListener {
            nextQuestion()
        }

        questionDisplayView.setTryAgainButtonClickListener {
            retryAgain()
        }
    }

    private fun retryAgain() {
        questionDisplayView.navController.navigate(QuestionDisplayFragmentDirections.actionQuizQuestionsSelf(selectedIndexes))
    }

    private fun getQuestionMetadata() {
        questionDisplayViewModel.coroutineScope.launch {
            withContext(Dispatchers.IO) {
                questionDisplayViewModel.questionsMetadata = questionDisplayViewModel.dataManager.getQuestionsMetadata(urlString)
            }
            setupDisplay()
        }
    }

    private fun setupDisplay() {
        if (questionDisplayViewModel.questionsMetadata.isNotEmpty()) {
            questionDisplayView
                .showQA()
                .showSubmitButton()
                .showNumQuestion()

            bindData(questionDisplayViewModel.questionsMetadata[questionDisplayViewModel.currentQuestion])
            updateCurrentQuestionDisplay()
        } else {
            questionDisplayView
                .hideQA()
                .hideProgressbar()
                .hideSubmitButton()
                .showTryAgainButton()
        }
    }

    private fun bindData(questionMetadata: QuestionMetadata) {
        questionDisplayView.bind(questionMetadata).hideProgressbar()
    }

    private fun updateCurrentQuestionDisplay() {
        questionDisplayView.setNumOfQuestion(questionDisplayViewModel.currentQuestion + 1, questionDisplayViewModel.questionsMetadata.size)
    }

    private fun submitAnswer() {
        if(checkAnswer()){
                questionDisplayViewModel.correctQuestion++
                displayRightAnswerReply()
            } else {
                displayWrongAnswerReply()
            }
        questionDisplayView.hideSubmitButton().showNextButton()
    }

    private fun nextQuestion() {
        questionDisplayView.hideQuestionReply().showQA()
        if(questionDisplayViewModel.currentQuestion < questionDisplayViewModel.questionsMetadata.size-1) {
            questionDisplayViewModel.currentQuestion++
            bindData(questionDisplayViewModel.questionsMetadata[questionDisplayViewModel.currentQuestion])
            updateCurrentQuestionDisplay()
            questionDisplayView.showSubmitButton().hideNextButton()
        } else {
            navigateToGameFinish()
        }
    }

    private fun navigateToGameFinish() {
        val finalScore = FinalScore(
            questionDisplayViewModel.correctQuestion,
            questionDisplayViewModel.questionsMetadata.size
        )

        questionDisplayView.navController.navigate(
            QuestionDisplayFragmentDirections.actionQuizQuestionsToGameFinishFragment(finalScore)
        )
    }


    private fun displayRightAnswerReply () {
        questionDisplayView.setQuestionReply("Yeah, You answer is correct")
    }

    private fun displayWrongAnswerReply () {
        questionDisplayView.setQuestionReply("Sorry, right answer is: ${questionDisplayViewModel.questionsMetadata[questionDisplayViewModel.currentQuestion].correctAnswer}")
    }
    private fun checkAnswer(): Boolean {
        val selectedAnswer = questionDisplayView.getSelectedRadioButtonText()
        return selectedAnswer == questionDisplayViewModel.questionsMetadata[questionDisplayViewModel.currentQuestion].correctAnswer
    }
}