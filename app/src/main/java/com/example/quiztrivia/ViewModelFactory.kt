package com.example.quiztrivia

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.quiztrivia.json.JsonParser
import com.example.quiztrivia.network.OkhttpService
import com.example.quiztrivia.optionselection.OptionSelectionViewModel

class ViewModelFactory() : ViewModelProvider.Factory{

    companion object {
        private val networkService = OkhttpService()
        private val jsonParser = JsonParser()
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when (modelClass) {
            OptionSelectionViewModel::class.java -> optionSelectionViewModel()
            else -> throw IllegalArgumentException()
        } as T
    }

    private fun optionSelectionViewModel(): OptionSelectionViewModel = OptionSelectionViewModel()

}