package com.example.fitness.ui.categories.bodyfat

import androidx.lifecycle.ViewModel
import com.example.fitness.common.Constant
import com.example.fitness.domain.usecase.InsertBodyFatUseCase


class BodyFatViewModel(private val InsertBodyFatUseCase: InsertBodyFatUseCase) : ViewModel() {
    suspend fun saveBodyFat(bodyfat: String) {
        val userId = Constant.userId.longValue
        InsertBodyFatUseCase.invoke(userId = userId, bodyfat = bodyfat)
    }
}
