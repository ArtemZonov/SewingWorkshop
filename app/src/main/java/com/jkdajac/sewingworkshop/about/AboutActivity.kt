package com.jkdajac.sewingworkshop.about

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jkdajac.sewingworkshop.R
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        ivBackAuthor.setOnClickListener {
            finish()
        }
    }
}