package com.example.quiztrivia.questiondisplay

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quiztrivia.json.JsonParser
import com.example.quiztrivia.network.NetworkService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class QuestionDisplayViewModel (private val networkService: NetworkService, private val jsonParser: JsonParser): ViewModel() {

    init {
        getNetworkResponse()
    }

    private fun getNetworkResponse() {
        var networkResponse: String? = null

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                networkResponse = networkService.getNetworkResponse("https://opentdb.com/api.php?amount=10")
            }
            if(networkResponse!=null) {
                val questionDefinition = jsonParser.getQuestionDefinition(networkResponse!!)?.results
                Log.d("Faiza M", questionDefinition.toString())
            }

        }

    }

}