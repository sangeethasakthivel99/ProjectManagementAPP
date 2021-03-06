package com.sangeetha.mytodo.repository

import com.sangeetha.mytodo.database.ProjectWithTasks
import com.sangeetha.mytodo.database.TaskEntity
import com.sangeetha.mytodo.database.ProjectEntity
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    suspend fun insertTodo(task: TaskEntity)
    suspend fun createProject(project: ProjectEntity)
    suspend fun deleteTodoById(todoId: Long)
    suspend fun deleteFolderById(folderId: Long)
    fun getAllTasks(): Flow<List<TaskEntity>>
    fun getTasks(searchQuery: String): Flow<List<TaskEntity>>
    suspend fun getAllTodoFolders(): Flow<List<ProjectEntity>>
    suspend fun getTodoById(id: Long): Flow<TaskEntity>
    suspend fun getTodoByDueDate(dueDate: String): Flow<List<TaskEntity>>
    suspend fun getTodoByFolder(folderId:Long): Flow<List<ProjectWithTasks>>
    suspend fun deleteAllTodoInTheFolder(folderId: Long)
}
