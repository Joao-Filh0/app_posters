package com.example.appposters.utils.extensions

fun String.textCapitalize(): String {

    return if (this.isNotEmpty()) {
        this[0].uppercaseChar() + this.substring(1)
    } else {
        this
    }
}