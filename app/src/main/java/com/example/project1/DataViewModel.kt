package com.example.project1

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DataViewModel(application: Application) : AndroidViewModel(application) {


    val dao = DataDatabase.getDatabase(application).getDataDao()
    val allData: LiveData<List<Data>>

    init {
        allData = dao.getAllData()P
    }

    fun insertData(data: Data) = viewModelScope.launch(Dispatchers.IO) {
        dao.insert(data)

    }

    fun updateData(data: Data) = viewModelScope.launch(Dispatchers.IO) {
        dao.update(data)
    }

    fun get(email: String) = viewModelScope.launch(Dispatchers.IO) {
        dao.getId(email)
    }
}