package com.example.quiztrivia.optionselection

import org.junit.Assert
import org.junit.Test

internal class IndexUtilsTest {

    @Test
    fun `if index is between 1-8, then it returns the corresponding number of question`() {
        val expectedNumber = "7"
        Assert.assertEquals(expectedNumber, getNumQuestionFromIndex(3))
    }

    @Test
    fun `if index 0 then it return an empty string`() {
        val expectedString = ""
        Assert.assertEquals(expectedString, getDifficultyLevelFromIndex(0))
    }

    @Test
    fun `if index 1 then difficulty level is easy`() {
        val expectedString = "easy"
        Assert.assertEquals(expectedString, getDifficultyLevelFromIndex(1))
    }
    @Test
    fun `if index 2 then difficulty level is medium`() {
        val expectedString = "medium"
        Assert.assertEquals(expectedString, getDifficultyLevelFromIndex(2))
    }

    @Test
    fun `if index 3 then difficulty level is hard`() {
        val expectedString = "hard"
        Assert.assertEquals(expectedString, getDifficultyLevelFromIndex(3))
    }

    @Test
    fun `category number is 6 more than the index`() {
        val expectedString = "15"
        Assert.assertEquals(expectedString, getCategoryNumberFromIndex(7))
    }

    @Test
    fun `if selectedItemIndex is (2, 3, 2), then it generated the url with all the fields`() {
        val selectedItemIndexes = SelectedItemIndexes(1, 1, 2)
        val expectedUrlString = "amount=5&category=9&difficulty=medium&type=multiple"
        Assert.assertEquals(expectedUrlString, getURLString(selectedItemIndexes))
    }

    @Test
    fun`if selectedItemIndex is (1, 0, 0), then generated URL will not have category and difficulty level` () {
        val selectedItemIndexes = SelectedItemIndexes(1, 0, 0)
        val expectedUrlString = "amount=5&type=multiple"
        Assert.assertEquals(expectedUrlString, getURLString(selectedItemIndexes))
    }

    @Test
    fun`if selectedItemIndex is (1, 0, 1), then generated URL will not have category` () {
        val selectedItemIndexes = SelectedItemIndexes(1, 0, 1)
        val expectedUrlString = "amount=5&difficulty=easy&type=multiple"
        Assert.assertEquals(expectedUrlString, getURLString(selectedItemIndexes))
    }

    @Test
    fun`if selectedItemIndex is (1, 1, 0), then generated URL will not have difficulty level` () {
        val selectedItemIndexes = SelectedItemIndexes(1, 1, 1)
        val expectedUrlString = "amount=5&category=9&type=multiple"
        Assert.assertEquals(expectedUrlString, getURLString(selectedItemIndexes))
    }
}