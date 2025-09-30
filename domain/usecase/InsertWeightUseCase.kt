package com.example.fitness.domain.usecase

import com.example.fitness.domain.repository.UserRepositoryImpL

class InsertWeightUseCase (private val userRepositoryImpL: UserRepositoryImpL){
    suspend operator fun invoke(userId: Long, weight : String) {
        userRepositoryImpL.setWeight(userId, weight)
    }
}