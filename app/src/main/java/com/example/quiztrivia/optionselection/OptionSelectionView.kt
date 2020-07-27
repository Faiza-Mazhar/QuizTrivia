package com.example.quiztrivia.optionselection

import android.content.Context
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import com.example.quiztrivia.R

class OptionSelectionView (view: View, private val context: Context) {
    val categories: Spinner = view.findViewById(R.id.option_selection_categories)
    val numOfQuestion: Spinner = view.findViewById(R.id.option_selection_num_of_questions)
    val quizDifficultyLevel: Spinner = view.findViewById(R.id.option_selection_quiz_difficulty)
    private val startQuiz: Button = view.findViewById(R.id.option_selection_start_quiz)

    fun setPlayQuizClickListener(listener: () -> Unit) {
        startQuiz.setOnClickListener { listener() }
    }

    fun populateCategoriesSpinner() {
        ArrayAdapter.createFromResource(
            context,
            R.array.categories,
            android.R.layout.simple_spinner_dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            categories.adapter = adapter
        }
    }

    fun populateNumOfQuestionSpinner() {
        ArrayAdapter.createFromResource(
            context,
            R.array.num_of_questions,
            android.R.layout.simple_spinner_dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            numOfQuestion.adapter = adapter
        }
    }

    fun populateQuizDifficultyLevelSpinner() {
        ArrayAdapter.createFromResource(
            context,
            R.array.quiz_difficulty_levels,
            android.R.layout.simple_spinner_dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            quizDifficultyLevel.adapter = adapter
        }
    }
}