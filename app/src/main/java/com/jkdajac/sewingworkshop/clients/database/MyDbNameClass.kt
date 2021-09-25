package com.jkdajac.sewingworkshop.clients.database

import android.provider.BaseColumns

object MyDbNameClass {

    const val TABLE_NAME = "my_table"
    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "MyClientsDb.db"
    const val COLUMN_NAME_NAME = "name"
    const val COLUMN_NAME_LASTNAME = "lastname"
    const val COLUMN_NAME_PHONENUMBER = "phonenumber"
    const val COLUMN_NAME_DESCRIPTION = "description"

    const val  CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY, " +
            "$COLUMN_NAME_NAME TEXT," +
            "$COLUMN_NAME_LASTNAME TEXT, " +
            "$COLUMN_NAME_PHONENUMBER TEXT, " +
            "$COLUMN_NAME_DESCRIPTION TEXT"

    const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"

}