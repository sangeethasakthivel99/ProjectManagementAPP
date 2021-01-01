package com.sangeetha.mytodo.database

import androidx.room.*

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todoEntity: TodoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodoFolder(todoFolderEntity: TodoFolderEntity)

    @Transaction
    @Query("SELECT * FROM todofolderentity WHERE folderId = :folderId")
    suspend fun getToDosWithFolder(folderId: Long): List<FolderWithToDos>

    @Transaction
    @Query("SELECT * FROM todofolderentity")
    suspend fun getAllFolders(): List<TodoFolderEntity>

    @Transaction
    @Query("SELECT * FROM todoentity")
    suspend fun getAllToDos(): List<TodoEntity>

    @Transaction
    @Query("SELECT * FROM todoentity WHERE todoId = :id")
    suspend fun getTodoById(id: Long): TodoEntity

    @Transaction
    @Query("SELECT * FROM todoentity WHERE duedate = :dueDate")
    suspend fun getTodoByDueDate(dueDate: String): List<TodoEntity>

    @Transaction
    @Query("DELETE FROM todoentity WHERE todoId = :id ")
    suspend fun deleteTodoById(id: Long)

    @Transaction
    @Query("DELETE FROM todofolderentity WHERE folderId = :folderId")
    suspend fun deleteFolderById(folderId: Long)

    @Transaction
    @Query("DELETE FROM todoentity WHERE folderId = :folderId")
    suspend fun deleteAllTodoInTheFolder(folderId: Long)
}
