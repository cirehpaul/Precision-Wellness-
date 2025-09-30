package com.example.fitness.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.fitness.data.entity.UserEntity
import com.example.fitness.data.entity.WorkoutEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface WorkoutDao {

    @Query("SELECT * FROM workout WHERE accountId = :accountId")
    fun getWorkoutProgress(accountId: Long): List<WorkoutEntity>?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(workoutEntity: WorkoutEntity)
}
