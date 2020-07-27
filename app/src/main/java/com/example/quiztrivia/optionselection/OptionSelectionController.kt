package com.example.quiztrivia.optionselection

import android.widget.Spinner

class OptionSelectionController (private val optionSelectionViewModel: OptionSelectionViewModel,
                                 private val optionSelectionView: OptionSelectionView) {

//    val categories = optionSelectionViewModel.resources.getStringArray(R.array.categories)
//    val difficultyLevels = optionSelectionViewModel.resources.getStringArray(R.array.quiz_difficulty_levels)
//    val numQuestions = optionSelectionViewModel.resources.getStringArray(R.array.num_of_questions)

    init {
        optionSelectionView.populateCategoriesSpinner()
        optionSelectionView.populateNumOfQuestionSpinner()
        optionSelectionView.populateQuizDifficultyLevelSpinner()

        optionSelectionView.setPlayQuizClickListener {
            optionSelectionViewModel.setIndexes(getCategoryIndex(), getNumberOfQuestionsIndex(), getDifficultyLevelIndex())
        }
    }

    private fun getSelectedItemIndex(spinner: Spinner) : Int {
        return spinner.selectedItemPosition
    }


    private fun getCategoryIndex(): Int = getSelectedItemIndex(optionSelectionView.categories)
    private fun getNumberOfQuestionsIndex(): Int = getSelectedItemIndex(optionSelectionView.numOfQuestion)
    private fun getDifficultyLevelIndex(): Int = getSelectedItemIndex(optionSelectionView.quizDifficultyLevel)

}