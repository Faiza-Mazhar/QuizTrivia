package com.example.quiztrivia.optionselection

import android.widget.Spinner
import com.nhaarman.mockito_kotlin.*
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

        whenever(mockViewModel.dataManager).thenReturn(mock())

        whenever(mockViewModel.categoryArray).thenReturn(arrayOf("category"))
        whenever(mockViewModel.selectedItemIndexes).thenReturn(mock())

        val playQuizClickCaptor = argumentCaptor< () -> Unit>()
        val mockSpinner = mock<Spinner>()

        val expectedIndex = 1
        whenever(mockSpinner.selectedItemPosition).thenReturn(expectedIndex)
        whenever(mockOptionSelectionView.categories).thenReturn(mockSpinner)
        whenever(mockOptionSelectionView.numOfQuestion).thenReturn(mockSpinner)
        whenever(mockOptionSelectionView.quizDifficultyLevel).thenReturn(mockSpinner)

        OptionSelectionController(mockViewModel, mockOptionSelectionView, "category")
        verify(mockOptionSelectionView).setPlayQuizClickListener(playQuizClickCaptor.capture())
        playQuizClickCaptor.firstValue.invoke()

        verify(mockViewModel).setIndexes(expectedIndex, expectedIndex, expectedIndex)
        verify(mockOptionSelectionView, times(1)).navigateToQuestionDisplayFragment(mockViewModel.selectedItemIndexes)
    }

}