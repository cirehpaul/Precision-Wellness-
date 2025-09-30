package com.example.fitness.domain.dto

import com.example.fitness.data.entity.WorkoutEntity

class WorkoutDto(
    val workoutId: Long = 0L,
    val progressDayCount: Int = 0,
    val progressWeekCount: Int = 0,
    val progressMonthCount: Int = 0,
    val progressDate: String = "",
    val accountId: Long = 0
)

//convert list of progress
fun List<WorkoutEntity>.toWorkoutDtoList() = map {
    it.toWorkoutDto()
}


fun WorkoutEntity.toWorkoutDto(): WorkoutDto = WorkoutDto(
     workoutId = workoutId,
    progressDayCount = progressDayCount,
    progressWeekCount = progressWeekCount,
    progressMonthCount = progressMonthCount,
     progressDate = progressDate,
     accountId = accountId
)

fun WorkoutDto.toWorkoutEntity(): WorkoutEntity = WorkoutEntity(
    //no workoutId since this id was auto incremented by the database
    progressDayCount = progressDayCount,
    progressWeekCount = progressWeekCount,
    progressMonthCount = progressMonthCount,
    progressDate = progressDate,
    accountId = accountId
)
