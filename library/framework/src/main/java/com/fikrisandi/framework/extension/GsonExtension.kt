package com.fikrisandi.framework.extension

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

val gson = GsonBuilder().create()

inline fun <reified T> String.fromJson(): T? {
    return try {
        gson.fromJson(this, T::class.java)
    } catch (ex: Exception) {
        null
    }
}

inline fun <reified T> String.fromJsonList(): List<T>? {
    return try {
        val type = object : TypeToken<List<T>>() {}.type
        gson.fromJson(this, type)
    } catch (ex: Exception) {
        null
    }
}

inline fun <reified T> T.toJson(): String {
    return try {
        gson.toJson(this)
    } catch (ex: Exception) {
        ""
    }
}