package com.jkdajac.sewingworkshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.jkdajac.sewingworkshop.clients.ClientsActivity
import com.jkdajac.sewingworkshop.clients.ClientsAdapter
import com.jkdajac.sewingworkshop.clients.database.MyDbManager
import com.jkdajac.sewingworkshop.manual.ManualActivity
import kotlinx.android.synthetic.main.activity_clients.*
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
                    val intent = Intent(this, ClientsActivity ::class.java)
                    startActivity(intent)
                    Toast.makeText(this@MainActivity, "Clients", Toast.LENGTH_SHORT).show()
                }
                R.id.templates -> {
                    Toast.makeText(this@MainActivity, "Templates", Toast.LENGTH_SHORT).show()
                }
                R.id.manual -> {
                    val intent = Intent(this, ManualActivity ::class.java)
                    startActivity(intent)
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