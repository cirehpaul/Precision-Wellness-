package com.example.fitness.domain.dto

import com.example.fitness.common.Constant.DEFAULT_MEALS_PROGRESS_DAY_ID
import com.example.fitness.common.MealsStatus


data class MealsDto(
    val mealsId: String,
    val imageRes: Int,
    val mealsName: String,
    val ingredients: String,
    val calories: String,
    val fats: String,
    val protein: String,
    val carbs: String,
    val mealTime: String,
    val mealsDayProgress: String = DEFAULT_MEALS_PROGRESS_DAY_ID,//0/0/0
    val mealsStatusProgress: String = MealsStatus.ON_GOING.name,//DONE or ON_GOING
) {


}


