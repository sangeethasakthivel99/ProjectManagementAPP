package com.sangeetha.mytodo.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.sangeetha.mytodo.database.TaskDao

class TaskViewModel @ViewModelInject constructor(
    private val taskDao: TaskDao,
    @Assisted private val savedStateHandle: SavedStateHandle
): ViewModel() {
}