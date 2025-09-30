package com.example.fitness.ui.categories.weight

import androidx.lifecycle.ViewModel
import com.example.fitness.common.Constant
import com.example.fitness.domain.usecase.InsertHeightUseCase
import com.example.fitness.domain.usecase.InsertWeightUseCase

class WeightViewModel(private val insertWeightUseCase: InsertWeightUseCase) : ViewModel() {
    suspend fun saveWeight(weight: String) {
        val userId = Constant.userId.longValue
        insertWeightUseCase.invoke(userId = userId, weight = weight)
    }
}
