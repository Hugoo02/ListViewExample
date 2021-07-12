package com.example.listviewexample.Utils

import java.text.SimpleDateFormat
import java.util.*

class UtilFunctions {

    fun currentDate() : String {

        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())


        return currentDate.toString()

    }

    fun stringtoDate(date: String) : Calendar{

        val replaceDate = date.replace("T00:00:00.000Z", "")

        val calendar = Calendar.getInstance()

        calendar.time = SimpleDateFormat("yyyy-MM-dd").parse(replaceDate)

        return calendar

        //Calendar.DAY_OF_WEEK == day

    }

}