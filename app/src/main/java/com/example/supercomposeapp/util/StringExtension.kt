package com.example.supercomposeapp.util

fun String.containsNumbers(): Boolean {
    val regex = Regex(".*\\d+.*")
    return regex.matches(this)

}

fun String.containsUpperCase(): Boolean {
    val regex = Regex(".*[A-Z]+.*")
    return regex.matches(this)

}

fun String.containsSpecialCharacters(): Boolean {
    val regex = Regex(".*[^A-Za-z\\d]+.*")
    return regex.matches(this)

}