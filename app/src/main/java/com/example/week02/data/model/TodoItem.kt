package com.example.week02.data.model

data class TodoItem(
    val id: Int,
    val type: String,
    val title: String,
    var isDone: Boolean = false,
    val priority: String = "P2"
)