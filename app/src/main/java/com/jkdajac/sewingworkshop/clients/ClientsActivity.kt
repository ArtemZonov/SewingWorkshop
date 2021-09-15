package com.jkdajac.sewingworkshop.clients

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jkdajac.sewingworkshop.MainActivity
import com.jkdajac.sewingworkshop.R
import kotlinx.android.synthetic.main.activity_clients.*

class ClientsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clients)

        floatingNewKlient.setOnClickListener {
            val intent = Intent(this, EditActivity ::class.java)
            startActivity(intent)
        }
        ivBackKlients.setOnClickListener {
            val intent = Intent(this, MainActivity ::class.java)
            startActivity(intent)
            finish()
        }
    }
}