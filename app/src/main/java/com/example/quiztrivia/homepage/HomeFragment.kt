package com.example.quiztrivia.homepage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.quiztrivia.R
import com.example.quiztrivia.ViewModelFactory

class HomeFragment : Fragment(R.layout.home_fragment) {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelFactory().create(HomeViewModel::class.java)
        HomeViewController(viewModel, HomeView(view))

        viewModel.navigateToCustomPlay.observe(viewLifecycleOwner, Observer {
            if(it == true ) {
                this.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToOptionSelectionFragment())
            }
        })

        viewModel.navigateToDirectPlay.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                this.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToQuizQuestions(viewModel.selectedItemIndexes))
            }
        })
    }

}