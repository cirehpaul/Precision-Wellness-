package com.example.fitness.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meals")
data class MealsEntity(
    @PrimaryKey(autoGenerate = true) val mealsId: Long = 0,
    val mealsProgressDayCount: Int,
    val mealsProgressWeekCount: Int,
    val mealsProgressMonthCount: Int,
    val mealsProgressDate: String,
    val calories: Int,
    val protein: Int,
    val fat: Int,
    val carbs: Int,
    val accountId: Long = 0
)