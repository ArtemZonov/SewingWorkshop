package com.jkdajac.sewingworkshop.clients.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Field (
    val name : String,
    val lastname : String,
    val phonenumber : String,
    val description : String
        )
{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}