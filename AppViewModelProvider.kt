package com.example.fitness.ui

import ProfileViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.fitness.ui.categories.bodyfat.BodyFatViewModel
import com.example.fitness.ui.categories.bodytype.BodyTypeViewModel
import com.example.fitness.ui.categories.firstlastname.FirstLastNameViewModel
import com.example.fitness.ui.categories.gender.GenderViewModel
import com.example.fitness.ui.categories.goals.BodyGoalsViewModel
import com.example.fitness.ui.categories.height.HeightViewModel
import com.example.fitness.ui.categories.meals.MealsWeekProgressViewModel
import com.example.fitness.ui.categories.meals.item.MealsItemPreviewViewModel
import com.example.fitness.ui.categories.weight.WeightViewModel
import com.example.fitness.ui.categories.workout.WorkoutWeekProgressViewModel
import com.example.fitness.ui.categories.workout.item.WorkoutListViewModel
import com.example.fitness.ui.common.SharedViewModel
import com.example.fitness.ui.login.LoginViewModel
import com.example.fitness.ui.signup.RegisterViewModel

/**
 * Provides Factory to create instance of ViewModel for the entire Inventory app
 */
object AppViewModelProvider {
    val Factory = viewModelFactory {
        // Initializer for LoginViewModel
        initializer {
            LoginViewModel(
                fitnessApplication().container.loginUseCase
            )
        }

        // Initializer for RegisterViewModel
        initializer {
            RegisterViewModel(
                fitnessApplication().container.registerUseCase
            )
        }


        // Initializer for Gender Selection
        initializer {
            GenderViewModel(
                fitnessApplication().container.insertGenderUseCase
            )
        }
        // Initializer for Height
        initializer {
            HeightViewModel(
                fitnessApplication().container.insertHeightUseCase
            )
        }
        // Initializer for Weight
        initializer {
            WeightViewModel(
                fitnessApplication().container.insertWeightUseCase
            )
        }
        // Initializer for Bodytype
        initializer {
            BodyTypeViewModel(
                fitnessApplication().container.insertBodyTypeUseCase
            )
        }
        // Initializer for Bodyfat
        initializer {
            BodyFatViewModel(
                fitnessApplication().container.insertBodyFatUseCase
            )
        }
        // Initializer for Bodyfat
        initializer {
            BodyFatViewModel(
                fitnessApplication().container.insertBodyFatUseCase
            )
        }
        // Initializer for Bodyfat
        initializer {
            BodyGoalsViewModel(
                fitnessApplication().container.insertBodyGoalsUseCase
            )
        }
        // Initializer for First and Last name also the age
        initializer {
            FirstLastNameViewModel(
                fitnessApplication().container.insertFirstLastNameUseCase
            )
        }
        // Initializer for Profile Screen and Update the Profile Screen
        initializer {
            ProfileViewModel(
                getUserProfileUseCase = fitnessApplication().container.getUserProfileUseCase,
                updateUserProfileUseCase = fitnessApplication().container.updateUserProfileUseCase
            )
        }
        // Initializer for Workout List Day Content ViewModel
        initializer {
            WorkoutListViewModel(
                getWorkoutItemsUseCase = fitnessApplication().container.getWorkoutItemsUseCase,
                getWorkoutProgressUseCase = fitnessApplication().container.getWorkoutProgressUseCase,
                insertWorkoutProgressUseCase = fitnessApplication().container.insertWorkoutProgressUseCase,
            )
        }

        // Initializer for Workout Progress screen
        initializer {
            WorkoutWeekProgressViewModel(
                getWorkoutProgressUseCase = fitnessApplication().container.getWorkoutProgressUseCase,
                insertWorkoutProgressUseCase = fitnessApplication().container.insertWorkoutProgressUseCase,
            )
        }
        // Initializer for Meals screen
        initializer {
            MealsWeekProgressViewModel(
                getMealsProgressUseCase = fitnessApplication().container.getMealsProgressUseCase,
                getMealsListUseCase = fitnessApplication().container.getMealsListUseCase,
            )
        }

        initializer {
            MealsItemPreviewViewModel(
                getMealsProgressUseCase = fitnessApplication().container.getMealsProgressUseCase,
                getMealsListUseCase = fitnessApplication().container.getMealsListUseCase,
                insertMealsProgressUseCase = fitnessApplication().container.insertMealsProgressUseCase,
            )
        }

        //sharedVMs
        // Initializer for Meals screen
        initializer {
            SharedViewModel(
                getWorkoutProgressUseCase = fitnessApplication().container.getWorkoutProgressUseCase,
                getMealsProgressUseCase = fitnessApplication().container.getMealsProgressUseCase,
                getMealsListUseCase = fitnessApplication().container.getMealsListUseCase,
                getCurrentDayMealsUseCase = fitnessApplication().container.getCurrentDayMealsUseCase,
                insertCurrentDayMealUseCase = fitnessApplication().container.insertCurrentDayMealUseCase,
                updateCurrentDayMealUseCase = fitnessApplication().container.updateCurrentDayMealUseCase,
                deleteCurrentDayMealUseCase = fitnessApplication().container.deleteCurrentDayMealsUseCase,
            )
        }

    }
}

/**
 * Extension function to queries for [Application] object and returns an instance of
 * [FitnessApplication].
 */
fun CreationExtras.fitnessApplication(): FitnessApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as FitnessApplication)
