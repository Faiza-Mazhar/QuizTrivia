package com.example.quiztrivia.questiondisplay

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.quiztrivia.R
import com.example.quiztrivia.optionselection.SelectedItemIndexes
import kotlinx.coroutines.ExperimentalCoroutinesApi


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class QuestionDisplayFragment : Fragment(R.layout.fragment_question_display) {

    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val selectedItemIndexes = QuestionDisplayFragmentArgs.fromBundle(requireArguments()).selectedIndexes
        val questionDisplayViewModel: QuestionDisplayViewModel by lazy {
            ViewModelProviders.of(this, QuestionDisplayViewModelFactory(selectedItemIndexes)).get(QuestionDisplayViewModel::class.java)
        }
        val questionDisplayView = QuestionDisplayView(view)

        QuestionDisplayController(questionDisplayViewModel, questionDisplayView)
    }
}


class QuestionDisplayViewModelFactory
    (private val selectedItemIndexes: SelectedItemIndexes)
    : ViewModelProvider.Factory{
    @ExperimentalCoroutinesApi
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(QuestionDisplayViewModel::class.java)){
            return QuestionDisplayViewModel(selectedItemIndexes) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}