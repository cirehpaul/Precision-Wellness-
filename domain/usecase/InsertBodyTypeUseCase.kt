package com.example.fitness.domain.usecase

import com.example.fitness.domain.repository.UserRepositoryImpL

class InsertBodyTypeUseCase(private val userRepositoryImpL: UserRepositoryImpL){
    suspend operator fun invoke(userId: Long, bodytype : String) {
        userRepositoryImpL.setBodytype(userId, bodytype)
    }
}

