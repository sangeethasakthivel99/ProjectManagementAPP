package com.sangeetha.mytodo.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.sangeetha.mytodo.R
import com.sangeetha.mytodo.database.ProjectEntity
import com.sangeetha.mytodo.view.adapters.ProjectAdapter
import com.sangeetha.mytodo.viewmodel.TodoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_create_project.*
import kotlinx.android.synthetic.main.fragment_create_project.toolbar
import kotlinx.android.synthetic.main.fragment_projects.*
import kotlinx.android.synthetic.main.toolbar.view.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class ProjectsFragment: Fragment() {

    private var projects: List<ProjectEntity> = listOf()

    private var projectAdapter: ProjectAdapter = ProjectAdapter()

    private val viewModel: TodoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_projects, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolBar()
        initRecyclerView()
        getProjects()
        setClickListeners()
    }

    private fun setupToolBar() {
        toolbar.toolbarTitle.text = resources.getString(R.string.projects)
    }

    private fun initRecyclerView() {
        projectRecyclerView.apply {
            adapter = projectAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
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

    private fun setClickListeners() {
        toolbar.backButton.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
    }
}
