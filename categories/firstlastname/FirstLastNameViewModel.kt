package com.example.fitness.ui.categories.firstlastname

import androidx.lifecycle.ViewModel
import com.example.fitness.common.Constant
import com.example.fitness.domain.usecase.InsertFirstLastNameUseCase

class FirstLastNameViewModel(private val insertFirstLastNameUseCase: InsertFirstLastNameUseCase) : ViewModel() {
    suspend fun saveNaming(firstname: String,lastname: String, age: String) {
        val userId = Constant.userId.longValue
        insertFirstLastNameUseCase.invoke(userId = userId, firstname = firstname, lastname = lastname, age = age)
    }
}




