package com.sangeetha.mytodo.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sangeetha.mytodo.database.TodoEntity
import com.sangeetha.mytodo.database.TodoFolderEntity
import com.sangeetha.mytodo.repository.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class TodoViewModel @ViewModelInject constructor(
    private val repository: TodoRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    fun saveTodo(todo: TodoEntity) = viewModelScope.async(Dispatchers.IO) {
        repository.insertTodo(todo)
    }

    fun saveTodoFolder(todoFolder: TodoFolderEntity) = viewModelScope.async(Dispatchers.IO) {
        repository.insertTodoFolder(todoFolder)
    }

    fun deleteTodoByFolder(folderId: Long) = viewModelScope.async(Dispatchers.IO) {
        repository.deleteAllTodoInTheFolder(folderId)
    }

    fun deleteAllTodo(todoId: Long) = viewModelScope.async(Dispatchers.IO) {
        repository.deleteTodoById(todoId)
    }

    fun deleteAllFolder(folderId: Long) = viewModelScope.async(Dispatchers.IO) {
        repository.deleteFolderById(folderId)
    }

    fun getTodoByFolder(folderId: Long) = viewModelScope.async(Dispatchers.IO) {
        repository.getTodoByFolder(folderId)
    }

    fun getAllTodo() = viewModelScope.async(Dispatchers.IO) {
        repository.getAllTodo()
    }

    fun getAllTodoFolders() = viewModelScope.async(Dispatchers.IO) {
        repository.getAllTodoFolders()
    }

    fun getTodoById(id: Long) = viewModelScope.async(Dispatchers.IO) {
        repository.getTodoById(id)
    }

    fun getTodoByDueDate(dueDate: String) = viewModelScope.async(Dispatchers.IO) {
        repository.getTodoByDueDate(dueDate)
    }
}
