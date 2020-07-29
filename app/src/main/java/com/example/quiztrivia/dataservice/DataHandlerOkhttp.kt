package com.example.quiztrivia.dataservice

import com.example.quiztrivia.optionselection.QuestionsDefinitionList
import kotlinx.coroutines.coroutineScope

class DataHandlerOkhttp(): DataHandler {
    override fun getQuestionDefinition(urlString: String): QuestionsDefinitionList {
        TODO("Not yet implemented")
    }

    private suspend fun getNetworkResponse() {
        var networkResponse: String? = null

        coroutineScope {

        }


    }
}