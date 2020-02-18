package com.example.todoexample.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "todo_items")
data class TodoEntity(
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "content") var content: String,
    @ColumnInfo(name = "currentDate") var dateTime: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}