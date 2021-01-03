package com.sangeetha.mytodo.repository

import com.sangeetha.mytodo.database.ProjectWithTasks
import com.sangeetha.mytodo.database.TaskDao
import com.sangeetha.mytodo.database.TaskEntity
import com.sangeetha.mytodo.database.ProjectEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(
    private val taskDao: TaskDao
): TodoRepository {
    override suspend fun insertTodo(task: TaskEntity) {
         return taskDao.insertTodo(task)
    }

    override suspend fun insertTodoFolder(project: ProjectEntity) {
        return taskDao.insertTodoFolder(project)
    }

    override suspend fun deleteTodoById(todoId: Long) {
        return taskDao.deleteTodoById(todoId)
    }

    override suspend fun deleteFolderById(folderId: Long) {
        return taskDao.deleteFolderById(folderId)
    }

    override fun getAllTasks(): Flow<List<TaskEntity>> {
        return taskDao.getAllToDos()
    }

    override fun getTasks(searchQuery: String): Flow<List<TaskEntity>> {
        return taskDao.getTask(searchQuery)
    }

    override suspend fun getAllTodoFolders(): Flow<List<ProjectEntity>> {
        return taskDao.getAllFolders()
    }

    override suspend fun getTodoById(id: Long): Flow<TaskEntity> {
        return taskDao.getTodoById(id)
    }

    override suspend fun getTodoByDueDate(dueDate: String): Flow<List<TaskEntity>> {
        return taskDao.getTodoByDueDate(dueDate)
    }

    override suspend fun getTodoByFolder(folderId: Long): Flow<List<ProjectWithTasks>> {
        return taskDao.getToDosWithFolder(folderId)
    }

    override suspend fun deleteAllTodoInTheFolder(folderId: Long) {
        return taskDao.deleteAllTodoInTheFolder(folderId)
    }
}
