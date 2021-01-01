package com.sangeetha.mytodo.di

import android.content.Context
import androidx.room.Room
import com.sangeetha.mytodo.database.TodoDao
import com.sangeetha.mytodo.database.TodoDatabase
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
object TodoModule {

    @Singleton
    @Provides
    fun provideTodoDatabase(@ApplicationContext context: Context): TodoDatabase {
        return Room.databaseBuilder(
            context,
            TodoDatabase::class.java,
            "todo_database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideTodoDao(@ApplicationContext context: Context): TodoDao {
        return provideTodoDatabase(context).todoDao()
    }

    @Provides
    fun provideTodoRepository(todoDao: TodoDao): TodoRepository {
        return TodoRepositoryImpl(todoDao)
    }
}
