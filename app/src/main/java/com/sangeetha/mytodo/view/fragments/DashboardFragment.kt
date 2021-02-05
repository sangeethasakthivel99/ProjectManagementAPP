package com.sangeetha.mytodo.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.sangeetha.mytodo.R
import com.sangeetha.mytodo.database.ProjectEntity
import com.sangeetha.mytodo.view.SearchActivity
import com.sangeetha.mytodo.view.adapters.ProjectAdapter
import com.sangeetha.mytodo.viewmodel.TaskViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_dashboard.projectRecyclerView
import kotlinx.android.synthetic.main.fragment_projects.*
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DashboardFragment: Fragment(R.layout.fragment_dashboard) {

    private val viewModel: TaskViewModel by viewModels()

    private var projectAdapter = ProjectAdapter()

    private var projects: List<ProjectEntity> = listOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        getProjects()
        setOnCLickListeners()
    }

    private fun initRecyclerView() {
        projectRecyclerView.apply {
            adapter = projectAdapter
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                true
            )
        }
    }

    private fun getProjects() {
        lifecycleScope.launch {
            viewModel.getAllTodoFolders().await().asLiveData().observe(viewLifecycleOwner) {
                projects = it
                progressbar.visibility = View.GONE
                if (projects.isEmpty()) {
                    initEmptyView()
                    return@observe
                }
                projectAdapter.submitList(it)
            }
        }
    }

    private fun initEmptyView() {

    }

    private fun setOnCLickListeners() {
        search.setOnClickListener {
            navigateToSearchActivity()
        }
    }

    private fun navigateToSearchActivity() {
        startActivity(Intent(requireActivity(), SearchActivity::class.java))
    }
}
