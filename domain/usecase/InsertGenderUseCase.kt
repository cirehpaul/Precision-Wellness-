package com.example.fitness.domain.usecase


import com.example.fitness.domain.repository.UserRepositoryImpL

class InsertGenderUseCase(private val userRepositoryImpL: UserRepositoryImpL){
    suspend operator fun invoke(userId: Long, gender: String) {
        userRepositoryImpL.setGender(userId, gender)
    }
}