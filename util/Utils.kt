package com.example.fitness.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object MyUtils {

    //Get the current Date Time of the finish workout
    fun getTheCurrentDateTime(): String{
        val currentDate = Date()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val formattedDate = dateFormat.format(currentDate)
        return formattedDate
    }

    fun getTheCurrentDate(): String{
        val currentDate = Date()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
        val formattedDate = dateFormat.format(currentDate)
        return formattedDate
    }

    //remove non-numerical characters
    fun String.sanitizeNumberString() = this.lowercase(Locale.getDefault())
        .replace(Regex("[^0-9]"), "")
}