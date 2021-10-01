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



                val field: Field =
                    Field(name = name, lastname = lastname, phonenumber = phonenumber, description = description)
                Toast.makeText(this,"field", Toast.LENGTH_LONG).show()
                fieldDatabase.fieldDao().insertField(field)
                val intent = Intent(this, ClientsActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this,"Заполните все поля", Toast.LENGTH_LONG).show()
            }
            finish()
        }

        }
    fun getMyIntents(){

        val i = intent

        if(i != null){
            if(i.getStringExtra(MyIntentConstants.I_NAME_KEY) != null){
                etName.setText(i.getStringExtra(MyIntentConstants.I_NAME_KEY))
            }
        }
    }

    }
