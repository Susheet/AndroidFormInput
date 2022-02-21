package com.example.project1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Data_Table")
class Data(
    val username: String,
    val email: String,
    val category: String,
    val stream: String,
    val jobStatus: String
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}