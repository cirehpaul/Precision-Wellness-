package com.example.fitness.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fitness.data.entity.MealsEntity

@Dao
interface MealsDao{

    @Query("SELECT * FROM meals WHERE accountId = :accountId")
    fun getMealsProgress(accountId: Long): List<MealsEntity>?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(mealsEntity: MealsEntity)
}