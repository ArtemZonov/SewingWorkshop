package com.jkdajac.sewingworkshop.clients.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Field (
    var name : String,
    var lastname : String,
    val phonenumber : String,
    val description : String,
    val etDis : String,
    val etOsh : String,
    val etOg1 : String,
    val etOg2 : String,
    val etOg3 : String,
    val etOta : String,
    val etOb : String,
    val etDt_b : String,
    val etSHg : String,
    val etSHg2 : String,
    val etSHs : String,
    val etSHp : String,
    val etDtp : String,
    val etDts : String,
    val etVg : String,
    val etCg : String,
    val etVpkp : String,
    val etVpks : String,
    val etVprz : String,
    val etDr : String,
    val etOr : String,
    val etOzap : String,
    val etDub : String,
    val etDsp : String,
    val etDzb : String,
    val etDzz : String,
    val etDb : String,
    val etVs : String,
    val etObed : String,
    val etDt_k : String,
    val etSHk : String,
    val etSHn : String
        )
{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}