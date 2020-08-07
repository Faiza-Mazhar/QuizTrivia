package com.example.quiztrivia.dataservice

import com.example.quiztrivia.optionselection.*
import com.example.quiztrivia.replaceHtmlEntities
import org.junit.Assert
import org.junit.Test

class DataAdapterTest {

    private val dataAdapter = DataAdapter()
    @Test
    fun `convertCategoryDefinitionListToArray converts category definition to category array`() {
        val categoryDefinitionList = getCategoryDefinitionList()

        val expectedCategoryMetadata = getCategoryMetadata()
        Assert.assertEquals(expectedCategoryMetadata, dataAdapter.convertCategoryDefinitionToCategoryMetadata(categoryDefinitionList))
    }

    @Test
    fun convertCategoryDefinitionListToArray() {
        val categoryMetadata = getCategoryMetadata()
        val expectedCategoriesArray = arrayOf("category", "category")
        Assert.assertEquals(expectedCategoriesArray,  dataAdapter.convertCategoryDefinitionListToArray(categoryMetadata))

    }

    @Test
    fun convertQuestionDefinitionToQuestionMetadata() {
        val questionsDefinitionList = getQuestionDefinitionList()
        val expectedQuestionMetadata: MutableList<QuestionMetadata> = getQuestionMetadata(questionsDefinitionList)
        Assert.assertEquals(expectedQuestionMetadata, dataAdapter.convertQuestionDefinitionToQuestionMetadata(questionsDefinitionList))
    }

    private fun getCategoryMetadata(): List<CategoryMetadata> {
        return listOf(
            CategoryMetadata(9, "category"),
            CategoryMetadata(10, "category")
        )
    }

    private fun getQuestionMetadata(questionsDefinitionList: QuestionsDefinitionList) : MutableList<QuestionMetadata> {
        val questionMetadata = mutableListOf<QuestionMetadata>()
        for(question in questionsDefinitionList.results) {
            questionMetadata.add(QuestionMetadata(
                question.category,
                question.difficulty,
                replaceHtmlEntities(question.question),
                replaceHtmlEntities(question.correctAnswer),
                listOf("a1", "a1", "a1", "a1")
            ))
        }
        return questionMetadata
    }

    private fun getQuestionDefinitionList(): QuestionsDefinitionList {
        return QuestionsDefinitionList(
            listOf(
                QuestionDefinition(
                    "cat",
                    "type",
                    "diff",
                    "question?",
                    "a1",
                    listOf("a1", "a1", "a1")
                ),
                QuestionDefinition(
                    "cat",
                    "type",
                    "diff",
                    "question?",
                    "a1",
                    listOf("a1", "a1", "a1")
                )
            )
        )
    }

    private fun getCategoryDefinitionList(): CategoryDefinitionList {
        return CategoryDefinitionList(
            listOf(
                CategoryDefinition(9, "category"),
                CategoryDefinition(10, "category")
            )
        )
    }

}