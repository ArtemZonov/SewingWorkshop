package com.jkdajac.sewingworkshop.tamplates

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jkdajac.sewingworkshop.R
import com.jkdajac.sewingworkshop.manual.defekti_fragments.KlasifikaciaFragment
import kotlinx.android.synthetic.main.activity_tamplates.*

class TamplatesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tamplates)
        tvDress.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.flTemplates, DressFragment.newInstance("aa", "aaa"))
                .commit()
        }

        tvSkirt.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.flTemplates, SkirtFragment.newInstance("aa", "aaa"))
                .commit()
        }

        tvTrousers.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.flTemplates, TrousersFragment.newInstance("aa", "aaa"))
                .commit()
        }

        tvSleeves.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.flTemplates, SleevesFragment.newInstance("aa", "aaa"))
                .commit()
        }
    }
}