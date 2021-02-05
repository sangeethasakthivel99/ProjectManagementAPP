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
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    var taskId: Long? = null,
    var projectId: Long? = null,
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
data class ProjectEntity(
    @PrimaryKey(autoGenerate = true)
    var projectId: Long? = null,
    var projectName: String? = null,
    var duedate: String? = null,
    var isImportant: Boolean,
    var createdOn:  Long = System.currentTimeMillis()
): Parcelable {
    val getCreatedDateInFormat: String
        get() = DateFormat.getDateTimeInstance().format(createdOn)
}

@Parcelize
data class ProjectWithTasks(
    @Embedded
    val project: ProjectEntity,

    @Relation(
        parentColumn = "projectId",
        entityColumn = "projectId"
    )
    val tasks: List<TaskEntity>
): Parcelable
