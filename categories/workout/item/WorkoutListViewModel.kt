package com.example.fitness.ui.categories.workout.item

import androidx.lifecycle.ViewModel
import com.example.fitness.common.Constant
import com.example.fitness.util.MyUtils
import com.example.fitness.domain.dto.DayContent
import com.example.fitness.domain.dto.Exercise
import com.example.fitness.domain.dto.WorkoutDto
import com.example.fitness.domain.dto.WorkoutItemDto
import com.example.fitness.domain.dto.toWorkoutEntity
import com.example.fitness.domain.usecase.workout.GetWorkoutItemsUseCase
import com.example.fitness.domain.usecase.workout.GetWorkoutProgressUseCase
import com.example.fitness.domain.usecase.workout.InsertWorkoutProgressUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// ViewModel to manage the UI state and business logic for Workout items
class WorkoutListViewModel(private val getWorkoutItemsUseCase: GetWorkoutItemsUseCase,
                           private val getWorkoutProgressUseCase: GetWorkoutProgressUseCase,
                           private val insertWorkoutProgressUseCase: InsertWorkoutProgressUseCase,
    ) : ViewModel() {

    // Holds the UI state using MutableStateFlow for state management
    private val _uiState = MutableStateFlow(WorkoutListUIState())
    val uiState: StateFlow<WorkoutListUIState> = _uiState.asStateFlow()

    //update the workout status
    fun updateWorkoutDone(workoutId: String){
        _uiState.value = _uiState.value.copy(
            workoutDayContent =  _uiState.value.workoutDayContent.copy(
                workouts = _uiState.value.workoutDayContent.workouts.map {
                    if(it.workoutId == workoutId){
                        it.copy(
                            hasCompleted = Constant.COMPLETED_STATUS
                        )
                    }else{
                        it
                    }
                }
            )
        )
    }

    // Fetches all workout items
    suspend fun getWorkoutAllList() {

            _uiState.value = _uiState.value.copy(
                workoutList = getWorkoutItemsUseCase().toMutableList()
            )

            //update dayContent
            val workoutDays = listOf(
                DayContent(  workouts = _uiState.value.workoutList.shuffled() ),
            )
            _uiState.value = _uiState.value.copy(
                workoutDayContent = workoutDays.firstOrNull() ?: DayContent()
            )
    }

    /**
     * This function called once the button DONE was click or the Day Workout was DONE
     * */
    suspend fun updateDoneProgressCount(){

        //get the progress data
        val workoutProgressDto = getWorkoutProgressUseCase.invoke()

        //get the last updated workout progress and check the day count
        workoutProgressDto.lastOrNull()?.let { workoutDto ->
            var workoutDayProgress = workoutDto.progressDayCount
            var workoutWeekProgress = workoutDto.progressWeekCount
            var workoutMonthProgress = workoutDto.progressMonthCount

            //calculate the days and week
            if((workoutDayProgress + 1) <= 7){
                workoutDayProgress += 1 //add to days only since less than 7 days
            }else{
                //week should be less than 4 weeks
                if( workoutWeekProgress + 1 < Constant.MAX_WEEK_COUNT){
                    workoutWeekProgress += 1
                    workoutDayProgress =  1 //reset to 1 since new week count
                }else{
                    workoutMonthProgress += 1 //add to Month progress
                }
            }

            // insert/populate to database the update
            val workout = WorkoutDto(
                workoutId = workoutDto.workoutId,
                progressDayCount = workoutDayProgress,
                progressWeekCount = workoutWeekProgress,
                progressMonthCount = workoutMonthProgress,
                progressDate = MyUtils.getTheCurrentDateTime(),
                accountId = Constant.userId.longValue,
            )

            insertWorkoutProgressUseCase.invoke(
                workout.toWorkoutEntity()
            )
        } ?: run {

            // insert new data if empty
            val workout = WorkoutDto(
                progressDayCount = 1,
                progressWeekCount = 0,
                progressMonthCount = 0,
                progressDate = MyUtils.getTheCurrentDateTime(),
                accountId = Constant.userId.longValue,
            )

            insertWorkoutProgressUseCase.invoke(
                workout.toWorkoutEntity()
            )
        }
    }
}

// Data class to hold the UI state
data class WorkoutListUIState(
    val workoutItemDto: WorkoutItemDto? = null,
    val workoutList: List<WorkoutItemDto> = emptyList(),
    val workoutDayContent: DayContent = DayContent(),
    val currentSetExercises: List<Exercise> = emptyList()  // Holds the exercises for the current set
)
