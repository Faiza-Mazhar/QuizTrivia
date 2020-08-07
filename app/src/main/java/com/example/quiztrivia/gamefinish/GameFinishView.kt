package com.example.quiztrivia.gamefinish

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import com.example.quiztrivia.R

class GameFinishView(view: View) {

    private val finalScore: TextView = view.findViewById(R.id.game_finish_final_score)
    private val startAgain: Button = view.findViewById(R.id.game_finish_start_again)

    val navController = view.findNavController()

    fun setStartAgainClickListener(listener: () -> Unit) {
        startAgain.setOnClickListener{
            listener.invoke()
        }
    }
    fun setScore(string: String) {
        finalScore.text = string
    }

    fun navigateToHome() {
        navController.navigate(GameFinishFragmentDirections.actionGameFinishFragmentToHomeFragment())
    }
}