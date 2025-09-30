package com.example.fitness.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "workout")
data class WorkoutEntity (
    @PrimaryKey(autoGenerate = true)
        val workoutId: Long = 0,
        val progressDayCount: Int,
        val progressWeekCount: Int,
        val progressMonthCount: Int,
        val progressDate: String,
        val accountId: Long = 0
)