package com.example.quiztrivia.gamefinish

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.quiztrivia.R
import com.example.quiztrivia.ViewModelFactory

class GameFinishFragment : Fragment(R.layout.fragment_game_finish) {

    companion object {
        fun newInstance() = GameFinishFragment()
    }
    private lateinit var viewModel: GameFinishViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val finalScore = GameFinishFragmentArgs.fromBundle(requireArguments()).finalScore
        viewModel = ViewModelFactory().create(GameFinishViewModel::class.java)
        GameFinishController(viewModel, GameFinishView(view), finalScore)
    }
}