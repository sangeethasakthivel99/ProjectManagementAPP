package com.sangeetha.mytodo.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.sangeetha.mytodo.R
import com.sangeetha.mytodo.databinding.FragmentSearchBinding
import com.sangeetha.mytodo.util.onQueryTextChanged
import com.sangeetha.mytodo.view.adapters.TaskAdapter
import com.sangeetha.mytodo.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_tasks.*
import kotlinx.android.synthetic.main.fragment_tasks.recyclerView
import kotlinx.android.synthetic.main.search_fragment.*

@AndroidEntryPoint
class SearchFragment: Fragment(R.layout.search_fragment) {

    private lateinit var searchView: SearchView

    private val viewModel: SearchViewModel by viewModels()

    private val taskAdapter = TaskAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        setUpSearchView()
        initObservers()
    }

    private fun  setUpSearchView() {

    }

    private fun initSearch() {
        searchView.onQueryTextChanged {
            viewModel.searchQuery.value = it
        }
    }

    private fun initRecyclerView() {
        recyclerView.apply {
            adapter = taskAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun initObservers() {
        viewModel.getTasks.observe(viewLifecycleOwner) {
            taskAdapter.submitList(it)
            Log.e("TAG", "initObservers: " + it.size )
        }
    }
}
