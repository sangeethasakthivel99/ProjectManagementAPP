package com.sangeetha.mytodo.repository

import com.sangeetha.mytodo.database.FolderWithToDos
import com.sangeetha.mytodo.database.TodoDao
import com.sangeetha.mytodo.database.TodoEntity
import com.sangeetha.mytodo.database.TodoFolderEntity
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(
    private val todoDao: TodoDao
): TodoRepository {
    override suspend fun insertTodo(todo: TodoEntity) {
         return todoDao.insertTodo(todo)
    }

    override suspend fun insertTodoFolder(todoFolder: TodoFolderEntity) {
        return todoDao.insertTodoFolder(todoFolder)
    }

    override suspend fun deleteTodoById(todoId: Long) {
        return todoDao.deleteTodoById(todoId)
    }

    override suspend fun deleteFolderById(folderId: Long) {
        return todoDao.deleteFolderById(folderId)
    }

    override suspend fun getAllTodo(): List<TodoEntity> {
        return todoDao.getAllToDos()
    }

    override suspend fun getAllTodoFolders(): List<TodoFolderEntity> {
        return todoDao.getAllFolders()
    }

    override suspend fun getTodoById(id: Long): TodoEntity {
        return todoDao.getTodoById(id)
    }

    override suspend fun getTodoByDueDate(dueDate: String): List<TodoEntity> {
        return todoDao.getTodoByDueDate(dueDate)
    }

    override suspend fun getTodoByFolder(folderId: Long): List<FolderWithToDos> {
        return todoDao.getToDosWithFolder(folderId)
    }

    override suspend fun deleteAllTodoInTheFolder(folderId: Long) {
        return todoDao.deleteAllTodoInTheFolder(folderId)
    }
}
