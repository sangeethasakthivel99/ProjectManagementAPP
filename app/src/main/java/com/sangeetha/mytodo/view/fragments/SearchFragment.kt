package com.sangeetha.mytodo.view.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sangeetha.mytodo.R
import com.sangeetha.mytodo.util.onQueryTextChanged
import com.sangeetha.mytodo.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment: Fragment(R.layout.search_fragment) {

    private lateinit var searchView: SearchView

    private val viewModel: SearchViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search, menu)
        val searchItem = menu.findItem(R.id.search)
        searchView = searchItem.actionView as SearchView
        initSearch()
    }

    private fun initSearch() {
        searchView.onQueryTextChanged {
            viewModel.searchQuery.value = it
        }
    }
}
