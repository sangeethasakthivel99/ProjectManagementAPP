package com.sangeetha.mytodo.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.sangeetha.mytodo.R
import com.sangeetha.mytodo.view.adapters.FolderAdapter
import com.sangeetha.mytodo.viewmodel.TodoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_todo_folders.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FolderFragment: Fragment() {

    private val viewModel: TodoViewModel by viewModels()

    private val folderAdapter = FolderAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_todo_folders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        getFolders()
    }

    private fun initRecyclerView() {
        folderRecyclerView.apply {
            layoutManager = GridLayoutManager(context,2,GridLayoutManager.VERTICAL, false)
            adapter = folderAdapter
        }
    }

    private fun getFolders() {
        CoroutineScope(Dispatchers.Main).launch {
            val data = viewModel.getAllTodoFolders().await()
            folderAdapter.setData(data)
        }
    }
}
