package com.example.quiztrivia.homepage
//
//import androidx.fragment.app.testing.launchFragmentInContainer
//import androidx.navigation.NavController
//import androidx.navigation.Navigation
//import androidx.test.espresso.Espresso.onView
//import androidx.test.espresso.action.ViewActions
//import androidx.test.espresso.matcher.ViewMatchers
//import androidx.test.ext.junit.runners.AndroidJUnit4
//import com.example.quiztrivia.R
//import com.example.quiztrivia.optionselection.SelectedItemIndexes
//import org.junit.Before
//import org.junit.Test
//import org.junit.runner.RunWith
//import org.mockito.Mockito.mock
//import org.mockito.Mockito.verify
//
//
//@RunWith(AndroidJUnit4::class)
//class HomeViewUITest {
//
//    private val mockNavController: NavController = mock(NavController::class.java)
//
//    @Before
//    fun setup(){
//        mockNavController.setGraph(R.navigation.nav_graph)
//        launchFragmentInContainer {
//            HomeFragment().also { fragment ->
//                fragment.viewLifecycleOwnerLiveData.observeForever { viewLifecycleOwner ->
//                    if (viewLifecycleOwner != null) {
//                        Navigation.setViewNavController(fragment.requireView(), mockNavController)
//                    }
//                }
//            }
//        }
//    }
//
//    @Test
//    fun testNavigationToOptionSelectionFragment() {
//        onView(ViewMatchers.withId(R.id.home_fragment_custom_play)).perform(ViewActions.click())
//        verify(mockNavController).navigate(HomeFragmentDirections.actionHomeFragmentToOptionSelectionFragment())
//    }
//
//    @Test
//    fun testNavigationToQuestionDisplayFragment() {
//        val arguments = SelectedItemIndexes()
//        onView(ViewMatchers.withId(R.id.home_fragment_direct_play)).perform(ViewActions.click())
//        verify(mockNavController).navigate(HomeFragmentDirections.actionHomeFragmentToQuizQuestions(arguments))
//    }
//}