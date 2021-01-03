package com.sangeetha.mytodo.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.sangeetha.mytodo.database.TaskDao
import com.sangeetha.mytodo.repository.TodoRepository
import kotlinx.coroutines.flow.MutableStateFlow

class TaskViewModel @ViewModelInject constructor(
    private val repository: TodoRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
): ViewModel() {

    val getTasks = repository.getAllTasks().asLiveData()

}