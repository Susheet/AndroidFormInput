package com.example.project1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Data_Table")
class Data(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    val username: String,
    val email: String,
    val category: String,
    val stream: String,
    val jobStatus: String
) {
}