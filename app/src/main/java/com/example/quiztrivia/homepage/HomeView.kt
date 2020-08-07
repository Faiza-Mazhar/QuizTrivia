package com.example.quiztrivia.homepage

import android.view.View
import android.widget.Button
import androidx.navigation.findNavController
import com.example.quiztrivia.R
import com.example.quiztrivia.optionselection.SelectedItemIndexes

class HomeView(view: View) {

    private val directPlay: Button = view.findViewById(R.id.home_fragment_direct_play)
    private val customPlay: Button = view.findViewById(R.id.home_fragment_custom_play)
    private val navController = view.findNavController()

    fun setDirectPlayListener(listener  : () -> Unit) {
        directPlay.setOnClickListener {
            listener.invoke()
        }
    }

    fun setCustomPlayListener(listener  : () -> Unit) {
        customPlay.setOnClickListener {
            listener.invoke()
        }
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