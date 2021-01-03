package com.sangeetha.mytodo.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.sangeetha.mytodo.R
import com.sangeetha.mytodo.databinding.FragmentTasksBinding
import com.sangeetha.mytodo.view.adapters.TaskAdapter
import com.sangeetha.mytodo.viewmodel.TaskViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TaskFragment: Fragment(R.layout.fragment_tasks) {

    @Inject
    lateinit var taskAdapter: TaskAdapter

    private lateinit var binding: FragmentTasksBinding

    private val viewModel: TaskViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTasksBinding.bind(view)
        initRecyclerView()
        getTasks()
    }

    private fun initRecyclerView() {
        binding.apply {
            recyclerView.apply {
                adapter = taskAdapter
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)
            }
        }
    }

    private fun getTasks() {
        viewModel.getTasks.observe(viewLifecycleOwner) {
            taskAdapter.submitList(it)
        }
    }
}
