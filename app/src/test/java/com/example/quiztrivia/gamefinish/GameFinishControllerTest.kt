package com.example.quiztrivia.gamefinish

import com.example.quiztrivia.questiondisplay.FinalScore
import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class GameFinishControllerTest {

    @Mock private lateinit var mockViewModel: GameFinishViewModel
    @Mock private lateinit var mockView: GameFinishView

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        val finalScore = FinalScore(2, 3)
        whenever(mockViewModel.finalScore).thenReturn(finalScore)

        GameFinishController(mockViewModel, mockView, finalScore)
    }

    @Test
    fun `on start show the game score` () {
        verify(mockView).setScore(mockViewModel.finalScore.toString())
    }

    @Test
    fun `click on start again button takes user to home fragment` () {
        val argumentCaptor = argumentCaptor<() -> Unit>()
        verify(mockView).setStartAgainClickListener(argumentCaptor.capture())

        argumentCaptor.firstValue.invoke()
        verify(mockView).navigateToHome()

    }
}