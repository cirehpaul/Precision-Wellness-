package com.example.fitness.domain.repository

import com.example.fitness.data.dao.WorkoutDao
import com.example.fitness.data.entity.WorkoutEntity
import com.example.fitness.data.repository.WorkoutRepository

class WorkoutRepositoryImpl(private val workoutDao: WorkoutDao): WorkoutRepository {

    override fun getWorkoutProgress(accountId: Long): List<WorkoutEntity>? {
       return workoutDao.getWorkoutProgress(accountId = accountId)
    }

    override suspend fun insertWorkoutProgress(workoutEntity: WorkoutEntity) {
        workoutDao.insert(workoutEntity = workoutEntity)
    }

}