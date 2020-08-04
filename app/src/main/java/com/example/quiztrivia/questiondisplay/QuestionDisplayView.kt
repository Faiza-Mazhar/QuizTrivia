package com.example.quiztrivia.questiondisplay

import android.view.View
import android.widget.*
import androidx.navigation.findNavController
import com.example.quiztrivia.R
import com.example.quiztrivia.convertHTMLStringToString
import com.example.quiztrivia.optionselection.QuestionMetadata

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

    val navController = view.findNavController()


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

    fun bind(questionMetadata: QuestionMetadata) = also {
        categoryName.text = questionMetadata.category
        difficultyLevel.text = convertHTMLStringToString(questionMetadata.difficulty)
        question.text = questionMetadata.question
        answer1.text = questionMetadata.answers[0]
        answer2.text = questionMetadata.answers[1]
        answer3.text = questionMetadata.answers[2]
        answer4.text = questionMetadata.answers[3]
    }

    fun hideProgressbar() = also {
        loadingProgressBar.visibility = View.GONE
    }

    fun setNumOfQuestion(currentQuestionNumber: Int, totalQuestions: Int ) {
        val text = "$currentQuestionNumber / $totalQuestions"
        numOfQuestion.text = text
    }

    fun getSelectedRadioButtonText(): String {
        val id = radioGroup.checkedRadioButtonId
        return view.findViewById<RadioButton>(id).text.toString()
    }

    fun setQuestionReply(string: String) {
        reply.text = string
        reply.visibility = View.VISIBLE
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


}