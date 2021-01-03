package com.sangeetha.mytodo.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(taskEntity: TaskEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodoFolder(projectEntity: ProjectEntity)

    @Update
    suspend fun updateTodo(taskEntity: TaskEntity)

    @Transaction
    @Query("SELECT * FROM projectentity WHERE projectId = :projectId")
    fun getToDosWithFolder(projectId: Long): Flow<List<ProjectWithTasks>>

    @Transaction
    @Query("SELECT * FROM projectentity")
    fun getAllFolders(): Flow<List<ProjectEntity>>

    @Transaction
    @Query("SELECT * FROM taskentity")
    fun getAllToDos(): Flow<List<TaskEntity>>

    @Transaction
    @Query("SELECT * FROM taskentity WHERE title LIKE '%' || :searchQuery || '%'")
    fun getTask(searchQuery: String): Flow<List<TaskEntity>>

    @Transaction
    @Query("SELECT * FROM taskentity WHERE taskId = :id")
    fun getTodoById(id: Long): Flow<TaskEntity>

    @Transaction
    @Query("SELECT * FROM taskentity WHERE duedate = :dueDate")
    fun getTodoByDueDate(dueDate: String): Flow<List<TaskEntity>>

    @Transaction
    @Query("DELETE FROM taskentity WHERE taskId = :id ")
    suspend fun deleteTodoById(id: Long)

    @Transaction
    @Query("DELETE FROM projectentity WHERE projectId = :folderId")
    suspend fun deleteFolderById(folderId: Long)

    @Transaction
    @Query("DELETE FROM taskentity WHERE projectId = :projectId")
    suspend fun deleteAllTodoInTheFolder(projectId: Long)

    @Delete
    suspend fun deleteTodo(taskEntity: TaskEntity)
}
