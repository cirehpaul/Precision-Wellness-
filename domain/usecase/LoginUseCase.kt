package com.example.fitness.domain.usecase

import com.example.fitness.common.Constant
import com.example.fitness.domain.dto.UserDetailsDto
import com.example.fitness.domain.dto.toUserDetailsDto
import com.example.fitness.domain.repository.UserRepositoryImpL

class LoginUseCase(private val userRepositoryImpL: UserRepositoryImpL) {
    suspend operator fun invoke(username: String, password: String): UserDetailsDto{
        return userRepositoryImpL.loginStream(username, password)?.toUserDetailsDto() ?: UserDetailsDto()
    }
}