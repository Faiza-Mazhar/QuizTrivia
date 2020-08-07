package com.example.quiztrivia.optionselection

import android.widget.Spinner

class OptionSelectionController (private val optionSelectionViewModel: OptionSelectionViewModel,
                                 private val optionSelectionView: OptionSelectionView,
                                 private val categoryMetadataString: String) {

    init{
        setupView()
        optionSelectionView.populateNumOfQuestionSpinner()
        optionSelectionView.populateQuizDifficultyLevelSpinner()

        optionSelectionView.setPlayQuizClickListener {
            optionSelectionViewModel.setIndexes( getNumberOfQuestionsIndex(), getCategoryIndex(), getDifficultyLevelIndex())
            navigateToQuestionsDisplayFragment()
        }
    }

    private fun navigateToQuestionsDisplayFragment() {
        optionSelectionView.navigateToQuestionDisplayFragment(optionSelectionViewModel.selectedItemIndexes)
    }

    private fun setupView() {
        optionSelectionViewModel.categoriesMetadata = optionSelectionViewModel.dataManager.getCategoriesMetadata(categoryMetadataString)
        optionSelectionViewModel.categoryArray = optionSelectionViewModel.dataManager.getCategoriesArray(optionSelectionViewModel.categoriesMetadata)
        optionSelectionView.populateCategoriesSpinner(optionSelectionViewModel.categoryArray!!)

    }

    private fun getSelectedItemIndex(spinner: Spinner) : Int {
        return spinner.selectedItemPosition
    }

    private fun getCategoryIndex(): Int = getSelectedItemIndex(optionSelectionView.categories)
    private fun getNumberOfQuestionsIndex(): Int = getSelectedItemIndex(optionSelectionView.numOfQuestion)
    private fun getDifficultyLevelIndex(): Int = getSelectedItemIndex(optionSelectionView.quizDifficultyLevel)

}