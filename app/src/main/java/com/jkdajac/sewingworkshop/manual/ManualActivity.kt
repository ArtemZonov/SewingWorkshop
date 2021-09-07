package com.jkdajac.sewingworkshop.manual

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jkdajac.sewingworkshop.R
import kotlinx.android.synthetic.main.activity_manual.*

class ManualActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manual)

        tvPribavki.setOnClickListener {
            val intent = Intent(this@ManualActivity, PribavkiActivity :: class.java)
            startActivity(intent)
        }

    }
}