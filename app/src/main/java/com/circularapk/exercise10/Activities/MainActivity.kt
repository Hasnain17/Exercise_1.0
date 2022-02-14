package com.circularapk.exercise10.Activities
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.PopupMenu
import com.circularapk.exercise10.R
import com.circularapk.exercise10.databinding.ActivityMainBinding
import com.circularapk.exercise10.databinding.ActivityMainBinding.inflate
class MainActivity : AppCompatActivity() {
    lateinit var string: String
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShowText.setOnClickListener {
            string = binding.etGetText.text.toString()
            binding.tvShowText.setText(binding.etGetText.text.toString())
        }
        binding.camera.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }
        binding.googleChrome.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.isystech.org/"))
            startActivity(intent)
        }
        binding.googleMaps.setOnClickListener {
            intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("geo:33.71719066454401, 73.05999284861008?q=ISYSTECH")
            )
            startActivity(intent)
        }
        binding.btnExplicit.setOnClickListener {
            intent = Intent(this, Activity_test::class.java)
            startActivity(intent)
        }
        binding.btnPopUp.setOnClickListener {
            showPopup(binding.btnPopUp)
        }
        binding.btnFab.setOnClickListener{
            Toast.makeText(this, "fab Clicked", Toast.LENGTH_SHORT).show()


        }
        binding.bottomAppBar.setOnClickListener {
            binding.bottomAppBar.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.option_1 -> {
                        Toast.makeText(this, "Option 1 Clicked", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.option_2 -> {
                        Toast.makeText(this, "Option 2 Clicked", Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }
        }
    }
    private fun showPopup(view: View) {
        val popup = PopupMenu(this, view)
        popup.inflate(R.menu.context_menu)
        popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item: MenuItem? ->

            when (item!!.itemId) {
                R.id.like -> {
                    Toast.makeText(this@MainActivity, item.title, Toast.LENGTH_SHORT).show()
                }
                R.id.dislike -> {
                    Toast.makeText(this@MainActivity, item.title, Toast.LENGTH_SHORT).show()
                }
            }
            true
        })
        popup.show()
    }
    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert Dialog!")
        builder.setMessage("Do you want to close the application?")

        builder.setPositiveButton(android.R.string.yes) { dialog, which ->
            Toast.makeText(applicationContext,"Application is closed", Toast.LENGTH_SHORT).show()
            super.onBackPressed()
        }

        builder.setNegativeButton(android.R.string.no) { dialog, which ->
            Toast.makeText(applicationContext,
                android.R.string.no, Toast.LENGTH_SHORT).show()
        }
        builder.show()
    }
}