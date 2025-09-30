package com.example.fitness.common

import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import com.example.fitness.domain.dto.MealsDto

object Constant {
    var isLogin = mutableStateOf(false) // false is default bypass muna
    var isShowBottomNav = mutableStateOf(false) // false is default bypass muna
    var userId = mutableLongStateOf(0L)
    var getgender = mutableStateOf(Gender.MALE)

    var bodyTypeCategory = BodyType.BEGINNER.name

    var cachedProgressDayID = "0/0/0"

    //cache menu highlight
    val mealHighlightCache = mutableListOf<MealsDto>()

    const val NO_MEAL_HIGHLIGHT_ID = "@NO_MEAL_HIGHLIGHT_ID@"
    const val COMPLETED_STATUS = "COMPLETED"
    const val MAX_WEEK_COUNT = 4

    const val DEFAULT_MEALS_PROGRESS_DAY_ID = "0/0/0"
    fun createMealsProgressDayID(
        month: Int?,
        week: Int?,
        day: Int?
    ): String{
       return "${month}/${week}/${day}"
    }

    //for logout purposes
    fun logoutReset(){
        userId.longValue = 0L
        isLogin.value = false
        isShowBottomNav.value = false
    }
}