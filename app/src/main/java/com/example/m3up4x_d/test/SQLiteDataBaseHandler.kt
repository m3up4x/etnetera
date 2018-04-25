package com.example.m3up4x_d.test

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast


val DATABASE_NAME = "MyDB"
val TABLE_NAME = "SportRecord"
val COL_NAME = "name"
val COL_LOCATION = "location"
val COL_HOURS = "hours"
val COL_MINUTES = "minutes"
val COL_SECONDS = "seconds"
val COL_ID = "id"

class SQLiteDataBaseHandler(var myContext: Context): SQLiteOpenHelper(myContext, DATABASE_NAME,null,1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_NAME + " VARCHAR(256)," + COL_LOCATION + " VARCHAR(256)," + COL_HOURS + " INTEGER" + COL_MINUTES + " INTEGER" + COL_SECONDS + " INTEGER) "

        p0?.execSQL(createTable)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertData(sportRecordSQLite: SportRecordSQLite) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COL_NAME,sportRecordSQLite.name)
        cv.put(COL_LOCATION,sportRecordSQLite.location)
        cv.put(COL_HOURS,sportRecordSQLite.hours)
        cv.put(COL_MINUTES,sportRecordSQLite.minutes)
        cv.put(COL_SECONDS,sportRecordSQLite.seconds)
        var resoult = db.insert(TABLE_NAME,null,cv)

        if (resoult == -1.toLong()) {
            Toast.makeText(myContext,"Data Save Failed",Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(myContext,"Data Saved",Toast.LENGTH_SHORT).show()
        }
    }

}