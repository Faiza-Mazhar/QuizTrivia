package com.example.quiztrivia.questiondisplay

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.quiztrivia.optionselection.SelectedItemIndexes
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class QuestionDisplayViewModelTest {
    private val viewModel = QuestionDisplayViewModel(SelectedItemIndexes())

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
     fun `on creating view model, it loads the data and set hasDataLoaded to true` () = runBlockingTest{
        Assert.assertTrue(viewModel.hasDataLoaded)
    }
}