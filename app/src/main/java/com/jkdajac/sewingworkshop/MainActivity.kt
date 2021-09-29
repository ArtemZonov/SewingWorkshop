package com.jkdajac.sewingworkshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.jkdajac.sewingworkshop.clients.ClientsActivity
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
                    Toast.makeText(this@MainActivity, "Клиенты", Toast.LENGTH_SHORT).show()
                }
                R.id.templates -> {
                    Toast.makeText(this@MainActivity, "Шаблоны", Toast.LENGTH_SHORT).show()
                }
                R.id.manual -> {
                    val intent = Intent(this, ManualActivity ::class.java)
                    startActivity(intent)
                    Toast.makeText(this@MainActivity, "Справочник", Toast.LENGTH_SHORT).show()
                }
                R.id.settings -> {
                    Toast.makeText(this@MainActivity, "Настройки", Toast.LENGTH_SHORT).show()
                }
                R.id.about -> {
                    Toast.makeText(this@MainActivity, "О приложении", Toast.LENGTH_SHORT).show()
                }
                R.id.exit -> {
                    Toast.makeText(this@MainActivity, "Выход", Toast.LENGTH_SHORT).show()
                }
            }
            dlDrawer.closeDrawer(GravityCompat.START)
            true
        }

        
    }


}