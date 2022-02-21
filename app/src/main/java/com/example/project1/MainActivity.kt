package com.example.project1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mviewModel: DataViewModel
    var selectedItem = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //spinner for dropdown list
        spStream.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedItem = adapterView?.getItemAtPosition(position).toString()
                Toast.makeText(
                    this@MainActivity,
                    "You selected ${adapterView?.getItemAtPosition(position).toString()}",
                    Toast.LENGTH_LONG
                ).show()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                //can leave blank as an option is always there
            }
        }

        //mviewModel = ViewModelProvider(this).get(DataViewModel::class.java)
        mviewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(DataViewModel::class.java)

        btnSubmit.setOnClickListener {

            val username = eTName.text.toString().trim()
            val email = etEmail.text.toString().trim()

            if(username.isEmpty()){
                eTName.error = "Name required"
                return@setOnClickListener
            }
            if(!email.isEmpty() && !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                etEmail.error = "Email required in correct format"
                Toast.makeText(this,"Email format empty or not correct",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }


            val category = when {
                cbMale.isChecked -> {
                    "Male"
                }
                cbFemale.isChecked -> {
                    "Female"
                }
                else -> {
                    "Others"
                }
            }

            var jobstatus = "PartTime"
            val status = sw.showText.toString()
            if(status == "true"){
                jobstatus = "FullTime"
            }

            val data = Data(username,email,category,selectedItem,jobstatus)
            mviewModel.insertData(data)

            Toast.makeText(this, "Data submitted successfully", Toast.LENGTH_LONG).show()
        }

        btnViewData.setOnClickListener {
            Toast.makeText(this, "Viewing Data", Toast.LENGTH_LONG).show()

            val intent = Intent(this, ViewAllData::class.java)
            startActivity(intent)
        }

    }
}