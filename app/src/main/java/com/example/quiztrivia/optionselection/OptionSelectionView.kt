package com.example.quiztrivia.optionselection

import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Spinner
import androidx.navigation.findNavController
import com.example.quiztrivia.R

class OptionSelectionView (private val view: View) {

    val categories: Spinner = view.findViewById(R.id.option_selection_categories)
    val numOfQuestion: Spinner = view.findViewById(R.id.option_selection_num_of_questions)
    val quizDifficultyLevel: Spinner = view.findViewById(R.id.option_selection_quiz_difficulty)
    private val startQuiz: Button = view.findViewById(R.id.option_selection_start_quiz)
    private val progressBar: ProgressBar = view.findViewById(R.id.option_selection_progressBar)

    val navController = view.findNavController()

    fun setPlayQuizClickListener(listener: () -> Unit) {
        startQuiz.setOnClickListener {
            listener.invoke()
        }
    }

    fun populateCategoriesSpinner(categoriesArray: Array<String?>) {
        val arrayAdapter = ArrayAdapter<String>(view.context, android.R.layout.simple_spinner_dropdown_item, categoriesArray)
        categories.adapter = arrayAdapter
        progressBar.visibility = View.GONE

    }

    fun populateNumOfQuestionSpinner() {
        ArrayAdapter.createFromResource(
            view.context,
            R.array.num_of_questions,
            android.R.layout.simple_spinner_dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            numOfQuestion.adapter = adapter
        }
    }

    fun populateQuizDifficultyLevelSpinner() {
        ArrayAdapter.createFromResource(
            view.context,
            R.array.quiz_difficulty_levels,
            android.R.layout.simple_spinner_dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            quizDifficultyLevel.adapter = adapter
        }
    }
}