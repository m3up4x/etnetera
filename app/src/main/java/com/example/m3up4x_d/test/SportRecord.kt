package com.example.m3up4x_d.test

class SportRecord (val _sportRecordSQLite: SportRecordSQLite = SportRecordSQLite(), val _sportRecordFirebase: SportRecordFirebase = SportRecordFirebase()) {
    val sportRecordSQLite = _sportRecordSQLite
    val sportRecordFirebase = _sportRecordFirebase
    var timebool : Boolean = false

    init {
        if ((sportRecordSQLite.seconds == 0) and (sportRecordSQLite.minutes == 0) and (sportRecordSQLite.hours == 0)){
            timebool = true
        }
    }


    fun getName(): String {
        if (sportRecordSQLite.name == "") {
            return sportRecordFirebase.name
        }
        else{
            return sportRecordSQLite.name
        }
    }
    fun getLocation(): String {
        if (sportRecordSQLite.location == "") {
            return sportRecordFirebase.location
        }
        else{
            return sportRecordSQLite.location
        }
    }
    fun getHours(): Int {
        if (timebool) {
            return sportRecordFirebase.hours
        }
        else{
            return sportRecordSQLite.hours
        }
    }
    fun getMinutes(): Int {
        if (timebool) {
            return sportRecordFirebase.minutes
        }
        else{
            return sportRecordSQLite.minutes
        }
    }
    fun getSeconds(): Int {
        if ((timebool)) {
            return sportRecordFirebase.seconds
        }
        else{
            return sportRecordSQLite.seconds
        }
    }

}