package com.example.project1

import androidx.lifecycle.LiveData

class DataRepository(private val dataDao: DataDao) {

    val allData: LiveData<List<Data>> = dataDao.getAllData()

     fun insert(data: Data){
        dataDao.insert(data)
    }

//    suspend fun delete(data: Data){
//        dataDao.delete(data)
//    }
}