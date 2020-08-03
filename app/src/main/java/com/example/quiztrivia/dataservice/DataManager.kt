package com.example.quiztrivia.dataservice

import com.example.quiztrivia.optionselection.CategoryMetadata
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class DataManager() {
    private val dataHandler = DataHandlerOkhttp()

    suspend fun getCategoriesMetadata(): List<CategoryMetadata> {
        return dataHandler.getCategoryMetadata("https://opentdb.com/api_category.php")
    }

    fun getCategoriesArray(categoriesMetadata: List<CategoryMetadata>) : Array<String?> {
        return dataHandler.getCategoryArray(categoriesMetadata)
    }
}


