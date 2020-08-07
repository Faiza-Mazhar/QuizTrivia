package com.example.quiztrivia

import org.junit.Assert
import org.junit.Test

class StringUtilsKtTest {

    @Test
    fun convertFirstLetterToUpperCase() {
        Assert.assertEquals("Medium", "medium".convertFirstLetterToUpperCase())
    }

    @Test
    fun replaceAnsi() {
        val string = "&quot; &amp; &#039;"
        Assert.assertEquals("\" & \'", replaceHtmlEntities(string))
    }
}