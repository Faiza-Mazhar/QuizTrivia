package com.example.quiztrivia.questiondisplay

import com.example.quiztrivia.optionselection.SelectedItemIndexes
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations


internal class QuestionDisplayControllerTest {
    @Mock private lateinit var mockViewModel: QuestionDisplayViewModel
    @Mock private lateinit var mockView: QuestionDisplayView

    private val selectedItemIndex = SelectedItemIndexes()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `hide UI on start` ()  = runBlocking {
     //  whenever(mockViewModel.coroutineScope).thenReturn(this)
        whenever(mockViewModel.dataManager).thenReturn(mock())
        whenever(mockViewModel.questionsMetadata).thenReturn(emptyList())

        QuestionDisplayController(mockViewModel, mockView, selectedItemIndex)
        verify(mockView, times(1)).hideQA()
        verify(mockView).hideCategoryDifficulty()
        verify(mockView).hideNumQuestion()
        verify(mockView).hideSubmitButton()
    }
}

