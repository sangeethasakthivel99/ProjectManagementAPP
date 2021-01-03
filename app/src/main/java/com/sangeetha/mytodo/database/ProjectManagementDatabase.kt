package com.sangeetha.mytodo.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [
        TaskEntity::class,
        ProjectEntity::class
    ],
    exportSchema = false
)
abstract class ProjectManagementDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao
}