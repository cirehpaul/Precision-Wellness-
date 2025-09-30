package com.example.fitness.domain.usecase

import com.example.fitness.domain.repository.UserRepositoryImpL

class InsertHeightUseCase (private val userRepositoryImpL: UserRepositoryImpL){
    suspend operator fun invoke(userId: Long, height: String) {
        userRepositoryImpL.setHeight(userId, height)
    }

}
