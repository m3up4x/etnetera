package com.example.m3up4x_d.test

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import com.google.firebase.database.*
import kotlinx.android.synthetic.*

class ViewSportRecordsFragment : android.support.v4.app.Fragment,View.OnClickListener {
    constructor() : super()

    lateinit var dbReference: DatabaseReference
    lateinit var sportRecordList: MutableList<SportRecordFirebase>
    lateinit var listview: ListView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.view_sport_records_fragment_layout,container,false)

        dbReference = FirebaseDatabase.getInstance().getReference("sportRecord")

        val buttonSave: Button = view.findViewById(R.id.ButtonRefreshVSRFL)
        buttonSave.setOnClickListener(this)

        sportRecordList = mutableListOf()

        listview = view.findViewById(R.id.ListViewVSRFL)

        return view
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.ButtonRefreshVSRFL -> {
                dbReference.addListenerForSingleValueEvent(object : ValueEventListener{
                    override fun onCancelled(p0: DatabaseError?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onDataChange(p0: DataSnapshot?) {
                        if (p0!!.exists()){
                            sportRecordList.clear()
                            for (h in p0.children){
                                sportRecordList.add(h.getValue(SportRecordFirebase::class.java)!!)
                            }
                        }
                        listview.adapter = ListViewAdapter(activity.applicationContext,R.layout.list_view_item,sportRecordList)
                    }
                }
                )
            }
        }
    }
}