package com.example.quiztrivia.json

import com.squareup.moshi.JsonDataException
import com.squareup.moshi.Moshi
import kotlin.reflect.KClass

class MoshiService {

    private val mapper: Moshi
        get() {
            return Moshi.Builder().build()
        }

    fun <T : Any> fromJson(jsonString: String, clazz: KClass<T>): T {
        return mapper.adapter<T>(clazz.java).lenient().fromJson(jsonString)
            ?: throw JsonDataException("Error parsing json - object was null")
    }

    fun <T : Any> toJson(jsonObject: T, clazz: KClass<T>): String {
        return mapper.adapter<T>(clazz.java).lenient().toJson(jsonObject)
    }
}