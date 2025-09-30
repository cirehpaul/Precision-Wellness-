package com.example.fitness.domain.usecase

import com.example.fitness.domain.repository.UserRepositoryImpL

class InsertFirstLastNameUseCase(private val userRepositoryImpL: UserRepositoryImpL){
    suspend operator fun invoke(userId: Long, firstname: String, lastname: String, age: String) {
        userRepositoryImpL.setNaming(userId, firstname, lastname,age)
    }

 }
