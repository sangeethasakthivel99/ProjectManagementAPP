package com.sangeetha.mytodo.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sangeetha.mytodo.database.TaskEntity
import com.sangeetha.mytodo.databinding.ItemTasksBinding

class TaskAdapter : ListAdapter<TaskEntity, TaskAdapter.TaskViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = ItemTasksBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class TaskViewHolder(private val binding: ItemTasksBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(task: TaskEntity) {
            binding.apply {
                completedCheckbox.isChecked = task.isCompleted
                taskName.text = task.title
            }
        }
    }

    class DiffCallback: DiffUtil.ItemCallback<TaskEntity>() {
        override fun areItemsTheSame(oldItem: TaskEntity, newItem: TaskEntity): Boolean {
            return oldItem.taskId == newItem.taskId
        }

        override fun areContentsTheSame(oldItem: TaskEntity, newItem: TaskEntity): Boolean {
            return oldItem == newItem
        }
    }
}
