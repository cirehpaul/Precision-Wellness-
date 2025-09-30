package com.example.fitness.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fitness.data.dao.DailyMealSetDao
import com.example.fitness.data.dao.MealsDao
import com.example.fitness.data.dao.UserDao
import com.example.fitness.data.dao.WorkoutDao
import com.example.fitness.data.entity.DailyMealSetEntity
import com.example.fitness.data.entity.MealsEntity
import com.example.fitness.data.entity.UserEntity
import com.example.fitness.data.entity.WorkoutEntity

@Database(entities = [
    UserEntity::class,
    WorkoutEntity::class,
    MealsEntity:: class,
    DailyMealSetEntity:: class,
                     ], version = 1, exportSchema = false)
abstract class FitnessDb : RoomDatabase(){
    abstract fun UserDao(): UserDao
    abstract fun WorkoutDao(): WorkoutDao
    abstract fun MealsDao(): MealsDao

    abstract fun DailyMealSetDao(): DailyMealSetDao

    companion object{
        @Volatile
        private var Instance: FitnessDb? = null

        fun getDatabase(context: Context): FitnessDb {

            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, FitnessDb::class.java, "item_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}


