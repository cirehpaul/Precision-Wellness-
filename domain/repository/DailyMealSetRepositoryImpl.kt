package com.example.fitness.domain.repository

import com.example.fitness.data.dao.DailyMealSetDao
import com.example.fitness.data.dao.MealsDao
import com.example.fitness.data.entity.DailyMealSetEntity
import com.example.fitness.data.entity.MealsEntity
import com.example.fitness.data.repository.DailyMealSetRepository
import com.example.fitness.data.repository.MealsRepository


class DailyMealSetRepositoryImpl(private val dailyMealSetDao: DailyMealSetDao): DailyMealSetRepository {
    override fun getCurrentDayMeal(
        progressDay: String,
        accountId: Long
    ): List<DailyMealSetEntity>? {
        return dailyMealSetDao.getCurrentDayMeal(progressDay = progressDay, accountId = accountId)
    }

    override suspend fun insertCurrentDayMeal(dailyMealSetEntity: DailyMealSetEntity) {
        return dailyMealSetDao.insert(dailyMealSetEntity)
    }

    override suspend fun updateMealStatus(
        status: String,
        mealsProgressDay: String,
        accountId: Long,
        mealTime: String,
        mealsId: String
    ) {
       return dailyMealSetDao.updateMealStatus(status = status,
           progressDay = mealsProgressDay,
           accountId = accountId,
           mealTime = mealTime,
           mealsId = mealsId
           )
    }

    override suspend fun deleteAllDailyMeal() {
        return dailyMealSetDao.deleteALlDailyMeal()
    }


}