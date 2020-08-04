package com.example.quiztrivia.dataservice

import com.example.quiztrivia.convertFirstLetterToUpperCase
import com.example.quiztrivia.optionselection.CategoryDefinitionList
import com.example.quiztrivia.optionselection.CategoryMetadata
import com.example.quiztrivia.optionselection.QuestionMetadata
import com.example.quiztrivia.optionselection.QuestionsDefinitionList
import com.example.quiztrivia.replaceAnsi

class DataAdapter {

    fun convertCategoryDefinitionToCategoryMetadata(categoryDefinitionList: CategoryDefinitionList?) : List<CategoryMetadata> {
        val categoryMetadata = mutableListOf<CategoryMetadata>()
        for(category in categoryDefinitionList!!.trivia_categories) {
            categoryMetadata.add(CategoryMetadata(category.id, category.name))
        }
        return categoryMetadata
    }

    fun convertQuestionDefinitionToQuestionMetadata(questionsDefinitionList: QuestionsDefinitionList): List<QuestionMetadata> {
        val questionMetadata = mutableListOf<QuestionMetadata>()
        for(question in questionsDefinitionList.results) {
            questionMetadata.add(QuestionMetadata(
                question.category,
                question.difficulty.convertFirstLetterToUpperCase(),
                question.question.replaceAnsi(),
                question.correctAnswer,
                question.wrongAnswers
            ))
        }
        return questionMetadata
    }

    fun convertCategoryDefinitionListToArray(categoryMetadata: List<CategoryMetadata>): Array<String?> {
        val categories = arrayOfNulls<String>(categoryMetadata.size)
        for(index in categoryMetadata.indices){
            categories[index] = categoryMetadata[index].name
        }
        return categories
    }

}