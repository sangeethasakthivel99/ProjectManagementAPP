package com.sangeetha.mytodo.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sangeetha.mytodo.database.ProjectEntity
import com.sangeetha.mytodo.databinding.ItemFoldersBinding

class ProjectAdapter: ListAdapter<ProjectEntity, ProjectAdapter.ProjectViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val binding = ItemFoldersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProjectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ProjectViewHolder(private val binding: ItemFoldersBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(project: ProjectEntity) {
            binding.apply {
                folderName.text = project.projectName
                createdOn.text = "Created on ${project.getCreatedDateInFormat}"
                star.isPressed = project.isImportant
            }
        }
    }

    class DiffCallback: DiffUtil.ItemCallback<ProjectEntity>() {
        override fun areItemsTheSame(oldItem: ProjectEntity, newItem: ProjectEntity): Boolean {
            return oldItem.projectId == newItem.projectId
        }

        override fun areContentsTheSame(oldItem: ProjectEntity, newItem: ProjectEntity): Boolean {
            return oldItem == newItem
        }
    }
}
