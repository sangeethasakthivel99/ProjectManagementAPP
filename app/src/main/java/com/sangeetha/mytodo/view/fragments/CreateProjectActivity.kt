package com.sangeetha.mytodo.view.fragments

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.sangeetha.mytodo.R
import com.sangeetha.mytodo.viewmodel.TaskViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_create_project.*
import kotlinx.android.synthetic.main.toolbar.view.*
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CreateProjectActivity : AppCompatActivity() {

    private val viewModel: TaskViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_create_project)
        setupToolBar()
        setClickListeners()
    }

    private fun setupToolBar() {
        toolbar.toolbarTitle.text = resources.getString(R.string.create_project)
    }

    private fun setClickListeners() {
        toolbar.backButton.setOnClickListener {
            finish()
        }

        fabCreateFolder.setOnClickListener {
            createProject()
        }
    }

    private fun createProject() {
        if (isValidProjectDetails()) {
            val insert= lifecycleScope.launch {
                viewModel.createProject(projectName.text.toString(),dueDate.text.toString())
            }

            if (insert.isCompleted) {
                Snackbar.make(rootLayout,"Project Created Successfully", Snackbar.LENGTH_SHORT)
                finish()
            }

        } else {
            showError()
        }
    }

    private fun isValidProjectDetails(): Boolean {
        return projectName.text.trim().isNotEmpty() && dueDate.text.trim().isNotEmpty()
    }

    private fun showError() {
        if (projectName.text.trim().isEmpty()) {
            projectName.error = getString(R.string.empty_project_error)
        }

        if (dueDate.text.trim().isEmpty()) {
            dueDate.error = getString(R.string.empty_duedate_error)
        }
    }
}
