package com.example.fitness.ui.categories.height

import androidx.lifecycle.ViewModel
import com.example.fitness.common.Constant
import com.example.fitness.domain.usecase.InsertHeightUseCase

class HeightViewModel(private val insertHeightUseCase: InsertHeightUseCase) : ViewModel() {
    suspend fun saveHeight(height: String) {
        val userId = Constant.userId.longValue
        insertHeightUseCase.invoke(userId = userId, height = height)
    }
}


