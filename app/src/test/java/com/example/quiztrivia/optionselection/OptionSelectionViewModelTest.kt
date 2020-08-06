package com.example.quiztrivia.optionselection

import com.example.quiztrivia.ViewModelFactory
import org.junit.Assert
import org.junit.Test

class OptionSelectionViewModelTest {

    @Test
    fun setIndexes() {
        val viewModel = ViewModelFactory().create(OptionSelectionViewModel::class.java)
        val expectedIndex  = 1
        viewModel.setIndexes(expectedIndex, expectedIndex, expectedIndex)
        val expectedSelectedItemIndexes = SelectedItemIndexes(expectedIndex, expectedIndex, expectedIndex)
        Assert.assertEquals(expectedSelectedItemIndexes, viewModel.selectedItemIndexes)
    }
}