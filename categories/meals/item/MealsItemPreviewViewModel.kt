package com.example.fitness.ui.categories.meals.item

import androidx.lifecycle.ViewModel
import com.example.fitness.common.Constant
import com.example.fitness.util.MyUtils
import com.example.fitness.domain.dto.MealsProgressDto
import com.example.fitness.domain.dto.toMealsEntity
import com.example.fitness.domain.usecase.meals.GetMealsListUseCase
import com.example.fitness.domain.usecase.meals.GetMealsProgressUseCase
import com.example.fitness.domain.usecase.meals.InsertMealsProgressUseCase

class MealsItemPreviewViewModel(private val getMealsProgressUseCase: GetMealsProgressUseCase,
                                private val getMealsListUseCase: GetMealsListUseCase,
                                private val insertMealsProgressUseCase: InsertMealsProgressUseCase,
                                ) : ViewModel() {

    /**
     * This function called once the button DONE was click or the Day Workout was DONE
     * */
    suspend fun updateDoneProgressCount(isUpdateProgressFinishCallback: (String) -> Unit){

        val mealProgressDto = getMealsProgressUseCase.invoke()
        var dayProgress = 0
        var weekProgress = 0
        var monthProgress = 0

        mealProgressDto.lastOrNull()?.let { meal ->
             dayProgress = meal.mealsProgressDayCount
             weekProgress = meal.mealsProgressWeekCount
             monthProgress = meal.mealsProgressMonthCount


            if((dayProgress + 1) <= 7){
                dayProgress += 1
            }else{

                if( weekProgress + 1 < Constant.MAX_WEEK_COUNT){
                    weekProgress += 1
                    dayProgress =  1
                }else{
                    monthProgress += 1
                }
            }

            val meals = MealsProgressDto(
                 mealsProgressDayCount = dayProgress,
                 mealsProgressWeekCount = weekProgress,
                 mealsProgressMonthCount = monthProgress,
                 mealsProgressDate = MyUtils.getTheCurrentDateTime(),
                 calories = 50,
                 protein = 50,
                 fat = 50,
                 carbs = 50,
                accountId = Constant.userId.longValue,
            )

            insertMealsProgressUseCase.invoke(
                meals.toMealsEntity()
            )
        } ?: run {

            val meals = MealsProgressDto(
                mealsProgressDayCount = 1,
                mealsProgressWeekCount = 0,
                mealsProgressMonthCount = 0,
                mealsProgressDate = MyUtils.getTheCurrentDateTime(),
                calories = 50,
                protein = 50,
                fat = 50,
                carbs = 50,
                accountId = Constant.userId.longValue,
            )

            insertMealsProgressUseCase.invoke(
                meals.toMealsEntity()
            )
        }

        //finish progress task and set new ID
        isUpdateProgressFinishCallback(
            Constant.createMealsProgressDayID(
                monthProgress,
                weekProgress,
                dayProgress
            )
        )
    }
}