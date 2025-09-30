package com.example.fitness.data.repository

import com.example.fitness.data.entity.UserEntity
import com.example.fitness.data.entity.WorkoutEntity

interface WorkoutRepository {
    /**
     * Retrieve workout from the given data source
     */
    fun getWorkoutProgress(accountId: Long): List<WorkoutEntity>?

    /**
     * Insert workout progress to database
     */
    suspend fun insertWorkoutProgress(workoutEntity: WorkoutEntity)


}