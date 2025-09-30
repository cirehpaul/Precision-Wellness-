package com.example.fitness.domain.dto

import com.example.fitness.data.entity.MealsEntity

class MealsProgressDto(
    val mealsId: String = "",
    val mealsProgressDayCount: Int,
    val mealsProgressWeekCount: Int,
    val mealsProgressMonthCount: Int,
    val mealsProgressDate: String,
    val calories: Int,
    val protein: Int,
    val fat: Int,
    val carbs: Int,
    val accountId: Long = 0
)


//convert list of progress
fun List<MealsEntity>.toMealsProgressListDto() = map {
    it.toMealsProgressDto()
}

fun MealsEntity.toMealsProgressDto(): MealsProgressDto = MealsProgressDto(
    mealsId = mealsId.toString(),
    mealsProgressDayCount = mealsProgressDayCount,
    mealsProgressWeekCount = mealsProgressWeekCount,
    mealsProgressMonthCount = mealsProgressMonthCount,
    mealsProgressDate = mealsProgressDate,
    calories = calories,
    protein = protein,
    fat = fat,
    carbs = carbs,
    accountId = accountId
)

fun MealsProgressDto.toMealsEntity(): MealsEntity = MealsEntity(
    //no mealsId since this id was auto incremented by the database
    mealsProgressDayCount = mealsProgressDayCount,
    mealsProgressWeekCount = mealsProgressWeekCount,
    mealsProgressMonthCount = mealsProgressMonthCount,
    mealsProgressDate = mealsProgressDate,
    calories = calories,
    protein = protein,
    fat = fat,
    carbs = carbs,
    accountId = accountId
)
