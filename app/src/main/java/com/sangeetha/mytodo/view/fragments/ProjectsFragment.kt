package com.sangeetha.mytodo.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sangeetha.mytodo.R
import com.sangeetha.mytodo.viewmodel.TodoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_create_project.*
import kotlinx.android.synthetic.main.toolbar.view.*

@AndroidEntryPoint
class ProjectsFragment: Fragment() {

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
        setClickListeners()

    }

    private fun setupToolBar() {
        toolbar.toolbarTitle.text = resources.getString(R.string.projects)
    }

    private fun setClickListeners() {
        toolbar.backButton.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
    }
}
