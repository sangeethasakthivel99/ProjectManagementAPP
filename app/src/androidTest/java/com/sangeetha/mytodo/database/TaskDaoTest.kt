package com.sangeetha.mytodo.database

import androidx.lifecycle.asLiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TaskDaoTest: DbTestMixin() {

    @Test
    fun getAllProjectsShouldReturnInsertedProjects() = runBlocking {
        insertProjectsIntoDB()
        val projectFlow = db.taskDao().getAllProjects()
        projectFlow.flatMapLatest { projectFlow }
        db.taskDao().getAllProjects().asLiveData().let {
            Assert.assertEquals("Demo", it.value?.get(0)?.projectName)
        }
    }

    private fun insertProjectsIntoDB() = runBlocking {
        val taskDao = db.taskDao()
        taskDao.insertProject(getProject())
    }


    private fun getProject(): ProjectEntity {
        return  ProjectEntity(
            projectId = 1,
            projectName = "Demo",
            projectImage = null
        )
    }
}
