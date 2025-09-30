package com.example.fitness.domain.dto

class WorkoutListDto(
    val workoutId: String,
    val imageRes: Int,
    val workoutName: String,
    val workoutBodyType: String = "", //for BEGINNER, INTERMEDIATE, ADVANCE
    val workoutGender: String = "", //for MALE or FEMALE
    val workoutBodyFat: String = "", //for LEAN, ATHLETIC, NATURAL
    val reps: Int,
    val duration: Int, // in seconds

){



}

