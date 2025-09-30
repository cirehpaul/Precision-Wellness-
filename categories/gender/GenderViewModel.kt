package com.example.fitness.ui.categories.gender

import androidx.lifecycle.ViewModel
import com.example.fitness.common.Constant
import com.example.fitness.domain.usecase.InsertGenderUseCase


class GenderViewModel(val insertGenderUseCase: InsertGenderUseCase) :ViewModel() {

    suspend fun saveGender(gender: String){
        val userId = Constant.userId.longValue
        insertGenderUseCase.invoke(userId = userId,gender = gender)
    }

}