package com.jkdajac.sewingworkshop.clients

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jkdajac.sewingworkshop.R
import com.jkdajac.sewingworkshop.clients.database.AppDatabase
import com.jkdajac.sewingworkshop.clients.database.Field
import com.jkdajac.sewingworkshop.clients.database.MyIntentConstants
import kotlinx.android.synthetic.main.activity_edit.*
import java.util.*


class EditActivity : AppCompatActivity() {

    lateinit var fieldDatabase: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        getMyIntents()

        fieldDatabase = AppDatabase.getDatabase(this)

        ivSaveData.setOnClickListener {

            if(etName.text.toString().isNotEmpty() && etLastName.text.toString().isNotEmpty() ) {
                val name: String = etName.text.toString()
                val lastname: String = etLastName.text.toString()
                val phonenumber: String = etPhoneNumber.text.toString()
                val description: String = etDescription.text.toString()
                val etDis: String = etDis.text.toString()
                val etOsh: String = etOsh.text.toString()
                val etOg1: String = etOg1.text.toString()
                val etOg2: String = etOg2.text.toString()
                val etOg3: String = etOg3.text.toString()
                val etOta: String = etOta.text.toString()
                val etOb: String = etOb.text.toString()
                val etDt_b: String = etDt_b.text.toString()
                val etSHg: String = etSHg.text.toString()
                val etSHg2: String = etSHg2.text.toString()
                val etSHs: String = etSHs.text.toString()
                val etSHp: String = etSHp.text.toString()
                val etDtp: String = etDtp.text.toString()
                val etDts: String = etDts.text.toString()
                val etVg: String = etVg.text.toString()
                val etCg: String = etCg.text.toString()
                val etVpkp: String = etVpkp.text.toString()
                val etVpks: String = etVpks.text.toString()
                val etVprz: String = etVprz.text.toString()
                val etDr: String = etDr.text.toString()
                val etOr: String = etOr.text.toString()
                val etOzap: String = etOzap.text.toString()
                val etDub: String = etDub.text.toString()
                val etDsp: String = etDsp.text.toString()
                val etDzb: String = etDzb.text.toString()
                val etDzz: String = etDzz.text.toString()
                val etDb: String = etDb.text.toString()
                val etVs: String = etVs.text.toString()
                val etObed: String = etObed.text.toString()
                val etDt_k: String = etDt_k.text.toString()
                val etSHk: String = etSHk.text.toString()
                val etSHn: String = etSHn.text.toString()



                val field =
                    Field(name = name, lastname = lastname, phonenumber = phonenumber, description = description,
                    etDis = etDis, etOsh = etOsh, etOg1 = etOg1, etOg2 = etOg2, etOg3 = etOg3, etOta = etOta, etOb = etOb,
                    etDt_b = etDt_b, etSHg = etSHg, etSHg2 = etSHg2, etSHs = etSHs, etSHp = etSHp,
                    etDtp = etDtp, etDts = etDts, etVg = etVg, etCg = etCg, etVpkp = etVpkp, etVpks = etVpks,
                    etVprz = etVprz, etDr = etDr, etOr = etOr, etOzap = etOzap, etDub = etDub, etDsp = etDsp,
                    etDzb = etDzb, etDzz = etDzz, etDb = etDb, etVs = etVs, etObed = etObed, etDt_k = etDt_k,
                    etSHk = etSHk, etSHn = etSHn)
                Toast.makeText(this,"Имя и фамилия заполнены!", Toast.LENGTH_LONG).show()
                fieldDatabase.fieldDao().insertField(field)
                val intent = Intent(this, ClientsActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this,"Заполните поля" + "\"Имя\"" + "и" + "\"Фамилия\"", Toast.LENGTH_LONG).show()
            }
            finish()
        }

        }
    fun getMyIntents(){

        val i = intent

        if(i != null){
            if(i.getStringExtra(MyIntentConstants.I_NAME_KEY) != null){
                etName.setText(i.getStringExtra(MyIntentConstants.I_NAME_KEY))
                etLastName.setText(i.getStringExtra(MyIntentConstants.I_LASTNAME_KEY))
                etPhoneNumber.setText(i.getStringExtra(MyIntentConstants.I_PHONENUMBER_KEY))
                etDescription.setText(i.getStringExtra(MyIntentConstants.I_DESCRIPTION_KEY))
                etDis.setText(i.getStringExtra(MyIntentConstants.I_ETDIS_KEY))
                etOsh.setText(i.getStringExtra(MyIntentConstants.I_ETOSH_KEY))
                etOg1.setText(i.getStringExtra(MyIntentConstants.I_ETOG1_KEY))
                etOg2.setText(i.getStringExtra(MyIntentConstants.I_ETOG2_KEY))
                etOg3.setText(i.getStringExtra(MyIntentConstants.I_ETOG3_KEY))
                etOta.setText(i.getStringExtra(MyIntentConstants.I_ETOTA_KEY))
                etOb.setText(i.getStringExtra(MyIntentConstants.I_ETOB_KEY))
                etDt_b.setText(i.getStringExtra(MyIntentConstants.I_ETDT_B_KEY))
                etSHg.setText(i.getStringExtra(MyIntentConstants.I_ETSHG_KEY))
                etSHg2.setText(i.getStringExtra(MyIntentConstants.I_ETSHG2_KEY))
                etSHs.setText(i.getStringExtra(MyIntentConstants.I_ETSHS_KEY))
                etSHp.setText(i.getStringExtra(MyIntentConstants.I_ETSHP_KEY))
                etDtp.setText(i.getStringExtra(MyIntentConstants.I_ETDTP_KEY))
                etDts.setText(i.getStringExtra(MyIntentConstants.I_ETDTS_KEY))
                etVg.setText(i.getStringExtra(MyIntentConstants.I_ETVG_KEY))
                etCg.setText(i.getStringExtra(MyIntentConstants.I_ETCG_KEY))
                etVpkp.setText(i.getStringExtra(MyIntentConstants.I_ETVPKP_KEY))
                etVpks.setText(i.getStringExtra(MyIntentConstants.I_ETVPKS_KEY))
                etVprz.setText(i.getStringExtra(MyIntentConstants.I_ETVPRZ_KEY))
                etDr.setText(i.getStringExtra(MyIntentConstants.I_ETDR_KEY))
                etOr.setText(i.getStringExtra(MyIntentConstants.I_ETOR_KEY))
                etOzap.setText(i.getStringExtra(MyIntentConstants.I_ETOZAP_KEY))
                etDub.setText(i.getStringExtra(MyIntentConstants.I_ETDUB_KEY))
                etDsp.setText(i.getStringExtra(MyIntentConstants.I_ETDSP_KEY))
                etDzb.setText(i.getStringExtra(MyIntentConstants.I_ETDZB_KEY))
                etDzz.setText(i.getStringExtra(MyIntentConstants.I_ETDZZ_KEY))
                etDb.setText(i.getStringExtra(MyIntentConstants.I_ETDB_KEY))
                etVs.setText(i.getStringExtra(MyIntentConstants.I_ETVS_KEY))
                etObed.setText(i.getStringExtra(MyIntentConstants.I_ETOBED_KEY))
                etDt_k.setText(i.getStringExtra(MyIntentConstants.I_ETDT_K_KEY))
                etSHk.setText(i.getStringExtra(MyIntentConstants.I_ETSHK_KEY))
                etSHn.setText(i.getStringExtra(MyIntentConstants.I_ETSHN_KEY))
            }
        }
    }

    }
