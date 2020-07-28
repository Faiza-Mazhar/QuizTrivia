package com.example.quiztrivia.optionselection

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.quiztrivia.R
import com.example.quiztrivia.ViewModelFactory

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class OptionSelectionFragment : Fragment(R.layout.fragment_first) {

    private lateinit var viewModel: OptionSelectionViewModel
    private lateinit var viewController: OptionSelectionController
    private lateinit var optionSelectionView: OptionSelectionView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelFactory().create(OptionSelectionViewModel::class.java)
        optionSelectionView = OptionSelectionView(view)
        viewController = OptionSelectionController(viewModel, optionSelectionView)
    }
}