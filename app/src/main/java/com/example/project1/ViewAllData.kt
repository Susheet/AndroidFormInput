package com.example.project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_view_all_data.*

class ViewAllData : AppCompatActivity() {

    lateinit var mviewModel: DataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_all_data)

        //val username = intent.getStringExtra("username")
        //Log.d("username",username!!)

        rvDetails.layoutManager = LinearLayoutManager(this)
        val adapter = DataListAdapter(this)
        rvDetails.adapter = adapter

        mviewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(DataViewModel::class.java)
//        mviewModel = ViewModelProvider(this).get(DataViewModel::class.java)
        mviewModel.allData.observe(this, Observer {list ->
            list?.let{
                adapter.updateList(it)
            }
        })


    }


//    private fun fetchData():ArrayList<String>{
//        val list = ArrayList<String>()
//        for(i in 0 until 100){
//            list.add("item $i")
//        }
//        return list
//    }
}