package com.example.m3up4x_d.test

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ListViewAdapter(val myContext: Context,val layoutResID:Int,val SportRecordList: List<SportRecord> ) : ArrayAdapter<SportRecord>(myContext,layoutResID,SportRecordList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layoutInflater:LayoutInflater = LayoutInflater.from(myContext)
        val view: View = layoutInflater.inflate(layoutResID,null)
        val textviewName = view.findViewById<TextView>(R.id.TextViewNameLVI)
        val sportRecord = SportRecordList[position]
        textviewName.text = sportRecord.name
        return view;
    }
}