package com.example.quiztrivia.questiondisplay

import com.example.quiztrivia.optionselection.QuestionMetadata
import com.nhaarman.mockito_kotlin.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
internal class QuestionDisplayControllerTest {
    @Mock private lateinit var mockViewModel: QuestionDisplayViewModel
    @Mock private lateinit var mockView: QuestionDisplayView

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @After
    fun tearDown() {
        reset(mockView)
    }

    @Test
    fun `Hide UI on start before loading network response` () {
        whenever(mockViewModel.hasDataLoaded).thenReturn(false)
        QuestionDisplayController(mockViewModel, mockView)

        verify(mockView).hideQA()
        verify(mockView).hideSubmitButton()
        verify(mockView).hideNumQuestion()
        verify(mockView).hideCategoryDifficulty()
    }

    @Test
    fun `Display UI when valid questionsMetadata is loaded` () {
        whenever(mockViewModel.hasDataLoaded).thenReturn(true)
        whenever(mockViewModel.questionsMetadata).thenReturn(mock())
        QuestionDisplayController(mockViewModel, mockView)

        val clickCaptor = argumentCaptor<() -> Unit>()
        verify(mockViewModel).onQuestionMetadataLoaded = clickCaptor.capture()
        clickCaptor.firstValue.invoke()

        verify(mockView).showQA()
        verify(mockView).showSubmitButton()
        verify(mockView).showNumQuestion()
        verify(mockView).showCategoryDifficulty()
        verify(mockView).hideProgressbar()
        verify(mockView).bind(mockViewModel.questionsMetadata[mockViewModel.currentQuestion])

    }

    @Test
    fun `Show retry button if response is not valid or empty` () {
        whenever(mockViewModel.hasDataLoaded).thenReturn(true)
        whenever(mockViewModel.questionsMetadata).thenReturn(emptyList())
        QuestionDisplayController(mockViewModel, mockView)

        val clickCaptor = argumentCaptor<() -> Unit>()
        verify(mockViewModel).onQuestionMetadataLoaded = clickCaptor.capture()
        clickCaptor.firstValue.invoke()

        verify(mockView).showTryAgainButton()
        verify(mockView).hideProgressbar()
    }

    @Test
    fun `when user click Submit button,and answer is correct and it display respective reply` ()  {
        whenever(mockViewModel.questionsMetadata).thenReturn(getQuestionMetadata())
        QuestionDisplayController(mockViewModel, mockView)

        whenever(mockView.getSelectedRadioButtonText()).thenReturn("android")

        val clickCaptor = argumentCaptor<() -> Unit>()
        verify(mockView).setSubmitButtonClickListener(clickCaptor.capture())
        clickCaptor.firstValue.invoke()

        verify(mockView).setQuestionReply("Yeah, You answer is correct")
    }

    @Test
    fun `when user click Submit button, if answer is wrong and display reply` () {
        whenever(mockViewModel.questionsMetadata).thenReturn(getQuestionMetadata())
        QuestionDisplayController(mockViewModel, mockView)

        whenever(mockView.getSelectedRadioButtonText()).thenReturn("kindle")

        val clickCaptor = argumentCaptor<() -> Unit>()
        verify(mockView).setSubmitButtonClickListener(clickCaptor.capture())
        clickCaptor.firstValue.invoke()

        verify(mockView).setQuestionReply("Sorry, right answer is: ${mockViewModel.questionsMetadata[mockViewModel.currentQuestion].correctAnswer}")
    }

    @Test
    fun `clicking on submit button hides it and shows Next button` ()  {
        whenever(mockViewModel.questionsMetadata).thenReturn(getQuestionMetadata())
        QuestionDisplayController(mockViewModel, mockView)

        whenever(mockView.getSelectedRadioButtonText()).thenReturn("anyString")

        val clickCaptor = argumentCaptor<() -> Unit>()
        verify(mockView).setSubmitButtonClickListener(clickCaptor.capture())
        clickCaptor.firstValue.invoke()

        verify(mockView, times(2)).hideSubmitButton()
        verify(mockView).showNextButton()
    }

    @Test
    fun `click in next button hides itself and question reply and display next question`() {
        whenever(mockViewModel.questionsMetadata).thenReturn(getQuestionMetadata())
        QuestionDisplayController(mockViewModel, mockView)

        val clickCaptor = argumentCaptor<() -> Unit>()
        verify(mockView).setNextButtonClickListener(clickCaptor.capture())
        clickCaptor.firstValue.invoke()

        verify(mockView, atLeastOnce()).hideQuestionReply()
        verify(mockView).hideNextButton()
        verify(mockView, times(1)).showSubmitButton()
        verify(mockView, times(1)).bind(mockViewModel.questionsMetadata[mockViewModel.currentQuestion])
    }

    @Test
    fun `when current question is last question on the list, then clicking on next button takes to final score fragment`() {
        whenever(mockViewModel.questionsMetadata).thenReturn(listOf(QuestionMetadata(
            "category",
            "medium",
            "Whats is this?",
            "android",
            listOf("android", "ios", "kindle", "iPad")
        )))
        QuestionDisplayController(mockViewModel, mockView)

        val nextClickCaptor = argumentCaptor<() -> Unit>()
        verify(mockView).setNextButtonClickListener(nextClickCaptor.capture())
        nextClickCaptor.firstValue.invoke()


        val mockFinalScore = FinalScore(mockViewModel.correctQuestion, mockViewModel.questionsMetadata.size)
        verify(mockView).navigateToGameFinish(mockFinalScore)
    }

    private fun getQuestionMetadata(): List<QuestionMetadata> {
        return listOf(QuestionMetadata(
            "category",
            "medium",
        "Whats is this?",
        "android",
            listOf("android", "ios", "kindle", "iPad")
        ),
            QuestionMetadata(
                "category",
                "medium",
                "Whats is this?",
                "Book1",
                listOf("Book1", "Book2", "3", "iP4")
            ))
    }
}