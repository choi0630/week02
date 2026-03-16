package com.example.week02.service

import com.example.week02.data.model.TodoItem

class TaskService {
    private val items = mutableListOf<TodoItem>()
    private var nextId = 1

    fun addItem(type: String, title: String, priority: String) {
        items.add(TodoItem(nextId++, type, title, priority = priority))
    }

    fun getItems(): List<TodoItem> {
        return items.sortedBy { it.priority }
    }

    fun searchItems(keyword: String): List<TodoItem> {
        return items.filter { it.title.contains(keyword, ignoreCase = true) }
    }

    fun toggleDone(id: Int): Boolean {
        val item = items.find { it.id == id }
        if (item != null) {
            item.isDone = !item.isDone
            return true
        }
        return false
    }

    fun deleteItem(id: Int): Boolean {
        return items.removeIf { it.id == id }
    }
}