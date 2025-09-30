package com.example.fitness.domain.usecase.meals

import com.example.fitness.data.entity.DailyMealSetEntity
import com.example.fitness.domain.repository.DailyMealSetRepositoryImpl

class DeleteCurrentDayMealUseCase(private val dailyMealSetRepositoryImpl: DailyMealSetRepositoryImpl) {
    suspend operator fun invoke(){
        dailyMealSetRepositoryImpl.deleteAllDailyMeal()
    }
}