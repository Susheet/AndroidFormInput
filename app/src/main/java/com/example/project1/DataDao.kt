package com.example.project1

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DataDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(data: Data)

//    @Delete
//    suspend fun delete(data: Data)

    @Query("Select * from data_table")
    fun getAllData(): LiveData<List<Data>>
}