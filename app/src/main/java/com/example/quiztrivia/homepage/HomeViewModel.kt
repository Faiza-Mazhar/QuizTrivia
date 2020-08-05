package com.example.quiztrivia.homepage

import androidx.lifecycle.ViewModel
import com.example.quiztrivia.optionselection.SelectedItemIndexes

class HomeViewModel : ViewModel() {

    val selectedItemIndexes = SelectedItemIndexes(0, 0, 0)
}