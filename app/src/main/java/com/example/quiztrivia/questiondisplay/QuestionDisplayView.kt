package com.example.quiztrivia.questiondisplay

import android.view.View
import android.widget.*
import androidx.navigation.findNavController
import com.example.quiztrivia.R
import com.example.quiztrivia.convertFirstLetterToUpperCase
import com.example.quiztrivia.optionselection.QuestionMetadata
import com.example.quiztrivia.optionselection.SelectedItemIndexes

class QuestionDisplayView(private val view: View) {

    private val categoryName: TextView= view.findViewById(R.id.question_display_category)
    private val difficultyLevel: TextView = view.findViewById(R.id.question_display_difficulty)
    private val numOfQuestion: TextView = view.findViewById(R.id.question_display_num_of_question)
    private val question: TextView = view.findViewById(R.id.question_display_question_text)
    private val radioGroup: RadioGroup = view.findViewById(R.id.question_display_radio_group)
    private val answer1: RadioButton = view.findViewById(R.id.question_display_answer_1)
    private val answer2: RadioButton = view.findViewById(R.id.question_display_answer_2)
    private val answer3: RadioButton = view.findViewById(R.id.question_display_answer_3)
    private val answer4: RadioButton = view.findViewById(R.id.question_display_answer_4)
    private val submitButton: Button = view.findViewById(R.id.question_display_submit)
    private val nextButton: Button = view.findViewById(R.id.question_display_next)
    private val loadingProgressBar: ProgressBar = view.findViewById(R.id.question_display_progressBar)
    private val reply: TextView = view.findViewById(R.id.question_display_answer_reply)
    private val tryAgain: Button = view.findViewById(R.id.question_display_retry)
    private val navController = view.findNavController()


    fun setSubmitButtonClickListener (listener: () -> Unit) {
        submitButton.setOnClickListener {
            listener.invoke()
        }
    }

    fun setNextButtonClickListener (listener: () -> Unit) {
        nextButton.setOnClickListener {
            listener.invoke()
        }
    }

    fun setTryAgainButtonClickListener (listener: () -> Unit) {
        tryAgain.setOnClickListener {
            listener.invoke()
        }
    }

    fun navigateToItSelf(selectedItemIndexes: SelectedItemIndexes) {
        navController.navigate(QuestionDisplayFragmentDirections.actionQuizQuestionsSelf(selectedItemIndexes))
    }

    fun navigateToGameFinish(finalScore: FinalScore) {
        navController.navigate(
            QuestionDisplayFragmentDirections.actionQuizQuestionsToGameFinishFragment(finalScore)
        )
    }

    fun bind(questionMetadata: QuestionMetadata) = also {
        categoryName.text = questionMetadata.category
        difficultyLevel.text = questionMetadata.difficulty.convertFirstLetterToUpperCase()
        question.text = questionMetadata.question
        answer1.text = questionMetadata.answers[0]
        answer2.text = questionMetadata.answers[1]
        answer3.text = questionMetadata.answers[2]
        answer4.text = questionMetadata.answers[3]
    }

    fun setNumOfQuestion(currentQuestionNumber: Int, totalQuestions: Int ) {
        val text = "Question: $currentQuestionNumber / $totalQuestions"
        numOfQuestion.text = text
    }

    fun getSelectedRadioButtonText(): String {
        val id = radioGroup.checkedRadioButtonId
        return view.findViewById<RadioButton>(id).text.toString()
    }

    fun setQuestionReply(string: String) = also {
        reply.text = string
        reply.visibility = View.VISIBLE
    }

    fun hideProgressbar() = also {
        loadingProgressBar.visibility = View.GONE
    }

    fun hideQuestionReply() = also {
        reply.visibility = View.GONE
    }

    fun hideQA() = also {
        question.visibility = View.GONE
        radioGroup.visibility = View.GONE
    }

    fun showQA() = also {
        question.visibility = View.VISIBLE
        radioGroup.visibility = View.VISIBLE
    }

    fun hideSubmitButton() = also {
        submitButton.visibility = View.GONE
    }

    fun showSubmitButton() = also {
        submitButton.visibility = View.VISIBLE
    }

    fun hideNextButton() = also {
        nextButton.visibility = View.GONE
    }

    fun showNextButton() = also {
        nextButton.visibility = View.VISIBLE
    }

    fun showTryAgainButton() = also {
        tryAgain.visibility = View.VISIBLE
    }

    fun hideNumQuestion() = also {
        numOfQuestion.visibility = View.GONE
    }

    fun showNumQuestion() = also {
        numOfQuestion.visibility = View.VISIBLE
    }

    fun hideCategoryDifficulty() = also {
        categoryName.visibility = View.GONE
        difficultyLevel.visibility = View.GONE
    }

    fun showCategoryDifficulty() = also {
        categoryName.visibility = View.VISIBLE
        difficultyLevel.visibility = View.VISIBLE
    }


}