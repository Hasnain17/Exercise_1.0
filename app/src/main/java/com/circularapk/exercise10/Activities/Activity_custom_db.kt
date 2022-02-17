package com.circularapk.exercise10.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.room.Room
import com.circularapk.exercise10.Data.Contact
import com.circularapk.exercise10.Database.ContactDatabase
import com.circularapk.exercise10.databinding.ActivityCustomDbBinding
import com.circularapk.exercise10.databinding.ActivityCustomDbBinding.inflate
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class Activity_custom_db : AppCompatActivity() {
    lateinit var database: ContactDatabase
    private lateinit var binding: ActivityCustomDbBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=inflate(layoutInflater)
        setContentView(binding.root)
        database= Room.databaseBuilder(applicationContext,ContactDatabase::class.java,"DB_Contact").build()
        binding.btnAddRec.setOnClickListener{
            if (binding.etName.text.toString().isEmpty()||binding.etPhone.text.toString().isEmpty())
            {
                Toast.makeText(this,"All fields must be filled!......",Toast.LENGTH_SHORT).show()
            }
            else
            {
                //Create Co-routines
                GlobalScope.launch {
                    database.contactDao().insertContact(Contact(0, binding.etName.text.toString(), binding.etPhone.text.toString()))

                }
            }
        }
binding.tvGetData.setOnClickListener{
    database.contactDao().getContact().observe(this, Observer {
        binding.tvGetData.text=it.toString()

    })
}

    }

//    fun getData(view: View) {
//
//    }
}