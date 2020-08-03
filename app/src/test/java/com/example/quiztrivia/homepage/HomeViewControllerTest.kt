package com.example.quiztrivia.homepage

import android.widget.Button
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class HomeViewControllerTest {
    @Mock
    private lateinit var mockViewModel: HomeViewModel
    @Mock
    private lateinit var homeView: HomeView

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `creating view controller sets the custom play listener` () {
        val customPlayClickCaptor = argumentCaptor< () -> Unit>()

        val mockButton = mock<Button>()
        whenever(homeView.customPlay).thenReturn(mockButton)

        HomeViewController(mockViewModel, homeView)

        verify(homeView).setCustomPlayListener(customPlayClickCaptor.capture())
        whenever(mockViewModel.navigateToCustomPlay.value).thenReturn(true)
        customPlayClickCaptor.firstValue.invoke()

    }
}