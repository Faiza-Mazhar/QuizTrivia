package com.example.quiztrivia.dataservice.json

import com.example.quiztrivia.optionselection.CategoryDefinitionList
import org.junit.Assert
import org.junit.Test


internal class MoshiServiceTest {
    private val moshiService = MoshiService()

    @Test
    fun `fromJson can parse a valid json string to it respective data class`() {
        val categoryDefinitionList = moshiService.fromJson(jsonString, CategoryDefinitionList::class)
        Assert.assertEquals(2, categoryDefinitionList.trivia_categories.size)
    }

    private val jsonString =
        """{trivia_categories: [{id: 9,name: "General Knowledge"},{id: 10,name: "Entertainment: Books"}]}""".trimIndent()

}