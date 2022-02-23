package com.example.project1

import androidx.lifecycle.LiveData

class DataRepository(private val dataDao: DataDao) {

    val allData: LiveData<List<Data>> = dataDao.getAllData()

     fun insert(data: Data){
        dataDao.insert(data)
    }

    fun update(data: Data){
        dataDao.update(data)
    }

    fun get(email: String){
        dataDao.get(email)
    }
//    suspend fun delete(data: Data){
//        dataDao.delete(data)
//    }
}