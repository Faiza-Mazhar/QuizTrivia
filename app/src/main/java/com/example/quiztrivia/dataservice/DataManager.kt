package com.example.quiztrivia.dataservice

import com.example.quiztrivia.optionselection.QuestionMetadata
import com.example.quiztrivia.optionselection.SelectedItemIndexes

class DataManager(private val selectedItemIndexes: SelectedItemIndexes) {

    private val dataHandler = DataHandlerOkhttp()

    init {
        val questionDefinitionList = dataHandler.getQuestionDefinition(convertIndexesToURLString())
    }

    private fun convertIndexesToURLString(): String {
        return getURLString(selectedItemIndexes)
    }

    fun getQuestionMetadataList(): List<QuestionMetadata>?{
        return null
    }
}