package com.jkdajac.sewingworkshop.clients.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class MyDbManager(val context : Context) {
    val myDbHelper = MyDbHelper(context)
    var db : SQLiteDatabase? = null

    fun openDb(){
        db = myDbHelper.writableDatabase
    }

    fun insertToDb(name : String, lastname : String, phonenumber : String, description : String){
        val values = ContentValues().apply {
            put(MyDbNameClass.COLUMN_NAME_NAME, name)
            put(MyDbNameClass.COLUMN_NAME_LASTNAME, lastname)
            put(MyDbNameClass.COLUMN_NAME_PHONENUMBER, phonenumber)
            put(MyDbNameClass.COLUMN_NAME_DESCRIPTION, description)
        }
        db?.insert(MyDbNameClass.TABLE_NAME, null, values)
    }
    fun readDbData() : ArrayList<ListItem>{
        val dataList = ArrayList<ListItem>()
         val cursor = db?.query(MyDbNameClass.TABLE_NAME, null, null, null,
             null, null, null)

        with(cursor){
            while (this?.moveToNext()!!){
                val dataName = cursor?.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_NAME))
                val dataLastName = cursor?.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_LASTNAME))
                val dataPhoneNumber = cursor?.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_PHONENUMBER))
                val dataDescription = cursor?.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_DESCRIPTION))
                val item = ListItem()
                item.name = dataName.toString()
                item.lastname = dataLastName.toString()
                item.phonenumber = dataPhoneNumber.toString()
                item.description = dataDescription.toString()

                dataList.add(item)
            }
        }
        cursor?.close()
        return  dataList
    }

    fun closeDb(){
        myDbHelper.close()
    }
}