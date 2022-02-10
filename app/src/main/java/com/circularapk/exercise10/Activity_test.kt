package com.circularapk.exercise10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.circularapk.exercise10.databinding.ActivityMainBinding
import com.circularapk.exercise10.databinding.ActivityTestBinding

class Activity_test : AppCompatActivity() {
    private lateinit var binding: ActivityTestBinding
    private lateinit var countries: Array<String>
    private lateinit var language : Array<String>
    private lateinit var description: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        countries = arrayOf("Pakistan", "India", "China","Japan","Bangladesh","Iran")
       val arrayAdapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,countries)
        binding.listView.adapter=arrayAdapter
        registerForContextMenu(binding.listView)

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.context_menu,menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId)
        {
            R.id.like->{
                Toast.makeText(applicationContext,"Like",Toast.LENGTH_SHORT).show()
                return true
            }
            else -> return super.onContextItemSelected(item)
        }
    }
}