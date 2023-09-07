package com.fikrisandi.local.converter

interface BaseConverter<T> {
    fun fromObjToString(): String
    fun fromStringToObj(): T
}