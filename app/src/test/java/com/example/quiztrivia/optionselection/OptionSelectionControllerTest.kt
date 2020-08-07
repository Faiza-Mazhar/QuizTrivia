package com.example.quiztrivia.optionselection

import android.widget.Spinner
import com.nhaarman.mockito_kotlin.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
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

    @ExperimentalCoroutinesApi
    @Test
    fun `when user click on play quiz button, selected category, selected number of question and selected difficulty level are updated` () = runBlockingTest{

        whenever(mockViewModel.coroutineScope).thenReturn(this)
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

        OptionSelectionController(mockViewModel, mockOptionSelectionView)
        verify(mockOptionSelectionView).setPlayQuizClickListener(playQuizClickCaptor.capture())
        playQuizClickCaptor.firstValue.invoke()

        verify(mockViewModel).setIndexes(expectedIndex, expectedIndex, expectedIndex)
        verify(mockOptionSelectionView, times(1)).navigateToQuestionDisplayFragment(mockViewModel.selectedItemIndexes)
    }

}