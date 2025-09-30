package com.example.fitness.domain.dto

import android.os.Parcel
import android.os.Parcelable

data class WorkoutItemDto(
    val workoutId: String,
    val imageRes: Int,
    val workoutName: String,
    val hasCompleted: String = "",
    val reps: Int,
    val duration: Int,
)

// Exercise model (add your properties here)
data class Exercise(
    val exerciseId: String,
    val name: String,
    val duration: Int
)

// Represents a day with rest and workout items
data class DayContent(
    val isRestDay: Boolean = false,
    val workouts: List<WorkoutItemDto> = emptyList()
)
