package com.example.fitness.data.repository

import com.example.fitness.data.entity.MealsEntity


interface MealsRepository {
    /**
     * Retrieve workout from the given data source
     */
    fun getMealsProgress(accountId: Long): List<MealsEntity>?

   /**
     * Insert workout progress to database
     */
    suspend fun insertMealsProgress(workoutEntity: MealsEntity)


}