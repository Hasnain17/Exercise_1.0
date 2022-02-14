package com.circularapk.exercise10.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.circularapk.exercise10.Adapters.MyAdapter
import com.circularapk.exercise10.Data.User
import com.circularapk.exercise10.R
import com.circularapk.exercise10.databinding.ActivityTestBinding
class Activity_test : AppCompatActivity() {
    private lateinit var binding: ActivityTestBinding
    private lateinit var countries: Array<String>
    private lateinit var userArrayList: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val imageId= intArrayOf(
            R.drawable.avatar,R.drawable.avatar_boy,R.drawable.beard,
            R.drawable.gamer,R.drawable.man,R.drawable.man_office,
            R.drawable.man_orange,R.drawable.profile,R.drawable.user,
            R.drawable.woman
        )
        val name= arrayOf(
            "Ayesha",
            "Hasnain",
            "Ahmad",
            "Moeen",
            "Awais",
            "Ali Hassan",
            "Muneeb",
            "Ammar",
            "Shah Saud",
            "Madiha"
        )
        val lastMessage= arrayOf(
            "Heye","Supp","Les's Catchup","Dinner tonight?","Gotta go",
            "i'm in meeting","Gotcha","Let's Go","any Weekend Plans?","What's up?"
        )
        val lastmsgTime= arrayOf(
            "8:45 pm","9:00 am","7:34 am","5:00 pm","10:11 am",
            "8:40 am","9:30 pm","7:20 pm","8;20 am","11:40 am"
        )
        val phoneNo= arrayOf(
            "+92356568465","+92356584844","+92355558465","+92358988465","+92316568565",
            "+92398682888","+92399568465","+92226568465","+92326568465","+92346568465"
        )
        val country= arrayOf(
            "Pakistan","Turkey","Iran","KSA","UK",
            "Germany","Holand","France","Canada","China"
        )
        //Initialize the arraylist
        userArrayList=ArrayList()
        for (i in name.indices)
        {
            val user=User(name[i],lastMessage[i], lastmsgTime[i],phoneNo[i],country[i],imageId[i])
            userArrayList.add(user)
        }
        binding.customListView.isClickable=true
        binding.customListView.setOnItemClickListener { adapterView, view, i, l ->
            val name=name[i]
            val phone=phoneNo[i]
            val country=country[i]
            val imageId=imageId[i]
            intent= Intent(applicationContext,Activity_user::class.java)
            intent.putExtra("name",name)
            intent.putExtra("phone",phone)
            intent.putExtra("image",imageId)
            intent.putExtra("country",country)
            intent.flags=Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
        }
        binding.customListView.adapter= MyAdapter(this,userArrayList)
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
            R.id.like ->{
                Toast.makeText(applicationContext,"Like",Toast.LENGTH_SHORT).show()
                return true
            }
            else -> return super.onContextItemSelected(item)
        }
    }
}