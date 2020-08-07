package com.example.quiztrivia.homepage

import com.example.quiztrivia.optionselection.SelectedItemIndexes

class HomeViewController(viewModel: HomeViewModel, private val homeView: HomeView) {

    init {
        homeView.setCustomPlayListener {
            navigateToOptionSelectionFragment()
        }

        homeView.setDirectPlayListener {
            navigateToQuestionDisplayFragment()
        }
    }


    private fun navigateToQuestionDisplayFragment() {
        homeView.navigateToQuestionDisplayFragment(SelectedItemIndexes())
    }

    private fun navigateToOptionSelectionFragment() {
        homeView.navigateToOptionSelectionFragment()
    }
}

