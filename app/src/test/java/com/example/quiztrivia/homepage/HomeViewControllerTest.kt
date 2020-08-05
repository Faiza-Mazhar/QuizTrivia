package com.example.quiztrivia.homepage

import com.example.quiztrivia.optionselection.SelectedItemIndexes
import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class HomeViewControllerTest {
    @Mock private lateinit var mockViewModel: HomeViewModel
    @Mock private lateinit var mockHomeView: HomeView
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        HomeViewController(mockViewModel, mockHomeView)
    }

    @Test
    fun `clicking on Customise Quiz button navigates to OptionSelectionFragment` () {
        val customQuizClickCaptor = argumentCaptor<() -> Unit>()
        verify(mockHomeView).setCustomPlayListener(customQuizClickCaptor.capture())
        customQuizClickCaptor.firstValue.invoke()
        verify(mockHomeView).navigateToOptionSelectionFragment()
    }

    @Test
    fun `clicking on Play button navigates to OptionSelectionFragment` () {
        val clickCaptor = argumentCaptor<() -> Unit>()
        verify(mockHomeView).setDirectPlayListener(clickCaptor.capture())
        clickCaptor.firstValue.invoke()
        verify(mockHomeView).navigateToQuestionDisplayFragment(SelectedItemIndexes())
    }
}