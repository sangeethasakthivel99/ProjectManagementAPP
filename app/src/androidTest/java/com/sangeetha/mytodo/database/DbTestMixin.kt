package com.sangeetha.mytodo.database

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import org.junit.After
import org.junit.Before
import org.junit.Rule

abstract class DbTestMixin {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var _db: ProjectManagementDatabase
    val db: ProjectManagementDatabase
        get() = _db

    @Before
    fun initDb() {
        _db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            ProjectManagementDatabase::class.java
        ).build()
    }

    @After
    fun closeDb() {
        _db.close()
    }
}