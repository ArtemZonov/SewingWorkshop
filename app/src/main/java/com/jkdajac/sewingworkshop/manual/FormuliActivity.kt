package com.jkdajac.sewingworkshop.manual


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jkdajac.sewingworkshop.R
import com.jkdajac.sewingworkshop.manual.formuli_fragments.UbkaKlinievayaFragment
import com.jkdajac.sewingworkshop.manual.formuli_fragments.UbkaSolnceFragment
import kotlinx.android.synthetic.main.activity_formuli.*


class FormuliActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formuli)

        tvUbkaSolnce.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.flFormuli, UbkaSolnceFragment.newInstance("aa", "aaa"))
                .commit()
        }

        tvFormuliUbkaKlin.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.flFormuli, UbkaKlinievayaFragment.newInstance("aa", "aaa"))
                .commit()
        }

    }
}