package com.sangeetha.mytodo.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.sangeetha.mytodo.repository.TodoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest

class SearchViewModel @ViewModelInject constructor(
    private val repository: TodoRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
): ViewModel() {

    var searchQuery = MutableStateFlow("")

    private val taskFlow = searchQuery.flatMapLatest {
        repository.getTasks(it)
    }

    val getTasks = taskFlow.asLiveData()
}