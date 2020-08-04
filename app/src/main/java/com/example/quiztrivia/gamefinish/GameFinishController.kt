package com.example.quiztrivia.gamefinish

import com.example.quiztrivia.R
import com.example.quiztrivia.questiondisplay.FinalScore

class GameFinishController(private val gameFinishViewModel: GameFinishViewModel,
                           private val gameFinishView: GameFinishView,
                           finalScore: FinalScore) {

    init{
        gameFinishViewModel.finalScore = finalScore
        setScore()

        gameFinishView.setStartAgainClickListener{
            navigateToHome()
        }
    }

    private fun setScore() {
        val finalScore = "You answered ${gameFinishViewModel.finalScore.rightQuestion} out of ${gameFinishViewModel.finalScore.totalQuestion}"
        gameFinishView.setScore(finalScore)
    }

    private fun navigateToHome() {
        gameFinishView.navController.navigate(R.id.homeFragment)
    }

}