package com.example.listviewexample.Utils

import java.text.SimpleDateFormat
import java.util.*

class UtilFunctions {

    fun currentDate() : String {

        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())


        return currentDate.toString()

    }

}