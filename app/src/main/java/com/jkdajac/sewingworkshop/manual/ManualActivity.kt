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

        tvDefekti.setOnClickListener {
            val intent = Intent(this@ManualActivity, DefektiActivity :: class.java)
            startActivity(intent)
        }

        tvFormuli.setOnClickListener {
            val intent = Intent(this@ManualActivity, FormuliActivity :: class.java)
            startActivity(intent)
        }
        tvPoriadokSniatiaMerok.setOnClickListener {
            val intent = Intent(this@ManualActivity, MerkiActivity :: class.java)
            startActivity(intent)
        }

        tvRashodTkanei.setOnClickListener {
            val intent = Intent(this@ManualActivity, RashodTkaneiActivity :: class.java)
            startActivity(intent)
        }

    }
}