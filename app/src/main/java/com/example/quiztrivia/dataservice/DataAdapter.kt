package com.example.quiztrivia.dataservice

import com.example.quiztrivia.optionselection.CategoryDefinitionList

class DataAdapter {

    fun convertCategoryDefinitionListToArray(categoryDefinitionList: CategoryDefinitionList): Array<String?> {
        val categories = arrayOfNulls<String>(categoryDefinitionList.trivia_categories.size)
        for(index in categoryDefinitionList.trivia_categories.indices){
            categories[index] = categoryDefinitionList.trivia_categories[index].name
        }
        return categories
    }

}