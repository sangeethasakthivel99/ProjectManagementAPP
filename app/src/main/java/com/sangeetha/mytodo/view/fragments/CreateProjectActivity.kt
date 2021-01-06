package com.sangeetha.mytodo.view.fragments

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.sangeetha.mytodo.R
import com.sangeetha.mytodo.viewmodel.TaskViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_create_project.*
import kotlinx.android.synthetic.main.toolbar.view.*

@AndroidEntryPoint
class CreateProjectActivity: AppCompatActivity() {

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
    }

}