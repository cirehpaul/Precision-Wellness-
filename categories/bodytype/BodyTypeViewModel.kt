package com.example.fitness.ui.categories.bodytype

import androidx.lifecycle.ViewModel
import com.example.fitness.common.Constant
import com.example.fitness.domain.usecase.InsertBodyTypeUseCase


class BodyTypeViewModel(private val insertBodyTypeUseCase: InsertBodyTypeUseCase) : ViewModel() {
    suspend fun saveBodytype(bodytype: String) {
        val userId = Constant.userId.longValue
        insertBodyTypeUseCase.invoke(userId = userId, bodytype = bodytype)
    }
}
