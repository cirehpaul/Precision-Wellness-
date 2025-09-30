package com.example.fitness.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "daily_meals")
data class DailyMealSetEntity(
    @PrimaryKey(autoGenerate = true) val dailyMealsId: Long = 0,
    val mealName: String,
    val mealTime: String,
    val currentDate: String,
    val progressDay: String,//identifier for days counter
    val status: String, //DONE or ON-GOING
    val calories: Int,
    val protein: Int,
    val fat: Int,
    val carbs: Int,
    val mealsId: String = "",
    val accountId: Long = 0,
)