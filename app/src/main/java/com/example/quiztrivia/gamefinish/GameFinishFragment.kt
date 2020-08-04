package com.example.quiztrivia.gamefinish

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.quiztrivia.R

class GameFinishFragment : Fragment() {

    companion object {
        fun newInstance() = GameFinishFragment()
    }

    private lateinit var viewModel: GameFinishViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.game_finish_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GameFinishViewModel::class.java)
        // TODO: Use the ViewModel
    }

}