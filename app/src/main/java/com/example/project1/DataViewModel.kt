package com.example.project1

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DataViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: DataRepository
    val allData: LiveData<List<Data>>

    init {
        val dao = DataDatabase.getDatabase(application).getDataDao()
        repository = DataRepository(dao)
        allData = repository.allData
    }

    fun insertData(data: Data) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(data)
    }

    fun updateData(data: Data) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(data)
    }

    fun get(email: String) = viewModelScope.launch(Dispatchers.IO) {
        repository.get(email)
    }
}