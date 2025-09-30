package com.example.fitness.domain.usecase

import com.example.fitness.domain.repository.UserRepositoryImpL

class InsertBodyFatUseCase(private val userRepositoryImpL: UserRepositoryImpL){
    suspend operator fun invoke(userId: Long, bodyfat : String) {
        userRepositoryImpL.setBodyfat(userId, bodyfat)
    }
}
