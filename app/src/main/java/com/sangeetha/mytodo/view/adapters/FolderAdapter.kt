package com.sangeetha.mytodo.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sangeetha.mytodo.R
import com.sangeetha.mytodo.database.TodoFolderEntity
import com.sangeetha.mytodo.util.BackgroundGenerator
import kotlinx.android.synthetic.main.item_folders.view.*

class FolderAdapter: RecyclerView.Adapter<FolderAdapter.FolderAdapterViewHolder>() {

    private var folderList: MutableList<TodoFolderEntity> = mutableListOf()

    fun setData(folderList: List<TodoFolderEntity>) {
        this.folderList = folderList as MutableList
        folderList.add(TodoFolderEntity(1,"untitled"))
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FolderAdapterViewHolder {
        return FolderAdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_folders, parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FolderAdapterViewHolder, position: Int) {
        holder.bindView(folderList[position])
    }

    override fun getItemCount(): Int {
        return folderList.size
    }

    inner class FolderAdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindView(item: TodoFolderEntity) {
            //val background = BackgroundGenerator.get()
//            itemView.folderName.text = item.folderName
//            itemView.cardView.setCardBackgroundColor(background.color)
//            Glide.with(itemView.context)
//                .load(item.folderImage)
//                .error(background.image)
//                .into(itemView.folderImage)
        }
    }
}
