package com.example.quiztrivia

import android.content.Context
import android.content.SharedPreferences
import com.example.quiztrivia.dataservice.DataManager
import kotlinx.coroutines.*


@ExperimentalCoroutinesApi
class Bootstrapper(context: Context) {

    private var PRIVATE_MODE = 0
    private val sharedPreference: SharedPreferences = context.getSharedPreferences("QuizCategories", PRIVATE_MODE)
    var editor: SharedPreferences.Editor = sharedPreference.edit()

    private lateinit var categoryMetadataResponse: String

    init {
        if(!sharedPreference.contains("CategoryNames")){
            getNetworkResponse()
        }
    }

    private fun getNetworkResponse() {
        GlobalScope.launch {
            withContext(Dispatchers.IO){
                categoryMetadataResponse = DataManager().getCategoryNetworkResponse()
            }
            editor.putString("CategoryNames", categoryMetadataResponse).apply()
            editor.commit()
        }
    }
}