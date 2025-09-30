package com.example.fitness.domain.repository

import com.example.fitness.data.dao.MealsDao
import com.example.fitness.data.entity.MealsEntity
import com.example.fitness.data.repository.MealsRepository


class MealsRepositoryImpl(private val mealsDao: MealsDao): MealsRepository {
    override fun getMealsProgress(accountId: Long): List<MealsEntity>? {
       return mealsDao.getMealsProgress(accountId)
    }

    override suspend fun insertMealsProgress(mealsEntity: MealsEntity) {
       return mealsDao.insert(mealsEntity = mealsEntity)
    }


}