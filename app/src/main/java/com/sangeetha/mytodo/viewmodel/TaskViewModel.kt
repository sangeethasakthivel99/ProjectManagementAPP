package com.sangeetha.mytodo.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.sangeetha.mytodo.database.ProjectEntity
import com.sangeetha.mytodo.repository.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TaskViewModel @ViewModelInject constructor(
    private val repository: TodoRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val getTasks = repository.getAllTasks().asLiveData()

    fun createProject(projectName: String, dueDate: String) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.createProject(
                ProjectEntity(
                    projectName = projectName,
                    duedate = dueDate,
                    isImportant = false
                )
            )
        }

    suspend fun getAllTodoFolders() =
        withContext(viewModelScope.coroutineContext + Dispatchers.IO) {
            repository.getAllTodoFolders()
        }

}
