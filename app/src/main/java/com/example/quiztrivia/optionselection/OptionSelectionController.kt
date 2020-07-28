package com.example.quiztrivia.optionselection

import android.widget.Spinner

class OptionSelectionController (private val optionSelectionViewModel: OptionSelectionViewModel,
                                 private val optionSelectionView: OptionSelectionView) {

    init {
        optionSelectionView.populateCategoriesSpinner()
        optionSelectionView.populateNumOfQuestionSpinner()
        optionSelectionView.populateQuizDifficultyLevelSpinner()

        optionSelectionView.setPlayQuizClickListener {
            optionSelectionViewModel.setIndexes( getNumberOfQuestionsIndex(), getCategoryIndex(), getDifficultyLevelIndex())
        }
    }

    private fun getSelectedItemIndex(spinner: Spinner) : Int {
        return spinner.selectedItemPosition
    }

    private fun getCategoryIndex(): Int = getSelectedItemIndex(optionSelectionView.categories)
    private fun getNumberOfQuestionsIndex(): Int = getSelectedItemIndex(optionSelectionView.numOfQuestion)
    private fun getDifficultyLevelIndex(): Int = getSelectedItemIndex(optionSelectionView.quizDifficultyLevel)

}