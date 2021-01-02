package com.sangeetha.mytodo.database

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import kotlinx.android.parcel.Parcelize
import java.text.DateFormat

@Entity
@Parcelize
data class TodoEntity(
    @PrimaryKey(autoGenerate = true)
    var todoId: Long,
    var folderId: Long? = null,
    var title: String,
    var description: String? = null,
    var createdOn: Long = System.currentTimeMillis(),
    var isCompleted: Boolean,
    var duedate: String? = null,
    var isImportant: Boolean = false
): Parcelable {
    val getCreatedDateInFormat: String
        get() = DateFormat.getDateTimeInstance().format(createdOn)
}

@Entity
@Parcelize
data class TodoFolderEntity(
    @PrimaryKey(autoGenerate = true)
    var folderId: Long,
    var folderName: String? = null,
    var folderImage: String? = null,
    var createdOn:  Long = System.currentTimeMillis()
): Parcelable

@Parcelize
data class FolderWithToDos(
    @Embedded
    val folder: TodoFolderEntity,

    @Relation(
        parentColumn = "folderId",
        entityColumn = "folderId"
    )
    val toDos: List<TodoEntity>
): Parcelable
