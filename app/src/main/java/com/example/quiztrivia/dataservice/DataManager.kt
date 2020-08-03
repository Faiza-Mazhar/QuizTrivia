package com.example.quiztrivia.dataservice

import com.example.quiztrivia.optionselection.CategoryDefinitionList
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class DataManager() {
    private val dataHandler = DataHandlerOkhttp()
    private val dataAdapter = DataAdapter()

    suspend fun getCategoriesDefinition(): CategoryDefinitionList? {
        return dataHandler.getCategoryDefinition("https://opentdb.com/api_category.php")
    }

    fun getCategoriesNames(categoryDefinitionList: CategoryDefinitionList) {
        dataAdapter.convertCategoryDefinitionListToArray(categoryDefinitionList)
    }
}


