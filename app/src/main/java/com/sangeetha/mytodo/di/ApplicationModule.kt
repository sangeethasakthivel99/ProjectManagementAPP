package com.sangeetha.mytodo.di

import android.content.Context
import androidx.room.Room
import com.sangeetha.mytodo.database.TaskDao
import com.sangeetha.mytodo.database.ProjectManagementDatabase
import com.sangeetha.mytodo.repository.TodoRepository
import com.sangeetha.mytodo.repository.TodoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ApplicationModule {

    @Singleton
    @Provides
    fun provideTodoDatabase(@ApplicationContext context: Context): ProjectManagementDatabase {
        return Room.databaseBuilder(
            context,
            ProjectManagementDatabase::class.java,
            "project_management_database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideTaskDao(database: ProjectManagementDatabase) = database.taskDao()


    @Provides
    fun provideTodoRepository(taskDao: TaskDao): TodoRepository {
        return TodoRepositoryImpl(taskDao)
    }
}
