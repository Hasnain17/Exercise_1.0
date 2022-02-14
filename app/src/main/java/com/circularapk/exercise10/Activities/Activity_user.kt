package com.circularapk.exercise10.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.circularapk.exercise10.R
import com.circularapk.exercise10.databinding.ActivityUserBinding

class Activity_user : AppCompatActivity() {
    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val name=intent.getStringExtra("name")
        val phone=intent.getStringExtra("phone")
        val country=intent.getStringExtra("country")
        val image=intent.getIntExtra("image",R.drawable.user)

        binding.userName.text=name
        binding.userCountry.text=country
        binding.userPhone.text=phone
        binding.profileImage.setImageResource(image)

    }
}