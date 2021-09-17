package com.example.quiztrivia.homepage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.quiztrivia.R
import com.example.quiztrivia.ViewModelFactory

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var viewModel: HomeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelFactory().create(HomeViewModel::class.java)
        HomeViewController(viewModel, HomeView(view))
    }

}