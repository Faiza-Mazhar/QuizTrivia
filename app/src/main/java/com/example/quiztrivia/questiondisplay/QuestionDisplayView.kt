package com.example.quiztrivia.questiondisplay

import android.view.View
import android.widget.ProgressBar
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.example.quiztrivia.R
import com.example.quiztrivia.convertHTMLStringToString
import com.example.quiztrivia.optionselection.QuestionMetadata

class QuestionDisplayView(view: View) {

    private val categoryName: TextView= view.findViewById(R.id.question_display_category)
    private val difficultyLevel: TextView = view.findViewById(R.id.question_display_difficulty)
    private val numOfQuestion: TextView = view.findViewById(R.id.question_display_num_of_question)
    private val question: TextView = view.findViewById(R.id.question_display_question_text)
    val radioGroup: RadioGroup = view.findViewById(R.id.question_display_radio_group)
    val answer1: RadioButton = view.findViewById(R.id.question_display_answer_1)
    val answer2: RadioButton = view.findViewById(R.id.question_display_answer_2)
    val answer3: RadioButton = view.findViewById(R.id.question_display_answer_3)
    val answer4: RadioButton = view.findViewById(R.id.question_display_answer_4)
    private val loadingProgressBar: ProgressBar = view.findViewById(R.id.question_display_progressBar)

    fun bind(questionMetadata: QuestionMetadata) {
        categoryName.text = questionMetadata.category
        difficultyLevel.text = convertHTMLStringToString(questionMetadata.difficulty)
        question.text = questionMetadata.question
        answer1.text = questionMetadata.correctAnswer
        answer2.text = questionMetadata.wrongAnswers[0]
        answer3.text = questionMetadata.wrongAnswers[1]
        answer4.text = questionMetadata.wrongAnswers[2]
        loadingProgressBar.visibility = View.GONE
    }

    fun setNumOfQuestion(currentQuestionNumber: Int, totalQuestions: Int ) {
        val text = "$currentQuestionNumber / $totalQuestions"
        numOfQuestion.text = text
    }

}