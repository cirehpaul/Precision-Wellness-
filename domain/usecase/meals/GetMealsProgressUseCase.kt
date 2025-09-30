package com.example.fitness.domain.usecase.meals

import com.example.fitness.common.Constant
import com.example.fitness.domain.dto.MealsProgressDto
import com.example.fitness.domain.dto.toMealsProgressListDto
import com.example.fitness.domain.repository.MealsRepositoryImpl

class GetMealsProgressUseCase(private val mealsRepositoryImpl: MealsRepositoryImpl) {
    suspend operator fun invoke(): List<MealsProgressDto>{
        return mealsRepositoryImpl.getMealsProgress(accountId = Constant.userId.longValue)?.toMealsProgressListDto() ?: emptyList()
    }
}