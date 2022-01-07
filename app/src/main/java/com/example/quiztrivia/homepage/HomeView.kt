package com.example.quiztrivia.homepage

import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.quiztrivia.R
import com.example.quiztrivia.composables.ButtonComposeView
import com.example.quiztrivia.optionselection.SelectedItemIndexes

class HomeView(view: View) {

    private val directPlay = view.findViewById<ButtonComposeView>(R.id.home_fragment_direct_play)
    private val customPlay = view.findViewById<ButtonComposeView>(R.id.home_fragment_custom_play)
    private val navController: NavController = view.findNavController()


    fun setDirectPlayListener(listener  : () -> Unit) {
        directPlay.title = "Play"
        directPlay.onClickEvent = listener
    }

    fun setCustomPlayListener(listener  : () -> Unit) {
        customPlay.title = "Custom Quiz"
        customPlay.onClickEvent = listener
    }

    fun navigateToQuestionDisplayFragment(selectedItemIndexes: SelectedItemIndexes) {
        navController.navigate(HomeFragmentDirections.actionHomeFragmentToQuizQuestions(
            selectedItemIndexes
        ))
    }

    fun navigateToOptionSelectionFragment() {
        navController.navigate(HomeFragmentDirections.actionHomeFragmentToOptionSelectionFragment())
    }

}