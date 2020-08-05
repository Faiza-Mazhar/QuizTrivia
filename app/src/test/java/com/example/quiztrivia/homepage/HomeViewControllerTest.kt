package com.example.quiztrivia.homepage

import androidx.navigation.NavController
import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class HomeViewControllerTest {
    @Mock private lateinit var mockViewModel: HomeViewModel
    @Mock private lateinit var mockHomeView: HomeView
    @Mock private lateinit var mockNavigation: NavController
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        whenever(mockHomeView.navController).thenReturn(mockNavigation)
        HomeViewController(mockViewModel, mockHomeView)
    }

    @Test
    fun `creating view controller sets the custom play listener` () {
        val customQuizClickCaptor = argumentCaptor<() -> Unit>()
        verify(mockHomeView).setCustomPlayListener(customQuizClickCaptor.capture())
    }

    @Test
    fun `creating view controller sets the play listener` () {
        val clickCaptor = argumentCaptor<() -> Unit>()
        verify(mockHomeView).setDirectPlayListener(clickCaptor.capture())
    }
}