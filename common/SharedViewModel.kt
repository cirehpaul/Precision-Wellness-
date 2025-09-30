package com.example.fitness.ui.common

import androidx.lifecycle.ViewModel
import com.example.fitness.common.Constant
import com.example.fitness.common.Constant.DEFAULT_MEALS_PROGRESS_DAY_ID
import com.example.fitness.common.Constant.createMealsProgressDayID
import com.example.fitness.common.MealTime
import com.example.fitness.common.MealsStatus
import com.example.fitness.domain.dto.DailyMealSetDto
import com.example.fitness.domain.dto.MealsDto
import com.example.fitness.domain.dto.toDailyMealsSetEntity
import com.example.fitness.domain.usecase.meals.DeleteCurrentDayMealUseCase
import com.example.fitness.domain.usecase.meals.GetCurrentDayMealsUseCase
import com.example.fitness.domain.usecase.meals.GetMealsListUseCase
import com.example.fitness.domain.usecase.meals.GetMealsProgressUseCase
import com.example.fitness.domain.usecase.meals.InsertCurrentDayMealUseCase
import com.example.fitness.domain.usecase.meals.UpdateCurrentDayMealUseCase
import com.example.fitness.domain.usecase.workout.GetWorkoutProgressUseCase
import com.example.fitness.util.MyUtils
import com.example.fitness.util.MyUtils.sanitizeNumberString
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SharedViewModel(
    private val getWorkoutProgressUseCase: GetWorkoutProgressUseCase,
    private val getMealsProgressUseCase: GetMealsProgressUseCase,
    private val getMealsListUseCase: GetMealsListUseCase,
    private val getCurrentDayMealsUseCase: GetCurrentDayMealsUseCase,
    private val insertCurrentDayMealUseCase: InsertCurrentDayMealUseCase,
    private val updateCurrentDayMealUseCase: UpdateCurrentDayMealUseCase,
    private val deleteCurrentDayMealUseCase: DeleteCurrentDayMealUseCase,
) : ViewModel() {

    private val _sharedVMUIState = MutableStateFlow(SharedViewModelUIState())
    val sharedVMUIState: StateFlow<SharedViewModelUIState> = _sharedVMUIState.asStateFlow()
    //Add every current Day meal and it should show to the highlight menu for the currentDay -
    //this will be called on Login after successful login
    suspend fun setCurrentDayMeals(isLoadContentDoneCallback: () -> Unit){
        //sample counter it equals = "0/0/1" //month/week/day
        val mealsDayProgressCounter = getMealsProgressUseCase.invoke().lastOrNull()?.let {
            createMealsProgressDayID(
                it.mealsProgressMonthCount,
                it.mealsProgressWeekCount,
                it.mealsProgressDayCount)
        } ?: DEFAULT_MEALS_PROGRESS_DAY_ID //start value
       // if(Constant.cachedProgressDayID != mealsDayProgressCounter || Constant.cachedProgressDayID == DEFAULT_MEALS_PROGRESS_DAY_ID) {

            val mealsListUseCaseProgressDto = getMealsListUseCase.invoke()

            //cached previous progressID
            Constant.cachedProgressDayID = mealsDayProgressCounter

            val mealsListFromDB = getCurrentDayMealsUseCase.invoke(mealsDayProgressCounter)

            val mealForToday = mutableListOf<MealsDto>()

            //check if database is empty
            if (mealsListFromDB.isEmpty()) {
                //if the db is empty insert the menu for the day
                mealsListUseCaseProgressDto.shuffled().let { meals ->
                    val breakfastMeal =
                        meals.first { ml -> ml.mealTime == MealTime.BREAKFAST.label }
                    val lunchMeal = meals.first { ml -> ml.mealTime == MealTime.LUNCH.label }
                    val dinnerMeal = meals.first { ml -> ml.mealTime == MealTime.DINNER.label }

                    mealForToday.add(breakfastMeal.copy(mealsDayProgress = mealsDayProgressCounter))
                    mealForToday.add(lunchMeal.copy(mealsDayProgress = mealsDayProgressCounter))
                    mealForToday.add(dinnerMeal.copy(mealsDayProgress = mealsDayProgressCounter))

                    //insert the 3 meals data to database
                    mealForToday.forEach {
                        val dailyMealSet = DailyMealSetDto(
                            mealName = it.mealsName,
                            mealTime = it.mealTime,
                            progressDay = mealsDayProgressCounter,
                            currentDate = MyUtils.getTheCurrentDate(),
                            status = MealsStatus.ON_GOING.name,
                            calories = it.calories.sanitizeNumberString().toInt(),
                            protein = it.protein.sanitizeNumberString().toInt(),
                            fat = it.fats.sanitizeNumberString().toInt(),
                            carbs = it.carbs.sanitizeNumberString().toInt(),
                            mealsId = it.mealsId,//mealsID from enums list
                            accountId = Constant.userId.longValue,
                        ).toDailyMealsSetEntity()

                        //insert current daily meal database

                        insertCurrentDayMealUseCase.invoke(dailyMealSet)
                    }

                    _sharedVMUIState.value = _sharedVMUIState.value.copy(
                        mealsDay = mealForToday
                    )
                }
            } else {
                //if may current cache na sa database get from cache
                mealsListFromDB.let { meals ->

                    val cacheBreakfastMeal =
                        meals.first { ml -> ml.mealTime == MealTime.BREAKFAST.label }
                    val cacheLunchMeal = meals.first { ml -> ml.mealTime == MealTime.LUNCH.label }
                    val cacheDinnerMeal = meals.first { ml -> ml.mealTime == MealTime.DINNER.label }

                    //get more meal details from our list
                    val breakfastMeal =
                        mealsListUseCaseProgressDto.first { ml -> cacheBreakfastMeal.mealsId == ml.mealsId }
                    val lunchMeal =
                        mealsListUseCaseProgressDto.first { ml -> cacheLunchMeal.mealsId == ml.mealsId }
                    val dinnerMeal =
                        mealsListUseCaseProgressDto.first { ml -> cacheDinnerMeal.mealsId == ml.mealsId }

                    //set the current Daily Progress to MealsDto
                    mealForToday.add(
                        breakfastMeal.copy(
                            mealsStatusProgress = cacheBreakfastMeal.status,
                            mealsDayProgress = mealsDayProgressCounter
                        )
                    )
                    mealForToday.add(
                        lunchMeal.copy(
                            mealsStatusProgress = cacheLunchMeal.status,
                            mealsDayProgress = mealsDayProgressCounter
                        )
                    )
                    mealForToday.add(
                        dinnerMeal.copy(
                            mealsStatusProgress = cacheDinnerMeal.status,
                            mealsDayProgress = mealsDayProgressCounter
                        )
                    )

                    //populate details here
                    _sharedVMUIState.value = _sharedVMUIState.value.copy(
                        mealsDay = mealForToday
                    )
                }
            }

            //get the total values
            updateMealsCountIntake(mealForToday)

            //get meal display highlights
            getMealsWeekHighlights(mealsListUseCaseProgressDto)
 //       }

        //DONE LOADING CONTENT
        isLoadContentDoneCallback()
    }

    suspend fun setPreviousDayMeals(progressDayID: String, isLoadContentDoneCallback: () -> Unit){

        val mealsListFromDB = getCurrentDayMealsUseCase.invoke(progressDayID)
        val mealsListUseCaseProgressDto = getMealsListUseCase.invoke()

        val mealForToday = mutableListOf<MealsDto>()

        //check if database is empty
        //if may current cache na sa database get from cache
        mealsListFromDB.shuffled().let { meals ->

            val cacheBreakfastMeal = meals.first { ml -> ml.mealTime == MealTime.BREAKFAST.label && ml.progressDay == progressDayID }
            val cacheLunchMeal = meals.first { ml -> ml.mealTime == MealTime.LUNCH.label && ml.progressDay == progressDayID  }
            val cacheDinnerMeal = meals.first { ml -> ml.mealTime == MealTime.DINNER.label && ml.progressDay == progressDayID  }

            //get more meal details from our list
            val breakfastMeal =
                mealsListUseCaseProgressDto.first { ml -> cacheBreakfastMeal.mealsId == ml.mealsId }
            val lunchMeal =
                mealsListUseCaseProgressDto.first { ml -> cacheLunchMeal.mealsId == ml.mealsId }
            val dinnerMeal =
                mealsListUseCaseProgressDto.first { ml -> cacheDinnerMeal.mealsId == ml.mealsId }

            //set the current Daily Progress to MealsDto
            mealForToday.add(
                breakfastMeal.copy(
                    mealsStatusProgress = MealsStatus.DONE.name,
                    mealsDayProgress = progressDayID
                )
            )
            mealForToday.add(
                lunchMeal.copy(
                    mealsStatusProgress = MealsStatus.DONE.name,
                    mealsDayProgress = progressDayID
                )
            )
            mealForToday.add(
                dinnerMeal.copy(
                    mealsStatusProgress = MealsStatus.DONE.name,
                    mealsDayProgress = progressDayID
                )
            )

            //update current screen total count
            var totalCal = 0
            var totalProtein = 0
            var totalCarbs = 0
            var totalFats = 0

            meals.forEach {
                totalCal += it.calories
                totalProtein += it.protein
                totalCarbs += it.carbs
                totalFats += it.fat
            }

            //populate details here
            _sharedVMUIState.value = _sharedVMUIState.value.copy(
                totalCalories = totalCal.toString(),
                totalProtein = totalProtein.toString(),
                totalCarbs = totalCarbs.toString(),
                totalFats = totalFats.toString(),
                mealsDay = mealForToday
            )

        }



        //DONE LOADING CONTENT
        isLoadContentDoneCallback()
    }

    private fun getMealsWeekHighlights(mealsListUseCaseProgressDto: List<MealsDto>) {
        //get the menu highlight
        if(_sharedVMUIState.value.mealsWeekHighlights.isEmpty()) {
            if (Constant.mealHighlightCache.isEmpty()) {

                //Show only LUNCH highlights
                mealsListUseCaseProgressDto.shuffled()
                    .filter { it.mealTime == MealTime.LUNCH.label }.take(4).let { meals ->
                    //clear array
                    Constant.mealHighlightCache.clear()
                    Constant.mealHighlightCache.addAll(meals)

                    _sharedVMUIState.value = _sharedVMUIState.value.copy(
                        mealsWeekHighlights = Constant.mealHighlightCache.toList()
                            .sortedBy { it.mealsId }
                    )
                }
            } else {
                _sharedVMUIState.value = _sharedVMUIState.value.copy(
                    mealsWeekHighlights = Constant.mealHighlightCache
                )
            }
        }
    }

    //set the total values here
    private fun updateMealsCountIntake(meals: List<MealsDto>){
        var totalCal = 0
        var totalProtein = 0
        var totalCarbs = 0
        var totalFats = 0

        var currentCal = 0
        var currentProtein = 0
        var currentCarbs = 0
        var currentFats = 0
        meals.forEach {
            totalCal += it.calories.sanitizeNumberString().toInt()
            totalProtein += it.protein.sanitizeNumberString().toInt()
            totalCarbs += it.carbs.sanitizeNumberString().toInt()
            totalFats += it.fats.sanitizeNumberString().toInt()

            //set the progress content
            if(it.mealsStatusProgress == MealsStatus.DONE.name){
                currentCal += it.calories.sanitizeNumberString().toInt()
                currentProtein += it.protein.sanitizeNumberString().toInt()
                currentCarbs += it.carbs.sanitizeNumberString().toInt()
                currentFats += it.fats.sanitizeNumberString().toInt()
            }
        }
        //get the averageCalorieCount for today
        getTheAverageCalorieCountToday(
            totalCalories = totalCal,
            totalProtein = totalProtein,
            totalCarbs = totalCarbs,
            totalFats = totalFats,
            currentCalories = currentCal,
            currentProtein = currentProtein,
            currentCarbs = currentCarbs,
            currentFats = currentFats,
        )
    }
    private fun getTheAverageCalorieCountToday(
        totalCalories: Int,
        totalProtein: Int,
        totalCarbs: Int,
        totalFats: Int,
        currentCalories: Int,
        currentProtein: Int,
        currentCarbs: Int,
        currentFats: Int,
    ) {
        //show percentage
        _sharedVMUIState.value = _sharedVMUIState.value.copy(
            totalCalories = totalCalories.toString(),
            totalProtein = totalProtein.toString(),
            totalCarbs = totalCarbs.toString(),
            totalFats = totalFats.toString(),
            dashboardTotalCalories = totalCalories.toString(),
            dashboardTotalProtein = totalProtein.toString(),
            dashboardTotalCarbs = totalCarbs.toString(),
            dashboardTotalFats = totalFats.toString(),
            currentCalories = currentCalories.toString(),
            currentProtein = currentProtein.toString(),
            currentCarbs = currentCarbs.toString(),
            currentFats = currentFats.toString(),
            //percentage value for progress bar
            caloriesPercentageProgress = calculatePercentage(currentCalories, totalCalories),
            proteinPercentageProgress = calculatePercentage(currentProtein, totalProtein),
            carbsPercentageProgress = calculatePercentage(currentCarbs, totalCarbs),
            fatsPercentageProgress = calculatePercentage(currentFats, totalFats),
        )
    }

    private fun calculatePercentage(currentVal: Int, totalVal: Int): Float{
        return (currentVal.toFloat() / totalVal)
    }

    suspend fun deleteAllDailyMeals(){
        deleteCurrentDayMealUseCase.invoke()
    }

    suspend fun updateCurrentMealStatus(mealsId: String,
                                        mealsProgressDay: String,
                                        mealTime: String,
                                        mealsStatus: MealsStatus){
        updateCurrentDayMealUseCase.invoke(
            status = mealsStatus.name,
            mealsProgressDay = mealsProgressDay,
            accountId = Constant.userId.longValue,
            mealTime = mealTime,
            mealsId = mealsId
        )

        //update the UIState
        _sharedVMUIState.value = _sharedVMUIState.value.copy(
            mealsDay = _sharedVMUIState.value.mealsDay.map {
                if(it.mealsId == mealsId && it.mealsDayProgress == mealsProgressDay  &&
                    it.mealTime == mealTime){
                    //update UI status
                    it.copy(
                        mealsStatusProgress = mealsStatus.name
                    )
                }else{
                    it
                }
            }
        )

        //update Counter meals
        updateMealsCountIntake(
            _sharedVMUIState.value.mealsDay
        )
    }
}

/** Data class to hold the UI state */
data class SharedViewModelUIState(
    val caloriesPercentageProgress: Float = 0F,
    val carbsPercentageProgress: Float = 0F,
    val proteinPercentageProgress: Float = 0F,
    val fatsPercentageProgress: Float = 0F,
    val currentCalories: String? = null,
    val currentProtein: String? = null,
    val currentCarbs: String? = null,
    val currentFats: String? = null,
    val totalCalories: String? = null,
    val totalProtein: String? = null,
    val totalCarbs: String? = null,
    val totalFats: String? = null,
    val dashboardTotalCalories: String? = null,
    val dashboardTotalProtein: String? = null,
    val dashboardTotalCarbs: String? = null,
    val dashboardTotalFats: String? = null,
    val mealsDay: List<MealsDto> = emptyList(),
    val mealsWeekHighlights: List<MealsDto> = emptyList(),
)