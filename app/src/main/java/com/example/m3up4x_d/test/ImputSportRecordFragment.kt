package com.example.m3up4x_d.test

import android.app.Fragment
import android.os.Bundle
import android.telephony.cdma.CdmaCellLocation
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.imput_sport_record_fragment_layout.*


class ImputSportRecordFragment : android.support.v4.app.Fragment, View.OnClickListener {



    constructor() : super()
   lateinit var editTextName: EditText
    lateinit var editTextLocation: EditText
    lateinit var editTextHours: EditText
    lateinit var editTextMinutes: EditText
    lateinit var editTextSeconds: EditText



    lateinit var dbReference: DatabaseReference


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.imput_sport_record_fragment_layout,container,false)

        dbReference = FirebaseDatabase.getInstance().getReference("sportRecord")

        val buttonSave: Button = view.findViewById(R.id.ButtonSaveISRFL)
        buttonSave.setOnClickListener(this)

        editTextName = view.findViewById(R.id.EditTextNameISRFL)
        editTextLocation = view.findViewById(R.id.EditTextLocationISRFL)
        editTextHours = view.findViewById(R.id.EditTextHoursISRFL)
        editTextMinutes = view.findViewById(R.id.EditTextMinutesISRFL)
        editTextSeconds = view.findViewById(R.id.EditTextSecondsISRFL)

        return view
    }


    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.ButtonSaveISRFL -> {


               val objectid = dbReference!!.push().key
               val sportRecordFirebase = SportRecordFirebase(objectid,editTextName.text.toString(),editTextLocation.text.toString(),editTextHours.text.toString().toInt(),editTextMinutes.text.toString().toInt(),editTextSeconds.text.toString().toInt())
               val sportRecord = SportRecord(SportRecordSQLite(),sportRecordFirebase)
               dbReference!!.child(objectid).setValue(sportRecord).addOnCompleteListener {
                    Toast.makeText(activity.applicationContext,"data saved",Toast.LENGTH_SHORT).show()
                }
            }

    }
    }


}




