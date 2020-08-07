package com.example.quiztrivia.gamefinish

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
        gameFinishView.setScore(gameFinishViewModel.finalScore.toString())
    }

    private fun navigateToHome() {
        gameFinishView.navigateToHome()
    }

}