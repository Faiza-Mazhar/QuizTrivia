package com.example.quiztrivia.dataservice

import com.example.quiztrivia.optionselection.*
import com.example.quiztrivia.replaceHtmlEntities

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
            val answers = shuffleAnswers(question)
            questionMetadata.add(QuestionMetadata(
                question.category,
                question.difficulty,
                replaceHtmlEntities(question.question),
                replaceHtmlEntities(question.correctAnswer),
                replaceHTMLEntitiesForAnswers(answers)
            ))
        }
        return questionMetadata
    }

    private fun shuffleAnswers(questionsDefinition: QuestionDefinition): List<String> {
        return listOf(questionsDefinition.correctAnswer).plus(questionsDefinition.wrongAnswers).shuffled()
    }

    private fun replaceHTMLEntitiesForAnswers(answers: List<String>): List<String>{
        answers.forEach { answer ->
            replaceHtmlEntities(answer)
        }
        return answers
    }

    fun convertCategoryDefinitionListToArray(categoryMetadata: List<CategoryMetadata>): Array<String?> {
        val categories = arrayOfNulls<String>(categoryMetadata.size)
        for(index in categoryMetadata.indices){
            categories[index] = categoryMetadata[index].name
        }
        return categories
    }

}