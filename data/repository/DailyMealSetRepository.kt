package com.example.fitness.data.repository

import com.example.fitness.data.entity.DailyMealSetEntity


interface DailyMealSetRepository {
    /**
     * Retrieve data from the given data source
     */
    fun getCurrentDayMeal(progressDay: String, accountId: Long): List<DailyMealSetEntity>?

   /**
     * Insert current Day meal to database
     */
    suspend fun insertCurrentDayMeal(dailyMealSetEntity: DailyMealSetEntity)

    suspend fun updateMealStatus(status: String, currentDate: String, accountId: Long, mealTime: String, mealsId: String)

    suspend fun deleteAllDailyMeal()

}