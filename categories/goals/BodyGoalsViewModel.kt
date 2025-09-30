package com.example.fitness.ui.categories.goals

import androidx.lifecycle.ViewModel
import com.example.fitness.common.Constant
import com.example.fitness.domain.usecase.InsertBodyGoalsUseCase

class BodyGoalsViewModel(private val insertBodyGoalsUseCase: InsertBodyGoalsUseCase) : ViewModel() {
    suspend fun saveGoals(bodygoals: String) {
        val userId = Constant.userId.longValue
        insertBodyGoalsUseCase.invoke(userId = userId, bodygoals = bodygoals)
    }
}
