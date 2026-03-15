package com.example.week02.util

fun readInt(prompt: String): Int {
    println(prompt)

    return readlnOrNull()?.toIntOrNull() ?: -1
}

fun readString(prompt: String): String {
    println(prompt)

    return readlnOrNull() ?: ""
}