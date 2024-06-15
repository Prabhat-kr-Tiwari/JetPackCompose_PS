package com.prabhat.introduction.todo.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todoTable")
data class Todo(

    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val title:String,
    val description:String
)
