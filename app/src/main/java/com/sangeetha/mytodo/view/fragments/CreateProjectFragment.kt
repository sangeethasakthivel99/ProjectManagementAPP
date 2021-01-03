package com.sangeetha.mytodo.view.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sangeetha.mytodo.R
import com.sangeetha.mytodo.viewmodel.TaskViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateProjectFragment: Fragment(R.layout.fragment_create_project) {

    private val viewModel: TaskViewModel by viewModels()

}