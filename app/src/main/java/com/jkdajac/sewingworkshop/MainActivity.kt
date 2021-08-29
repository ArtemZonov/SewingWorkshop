package com.jkdajac.sewingworkshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     ivMenuOpen.setOnClickListener {
            dlDrawer.openDrawer(GravityCompat.START)
        }

        nvMenuNavigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.clients -> {
                    Toast.makeText(this@MainActivity, "Clients", Toast.LENGTH_SHORT).show()
                }
                R.id.templates -> {
                    Toast.makeText(this@MainActivity, "Templates", Toast.LENGTH_SHORT).show()
                }
                R.id.manual -> {
                    Toast.makeText(this@MainActivity, "Manual", Toast.LENGTH_SHORT).show()
                }
                R.id.settings -> {
                    Toast.makeText(this@MainActivity, "Settings", Toast.LENGTH_SHORT).show()
                }
                R.id.about -> {
                    Toast.makeText(this@MainActivity, "About", Toast.LENGTH_SHORT).show()
                }
                R.id.exit -> {
                    Toast.makeText(this@MainActivity, "Exit", Toast.LENGTH_SHORT).show()
                }
            }
            dlDrawer.closeDrawer(GravityCompat.START)
            true
        }
    }
}