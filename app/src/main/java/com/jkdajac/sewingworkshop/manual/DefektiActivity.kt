package com.jkdajac.sewingworkshop.manual

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jkdajac.sewingworkshop.R
import com.jkdajac.sewingworkshop.manual.defekti_fragments.*
import kotlinx.android.synthetic.main.activity_defekti.*
import kotlinx.android.synthetic.main.activity_defekti.tvDefektiKlasifikacia
import kotlinx.android.synthetic.main.activity_manual.*

class DefektiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_defekti)

        tvDefektiKlasifikacia.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.flDefekti, KlasifikaciaFragment.newInstance("aa", "aaa"))
                .commit()
        }

        tvDefectiSilueti.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.flDefekti, NetochnostiFragment.newInstance("aa", "aaa"))
                .commit()
        }

        tvDefectiPlechi.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.flDefekti, PlechiFragment.newInstance("aa", "aaa"))
                .commit()
        }

        tvDefectiDvigenie.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.flDefekti, MoveFragment.newInstance("aa", "aaa"))
                .commit()
        }

        tvDefectiUbok.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.flDefekti, DefektiUbokFragment.newInstance("aa", "aaa"))
                .commit()
        }

    }
}