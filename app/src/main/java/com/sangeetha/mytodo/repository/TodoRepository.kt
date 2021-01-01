package com.sangeetha.mytodo.repository

import com.sangeetha.mytodo.database.FolderWithToDos
import com.sangeetha.mytodo.database.TodoEntity
import com.sangeetha.mytodo.database.TodoFolderEntity

interface TodoRepository {
    suspend fun insertTodo(todo: TodoEntity)
    suspend fun insertTodoFolder(todoFolder: TodoFolderEntity)
    suspend fun deleteTodoById(todoId: Long)
    suspend fun deleteFolderById(folderId: Long)
    suspend fun getAllTodo(): List<TodoEntity>
    suspend fun getAllTodoFolders(): List<TodoFolderEntity>
    suspend fun getTodoById(id: Long): TodoEntity
    suspend fun getTodoByDueDate(dueDate: String): List<TodoEntity>
    suspend fun getTodoByFolder(folderId:Long): List<FolderWithToDos>
    suspend fun deleteAllTodoInTheFolder(folderId: Long)
}
