package com.sangeetha.mytodo.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class TodoEntity(
    @PrimaryKey(autoGenerate = true)
    var todoId: Long,
    var folderId: Long? = null,
    var title: String,
    var description: String? = null,
    var createdOn: String? = null,
    var isCompleted: Boolean,
    var duedate: String? = null
)

@Entity
data class TodoFolderEntity(
    @PrimaryKey(autoGenerate = true)
    var folderId: Long,
    var folderName: String? = null,
    var folderImage: String? = null,
    var createdOn: String? = null
)

data class FolderWithToDos(
    @Embedded
    val folder: TodoFolderEntity,

    @Relation(
        parentColumn = "folderId",
        entityColumn = "folderId"
    )
    val toDos: List<TodoEntity>
)
