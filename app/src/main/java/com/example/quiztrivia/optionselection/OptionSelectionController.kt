package com.example.quiztrivia.optionselection

import android.widget.Spinner
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@ExperimentalCoroutinesApi
class OptionSelectionController (private val optionSelectionViewModel: OptionSelectionViewModel,
                                 private val optionSelectionView: OptionSelectionView) {

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
        optionSelectionView.naviagteToQuestionDisplayFragment(optionSelectionViewModel.selectedItemIndexes)
    }

    private fun setupView() {
        optionSelectionViewModel.coroutineScope.launch {
            withContext(Dispatchers.IO){
                optionSelectionViewModel.categoriesMetadata = optionSelectionViewModel.dataManager.getCategoriesMetadata()
            }
            optionSelectionViewModel.categoryArray = optionSelectionViewModel.dataManager.getCategoriesArray(optionSelectionViewModel.categoriesMetadata)
            optionSelectionView.populateCategoriesSpinner(optionSelectionViewModel.categoryArray!!)
        }
    }

    private fun getSelectedItemIndex(spinner: Spinner) : Int {
        return spinner.selectedItemPosition
    }

    private fun getCategoryIndex(): Int = getSelectedItemIndex(optionSelectionView.categories)
    private fun getNumberOfQuestionsIndex(): Int = getSelectedItemIndex(optionSelectionView.numOfQuestion)
    private fun getDifficultyLevelIndex(): Int = getSelectedItemIndex(optionSelectionView.quizDifficultyLevel)

}