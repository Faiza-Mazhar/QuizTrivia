package com.example.quiztrivia.homepage

class HomeViewController(private val viewModel: HomeViewModel, private val homeView: HomeView) {

    init {
        homeView.setCustomPlayListener {
            navigateToOptionSelectionFragment()
        }

        homeView.setDirectPlayListener {
            navigateToQuestionDisplayFragment()
        }
    }

    private fun navigateToQuestionDisplayFragment() {
        homeView.navController.navigate(HomeFragmentDirections.actionHomeFragmentToQuizQuestions(viewModel.selectedItemIndexes))
    }

    private fun navigateToOptionSelectionFragment() {
        homeView.navController.navigate(HomeFragmentDirections.actionHomeFragmentToOptionSelectionFragment())
    }
}

