package com.example.fitness.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fitness.data.entity.DailyMealSetEntity
import com.example.fitness.data.entity.MealsEntity

@Dao
interface DailyMealSetDao{

    @Query("SELECT * FROM daily_meals WHERE progressDay = :progressDay AND accountId = :accountId")
    fun getCurrentDayMeal(progressDay: String, accountId: Long): List<DailyMealSetEntity>?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(dailyMealSetEntity: DailyMealSetEntity)

    @Query("UPDATE daily_meals SET status = :status WHERE mealsId = :mealsId AND progressDay = :progressDay AND accountId = :accountId AND mealTime = :mealTime")
    fun updateMealStatus(status: String, mealsId: String, progressDay: String, accountId: Long, mealTime: String)

    @Query("DELETE FROM daily_meals")
    fun deleteALlDailyMeal()

}