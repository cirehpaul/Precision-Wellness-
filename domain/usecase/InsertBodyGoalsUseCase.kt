package com.example.fitness.domain.usecase

import com.example.fitness.domain.repository.UserRepositoryImpL

class InsertBodyGoalsUseCase (private val userRepositoryImpL: UserRepositoryImpL){
    suspend operator fun invoke(userId: Long, bodygoals : String) {
        userRepositoryImpL.setBodygoals(userId, bodygoals)
    }
}
