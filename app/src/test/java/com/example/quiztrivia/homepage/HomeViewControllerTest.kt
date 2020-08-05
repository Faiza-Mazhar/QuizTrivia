package com.example.quiztrivia.homepage

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class HomeViewControllerTest {
    @Mock
    private lateinit var mockViewModel: HomeViewModel
    @Mock
    private lateinit var homeView: HomeView

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `creating view controller sets the custom play listener` () {

    }
}