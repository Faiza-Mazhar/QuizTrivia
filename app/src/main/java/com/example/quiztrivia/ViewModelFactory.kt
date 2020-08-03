package com.example.quiztrivia

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.quiztrivia.dataservice.DataHandlerOkhttp
import com.example.quiztrivia.homepage.HomeViewModel
import com.example.quiztrivia.optionselection.OptionSelectionViewModel
import com.example.quiztrivia.questiondisplay.QuestionDisplayViewModel

class ViewModelFactory() : ViewModelProvider.Factory{

    companion object {
        private val dataHandler = DataHandlerOkhttp()
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when (modelClass) {
            OptionSelectionViewModel::class.java -> optionSelectionViewModel()
            QuestionDisplayViewModel::class.java -> questionDisplayViewModel()
            HomeViewModel::class.java -> homeViewModel()
            else -> throw IllegalArgumentException()
        } as T
    }

    private fun optionSelectionViewModel(): OptionSelectionViewModel = OptionSelectionViewModel()

    private fun questionDisplayViewModel(): QuestionDisplayViewModel = QuestionDisplayViewModel(
        dataHandler)

    private fun homeViewModel(): HomeViewModel = HomeViewModel()

}