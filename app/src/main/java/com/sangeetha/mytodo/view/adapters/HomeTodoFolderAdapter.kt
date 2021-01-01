package com.sangeetha.mytodo.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sangeetha.mytodo.R
import com.sangeetha.mytodo.database.TodoFolderEntity

class HomeTodoFolderAdapter :
    RecyclerView.Adapter<HomeTodoFolderAdapter.HomeTodoFolderViewHolder>() {

    private var folderList: MutableList<TodoFolderEntity> = mutableListOf()

    fun setData(folderList: List<TodoFolderEntity>) {
        this.folderList = folderList as MutableList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeTodoFolderViewHolder {
        return HomeTodoFolderViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_folders, parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HomeTodoFolderViewHolder, position: Int) {
        holder.bind(folderList[position])
    }

    override fun getItemCount(): Int {
        return folderList.size
    }

    inner class HomeTodoFolderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(todoFolder: TodoFolderEntity) {
            itemView.folderName.text = todoFolder.folderName
//            Glide.with(itemView.folderImage.context)
//                .load(todoFolder.folderImage)
//                .error(R.drawable.ic_todo_purple)
//                .into(itemView.folderImage)
        }
    }
}
