package com.example.quiztrivia.questiondisplay

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.quiztrivia.R
import com.example.quiztrivia.ViewModelFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class QuestionDisplayFragment : Fragment(R.layout.fragment_question_display) {

    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val selectedItemIndexes = QuestionDisplayFragmentArgs.fromBundle(requireArguments()).selectedIndexes
        val questionDisplayViewModel = ViewModelFactory().create(QuestionDisplayViewModel::class.java)
        val questionDisplayView = QuestionDisplayView(view)
        QuestionDisplayController(questionDisplayViewModel, questionDisplayView, selectedItemIndexes)
    }
}