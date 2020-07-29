package com.example.quiztrivia.optionselection

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.quiztrivia.R
import com.example.quiztrivia.ViewModelFactory

class OptionSelectionFragment : Fragment(R.layout.fragment_option_selection) {

    private lateinit var viewModel: OptionSelectionViewModel
    private lateinit var viewController: OptionSelectionController
    private lateinit var optionSelectionView: OptionSelectionView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelFactory().create(OptionSelectionViewModel::class.java)
        optionSelectionView = OptionSelectionView(view)
        viewController = OptionSelectionController(viewModel, optionSelectionView)

        viewModel.selectedItemIndexes.observe(viewLifecycleOwner, Observer {
            if(it != null){
                this.findNavController().navigate(OptionSelectionFragmentDirections.actionOptionSelectionFragmentToQuizQuestions(it))
            }
        })
    }
}