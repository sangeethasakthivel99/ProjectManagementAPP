package com.sangeetha.mytodo.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.PagerSnapHelper
import com.sangeetha.mytodo.R
import com.sangeetha.mytodo.view.adapters.HomeTodoFolderAdapter
import com.sangeetha.mytodo.viewmodel.TodoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_todo_folders.*
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class HomeTodoFolderFragment: Fragment() {

    private val viewModel: TodoViewModel by viewModels()

    private lateinit var adapter: HomeTodoFolderAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_todo_folders, container, true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        initRecyclerView()
    }

    private fun initObservers() {
        val data = runBlocking {
            viewModel.getAllTodoFolders().await()
        }
        adapter.setData(data)
    }

    private fun initRecyclerView() {
        adapter = HomeTodoFolderAdapter()
        folderRecyclerView.apply {
            adapter = adapter
            PagerSnapHelper().attachToRecyclerView(folderRecyclerView)
        }
    }
}