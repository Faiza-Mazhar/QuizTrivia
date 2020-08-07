package com.example.quiztrivia.optionselection

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.quiztrivia.R
import com.example.quiztrivia.ViewModelFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class OptionSelectionFragment : Fragment(R.layout.fragment_option_selection) {

    private lateinit var viewModel: OptionSelectionViewModel
    private lateinit var optionSelectionView: OptionSelectionView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelFactory().create(OptionSelectionViewModel::class.java)
        optionSelectionView = OptionSelectionView(view)

        val sharedPreference = this.activity?.getSharedPreferences("QuizCategories", 0)
        val categoryNames = sharedPreference?.getString("CategoryNames", null)
        OptionSelectionController(viewModel, optionSelectionView, categoryNames.toString())

    }
}