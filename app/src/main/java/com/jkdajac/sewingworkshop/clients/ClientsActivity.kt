package com.jkdajac.sewingworkshop.clients

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.jkdajac.sewingworkshop.MainActivity
import com.jkdajac.sewingworkshop.R
import com.jkdajac.sewingworkshop.clients.database.MyDbManager
import com.jkdajac.sewingworkshop.clients.database.MyIntentConstants
import kotlinx.android.synthetic.main.activity_clients.*
import kotlinx.android.synthetic.main.activity_edit.*

class ClientsActivity : AppCompatActivity() {

    val clientsAdapter = ClientsAdapter(ArrayList(), this)
    //val myDbManager = MyDbManager(this)

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

            init()
             getMyIntents()

    }
    override fun onDestroy() {
        super.onDestroy()
        MyDbManager(this).closeDb()
    }

    override fun onResume() {
        super.onResume()
        MyDbManager(this).openDb()
       fillAdapter()
   }


    fun init(){
        rvKlients.adapter = clientsAdapter
        rvKlients.layoutManager = LinearLayoutManager(this)
    }

    fun fillAdapter(){
        clientsAdapter.updateAdapter(MyDbManager(this).readDbData())
    }

    fun getMyIntents(){
        val i = intent
        if(i.getStringExtra(MyIntentConstants.I_NAME_KEY) != null)

            etName.setText(i.getStringExtra(MyIntentConstants.I_NAME_KEY))
            etLastName.setText(i.getStringExtra(MyIntentConstants.I_LASTNAME_KEY))
            etPhoneNumber.setText(i.getStringExtra(MyIntentConstants.I_PHONENUMBER_KEY))
            etDescription.setText(i.getStringExtra(MyIntentConstants.I_DESCRIPTION_KEY))
    }
}