package com.example.fitness.domain.usecase.meals

import com.example.fitness.common.Constant
import com.example.fitness.domain.dto.DailyMealSetDto
import com.example.fitness.domain.dto.toDailyMealsSetDto
import com.example.fitness.domain.repository.DailyMealSetRepositoryImpl
import com.example.fitness.util.MyUtils

class GetCurrentDayMealsUseCase(private val dailyMealSetRepositoryImpl: DailyMealSetRepositoryImpl) {
    suspend operator fun invoke(progressDay: String): List<DailyMealSetDto>{
        return dailyMealSetRepositoryImpl.getCurrentDayMeal(
                accountId = Constant.userId.longValue,
                progressDay = progressDay,
            )?.toDailyMealsSetDto() ?: emptyList()
    }
}