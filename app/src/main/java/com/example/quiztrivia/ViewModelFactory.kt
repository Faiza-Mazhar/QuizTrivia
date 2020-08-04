package com.example.quiztrivia

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.quiztrivia.dataservice.DataManager
import com.example.quiztrivia.gamefinish.GameFinishViewModel
import com.example.quiztrivia.homepage.HomeViewModel
import com.example.quiztrivia.optionselection.OptionSelectionViewModel
import com.example.quiztrivia.questiondisplay.QuestionDisplayViewModel

class ViewModelFactory() : ViewModelProvider.Factory{

    companion object {
        private val dataManager = DataManager()
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when (modelClass) {
            OptionSelectionViewModel::class.java -> optionSelectionViewModel()
            QuestionDisplayViewModel::class.java -> questionDisplayViewModel()
            HomeViewModel::class.java -> homeViewModel()
            GameFinishViewModel::class.java -> gameFinishViewModel()
            else -> throw IllegalArgumentException()
        } as T
    }

    private fun gameFinishViewModel()= GameFinishViewModel()

    private fun optionSelectionViewModel(): OptionSelectionViewModel = OptionSelectionViewModel(dataManager)

    private fun questionDisplayViewModel(): QuestionDisplayViewModel = QuestionDisplayViewModel(dataManager)

    private fun homeViewModel(): HomeViewModel = HomeViewModel()

}