package com.example.quiztrivia.homepage

class HomeViewController(viewModel: HomeViewModel, homeView: HomeView) {

    init {
        homeView.setCustomPlayListener {
            viewModel.navigateToCustomPlay.value = true
        }

        homeView.setDirectPlayListener {
            viewModel.navigateToDirectPlay.value = true
        }
    }
}