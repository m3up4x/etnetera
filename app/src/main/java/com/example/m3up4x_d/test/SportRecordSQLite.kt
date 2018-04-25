package com.example.m3up4x_d.test

class SportRecordSQLite(val idSQLiteID:Int,val id:String,val name: String, val location: String, val hours: Int,val minutes:Int,val seconds:Int) {
    constructor(): this(0,"","","",0,0,0){}
}