package com.example.quiztrivia

fun String.convertFirstLetterToUpperCase(): String {
    val char = this[0].toUpperCase()
    return this.replaceFirst(this[0], char)
}

fun replaceHtmlEntities(myString: String): String {
    var string = myString.replace("&quot;", "\"")
    string = string.replace("&amp;", "&")
    string = string.replace("&#039;", "\'")
    string = string.replace("&deg;", "°")

    return string
}