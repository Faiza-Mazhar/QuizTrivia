package com.example.quiztrivia.optionselection

import android.widget.Spinner
import com.example.quiztrivia.dataservice.DataManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@ExperimentalCoroutinesApi
class OptionSelectionController (private val optionSelectionViewModel: OptionSelectionViewModel,
                                 private val optionSelectionView: OptionSelectionView) {

    private val dataManager = DataManager()

    init {
        getCategoryDefinitionList()

        optionSelectionView.populateNumOfQuestionSpinner()
        optionSelectionView.populateQuizDifficultyLevelSpinner()

        optionSelectionView.setPlayQuizClickListener {
            optionSelectionViewModel.setIndexes( getNumberOfQuestionsIndex(), getCategoryIndex(), getDifficultyLevelIndex())
        }
    }

    private fun getCategoryDefinitionList() {
        optionSelectionViewModel.coroutineScope.launch {
            withContext(Dispatchers.IO){
                optionSelectionViewModel.categoriesMetadata = dataManager.getCategoriesMetadata()
            }
            optionSelectionViewModel.categoryArray = dataManager.getCategoriesArray(optionSelectionViewModel.categoriesMetadata)
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