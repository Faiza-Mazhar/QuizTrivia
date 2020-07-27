package com.example.quiztrivia.optionselection

import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations


class OptionSelectionControllerTest {

    @Mock private lateinit var mockViewModel: OptionSelectionViewModel
    @Mock private lateinit var mockOptionSelectionView: OptionSelectionView

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `when user click on play quiz button, selected category, selected number of question and selected difficulty level are updated` () {
        val playQuizClickCaptor = argumentCaptor< () -> Unit>()
        OptionSelectionController(mockViewModel, mockOptionSelectionView)

        verify(mockOptionSelectionView).setPlayQuizClickListener(playQuizClickCaptor.capture())
        playQuizClickCaptor.firstValue.invoke()

        verify(mockViewModel.setIndexes(2,3,4))
    }


    fun tearDown() {
    }
}