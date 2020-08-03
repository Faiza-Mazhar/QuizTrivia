package com.example.quiztrivia.homepage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quiztrivia.optionselection.SelectedItemIndexes

class HomeViewModel : ViewModel() {

    val navigateToCustomPlay = MutableLiveData<Boolean>()

    val navigateToDirectPlay = MutableLiveData<Boolean>()

    val selectedItemIndexes = SelectedItemIndexes(0, 0, 0)
}