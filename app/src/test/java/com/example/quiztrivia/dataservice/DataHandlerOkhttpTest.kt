package com.example.quiztrivia.dataservice

import com.example.quiztrivia.dataservice.json.JsonParser
import com.example.quiztrivia.dataservice.network.OkhttpService
import com.example.quiztrivia.optionselection.CategoryDefinition
import com.example.quiztrivia.optionselection.CategoryDefinitionList
import com.example.quiztrivia.optionselection.QuestionDefinition
import com.example.quiztrivia.optionselection.QuestionsDefinitionList
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

internal class DataHandlerOkhttpTest {

    private lateinit var okhttpService: OkhttpService
    private val jsonParser = JsonParser()

    @Before
    fun setUp() {
        okhttpService = OkhttpService()
    }

    @After
    fun tearDown() {

    }

    @Test
    fun getQuestionDefinitionList() {
        val expectedJsonResponse = CategoryDefinitionList(
            listOf(
                CategoryDefinition(9, "General Knowledge"),
                CategoryDefinition(10, "Entertainment: Books")
            )
        )
        Assert.assertEquals(
            expectedJsonResponse,
            jsonParser.getCategoryDefinitionList(categoryNetworkResponse)
        )
    }

    @Test
    fun getCategoryDefinition() {
        val expectedJsonResponse = QuestionsDefinitionList(
            listOf(
                QuestionDefinition(
                    "cat",
                    "type",
                    "diff",
                    "question?",
                    "a1",
                    listOf("a2", "a3", "a4")
                ),
                QuestionDefinition(
                    "cat",
                    "type",
                    "diff",
                    "question?",
                    "a1",
                    listOf("a2", "a3", "a4")
                )
            )
        )
        Assert.assertEquals(
            expectedJsonResponse,
            jsonParser.questionsDefinitionList(questionsNetworkResponse)
        )
    }

    private val categoryNetworkResponse =
        """{trivia_categories: [{id: 9,name: "General Knowledge"},{id: 10,name: "Entertainment: Books"}]}""".trimIndent()

    private val questionsNetworkResponse ="{\n" +
            "response_code: 0,\n" +
            "results: [\n" +
            "{\n" +
            "category: \"cat\",\n" +
            "type: \"type\",\n" +
            "difficulty: \"diff\",\n" +
            "question: \"question?\",\n" +
            "correct_answer: \"a1\",\n" +
            "incorrect_answers: [\n" +
            "\"a2\",\n" +
            "\"a3\",\n" +
            "\"a4\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "category: \"cat\",\n" +
            "type: \"type\",\n" +
            "difficulty: \"diff\",\n" +
            "question: \"question?\",\n" +
            "correct_answer: \"a1\",\n" +
            "incorrect_answers: [\n" +
            "\"a2\",\n" +
            "\"a3\",\n" +
            "\"a4\"\n" +
            "]\n" +
            "}\n" +
            "]\n" +
            "}".trimIndent()
}