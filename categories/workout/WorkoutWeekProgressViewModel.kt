package com.example.fitness.ui.categories.workout


import androidx.lifecycle.ViewModel
import com.example.fitness.domain.usecase.workout.GetWorkoutProgressUseCase
import com.example.fitness.domain.usecase.workout.InsertWorkoutProgressUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class WorkoutWeekProgressViewModel(private val getWorkoutProgressUseCase: GetWorkoutProgressUseCase,
                                   private val insertWorkoutProgressUseCase: InsertWorkoutProgressUseCase,
): ViewModel() {

    // Holds the UI state using MutableStateFlow for state management
    private val _uiState = MutableStateFlow(WorkoutIProgressUIState())
    val uiState: StateFlow<WorkoutIProgressUIState> = _uiState.asStateFlow()

    suspend fun getWorkoutWeekProgress(){
        val workoutProgressDto = getWorkoutProgressUseCase.invoke()

        //get the last updated workout progress and check the day count
        workoutProgressDto.lastOrNull()?.let {

                //get the last index
                _uiState.value = _uiState.value.copy(
                    workoutDayCount =  it.progressDayCount,
                    workoutWeekCount =  it.progressWeekCount
                )
        }
    }
}

// Data class to hold the UI state
data class WorkoutIProgressUIState(
    val workoutWeekCount: Int = 0,
    val workoutDayCount: Int = 0,
)