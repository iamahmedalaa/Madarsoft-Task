package com.example.madarsoft_task.data.dataModel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_info")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val age: Int,
    val jobTitle: String,
    val gender: String
)
