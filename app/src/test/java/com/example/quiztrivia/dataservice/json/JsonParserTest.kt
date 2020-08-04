package com.example.quiztrivia.dataservice.json

import org.junit.Assert
import org.junit.Test


internal class JsonParserTest {
    private val jsonParser = JsonParser()

    @Test
    fun `can parse valid json to categoryDefinitionList `() {
        Assert.assertEquals(2, jsonParser.getCategoryDefinitionList(categoryJsonString)?.trivia_categories?.size)
    }

    @Test
    fun `can parse valid json to questionDefinitionList `() {
        Assert.assertEquals(2, jsonParser.questionsDefinitionList(questionsJsonString)?.results?.size)
    }

    private val categoryJsonString =
        """{trivia_categories: [{id: 9,name: "General Knowledge"},{id: 10,name: "Entertainment: Books"}]}""".trimIndent()

    private val questionsJsonString ="{\n" +
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