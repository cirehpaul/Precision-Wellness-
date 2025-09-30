package com.example.fitness.domain.dto

import com.example.fitness.data.entity.DailyMealSetEntity
import com.example.fitness.data.entity.MealsEntity


data class DailyMealSetDto(
    val dailyMealsId: Long = 0,
    val mealName: String,
    val mealTime: String,
    val currentDate: String,
    val progressDay: String,
    val status: String, //DONE or ON-GOING
    val calories: Int,
    val protein: Int,
    val fat: Int,
    val carbs: Int,
    val mealsId: String,
    val accountId: Long,
)

//convert list of progress
fun List<DailyMealSetEntity>.toDailyMealsSetDto() = map {
    it.toDailyMealsSetDto()
}

fun DailyMealSetEntity.toDailyMealsSetDto() = DailyMealSetDto(
     dailyMealsId = dailyMealsId,
     mealName = mealName,
     mealTime = mealTime,
     currentDate = currentDate,
     progressDay = progressDay,
     status = status,
     calories = calories,
     protein = protein,
     fat = fat,
     carbs = carbs,
     mealsId = mealsId,
     accountId = accountId
)



fun DailyMealSetDto.toDailyMealsSetEntity() = DailyMealSetEntity(
    mealName = mealName,
    mealTime = mealTime,
    currentDate = currentDate,
    progressDay = progressDay,
    status = status,
    calories = calories,
    protein = protein,
    fat = fat,
    carbs = carbs,
    mealsId = mealsId,
    accountId = accountId
)