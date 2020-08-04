package com.example.quiztrivia

fun convertHTMLStringToString(string: String): String {
    val charset = Charsets.UTF_8
    val byteArray = string.toByteArray(charset)
    return byteArray.toString(charset)
}

fun String.convertFirstLetterToUpperCase(): String {
    val char = this[0].toUpperCase()
    return this.replace(this[0], char)
}

fun String.replaceAnsi(): String {
    val regex: Regex = Regex("[[&, a-z, 0-9]{5}:]?")
    val matches : Sequence<MatchResult> = regex.findAll(this)
    matches.forEach() {matchResult ->
        when(matchResult.value) {
           "&qout;" -> this.replace(matchResult.value, "\"")
           "&amp;" -> this.replace(matchResult.value, "&")
           "&#039;" -> this.replace(matchResult.value, "\'")
        }
    }
    return this
}