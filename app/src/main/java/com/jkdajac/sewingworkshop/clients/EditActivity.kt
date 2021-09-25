package com.jkdajac.sewingworkshop.clients

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.jkdajac.sewingworkshop.R
import com.jkdajac.sewingworkshop.clients.database.MyDbManager
import com.jkdajac.sewingworkshop.clients.database.MyIntentConstants
import kotlinx.android.synthetic.main.activity_clients.*
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {

    val myDbManager = MyDbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)



        ivSaveData.setOnClickListener {

            val myName = etName.text.toString()
            val myLastName = etLastName.text.toString()
            val myPhonenumber = etPhoneNumber.text.toString()
            val myDescription = etDescription.text.toString()
            if(myName != "" && myLastName != "") {
                myDbManager.insertToDb(
                   myName, myLastName,myPhonenumber, myDescription)
            }
        }

    }

}