package com.example.quiztrivia.optionselection

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.quiztrivia.R
import com.example.quiztrivia.ViewModelFactory

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class OptionSelectionFragment : Fragment(R.layout.fragment_first) {

    private lateinit var viewModel: OptionSelectionViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        viewModel = ViewModelFactory().create(OptionSelectionViewModel::class.java)
    }
}