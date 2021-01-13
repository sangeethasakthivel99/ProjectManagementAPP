package com.sangeetha.mytodo.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sangeetha.mytodo.R
import com.sangeetha.mytodo.view.SearchActivity
import com.sangeetha.mytodo.viewmodel.TaskViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_dashboard.*

@AndroidEntryPoint
class DashboardFragment: Fragment(R.layout.fragment_dashboard) {

    private val viewModel: TaskViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnCLickListeners()
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
