package com.example.fitnesstracker.ui.navigation

import Hamburger
import MealsItemPreviewScreen
import ProfileScreen
import com.example.fitness.ui.categories.workout.WorkoutWeekProgressScreen
import WeightScreen
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.fitness.ui.AppViewModelProvider
import com.example.fitness.ui.categories.aboutus.AboutUsScreen
import com.example.fitness.ui.categories.message.MessageFeedbackScreen
import com.example.fitness.ui.categories.workout.item.WorkoutListScreen
import com.example.fitnesstracker.common.Screens
import com.example.fitnesstracker.ui.categories.BodyFatScreen
import com.example.fitnesstracker.ui.categories.BodyTypeScreen
import com.example.fitnesstracker.ui.categories.GenderScreen
import com.example.fitnesstracker.ui.categories.GoalsLeanScreen
import com.example.fitnesstracker.ui.categories.GoalsNaturalScreen
import com.example.fitness.ui.categories.height.HeightScreen
import com.example.fitness.ui.categories.meals.MealsWeekProgressScreen
import com.example.fitness.ui.categories.profile.FirstLastNameScreen
import com.example.fitness.ui.common.SharedViewModel
import com.example.fitness.ui.help.HelpScreen
import com.example.fitness.ui.dashboard.DashboardScreen
import com.example.fitness.ui.login.LoginScreen
import com.example.fitnesstracker.ui.categories.BodyGoalsScreen
import com.example.fitnesstracker.ui.signup.RegisterScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavMainController(modifier: Modifier,
                      navController: NavHostController,
                      startDestination: String = Screens.LOGIN_SCREEN.screenName) {

    val sharedViewModel: SharedViewModel = viewModel(factory = AppViewModelProvider.Factory)

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {

        composable(route = Screens.LOGIN_SCREEN.screenName) {
            LoginScreen(navController = navController, sharedViewModel = sharedViewModel)
        }
        composable(route = Screens.REGISTER_SCREEN.screenName) {
            RegisterScreen(navController = navController)
        }
        composable(route = Screens.FIRSTLAST_SCREEN.screenName) {
            FirstLastNameScreen(navController = navController)
        }
        composable(route = Screens.GENDER_SCREEN.screenName) {
            GenderScreen(navController = navController)
        }

        composable(route = Screens.HEIGHT_SCREEN.screenName + "/{gender}") { navBackStackEntry ->
            val gender = navBackStackEntry.arguments?.getString("gender")
            gender?.let { gnd ->
                HeightScreen(navController = navController, gender = gnd)
            }
        }

        composable(
            route = "${Screens.WEIGHT_SCREEN.screenName}/{gender}",
        ) { navBackStackEntry ->
            val gender = navBackStackEntry.arguments?.getString("gender")
            gender?.let { gnd ->
                WeightScreen(navController = navController, gender = gnd)
            }
        }
        composable(route = Screens.BODYTYPE_SCREEN.screenName) {
            BodyTypeScreen(navController = navController)
        }
        composable(route = Screens.BODYFAT_SCREEN.screenName) {
            BodyFatScreen(navController = navController)
        }

        composable(route = Screens.GOALSLEAN_SCREEN.screenName) {
            GoalsLeanScreen(navController = navController)
        }
        composable(route = Screens.BODYGOALS_SCREEN.screenName) {
            BodyGoalsScreen(navController = navController)
        }
        composable(route = Screens.GOALSNATURAL_SCREEN.screenName) {
            GoalsNaturalScreen(navController = navController)
        }
        composable(route = Screens.DASHBOARD_SCREEN.screenName) {
            DashboardScreen(navController = navController, sharedViewModel = sharedViewModel)
        }

        composable(route = Screens.HAMBURGER_SCREEN.screenName) {
            Hamburger(navController = navController)
        }
        composable(route = Screens.PROFILE_SCREEN.screenName) {
            ProfileScreen(navController = navController)
        }
        composable(route = Screens.MESSAGE_SCREEN.screenName) {
            MessageFeedbackScreen(navController = navController)
        }
        composable(route = Screens.WORKOUTPROGRESS_SCREEN.screenName) {
            WorkoutWeekProgressScreen(navController = navController)
        }
        composable(route = "${Screens.WORKOUT_LIST_SCREEN.screenName}/{dayId}") { navBackStackEntry ->
            val dayId = navBackStackEntry.arguments?.getInt("dayId")
            dayId?.let { id ->
                WorkoutListScreen(navController = navController, dayId = id)
            }
        }
        composable(route = Screens.ABOUTUS_SCREEN.screenName) {
            AboutUsScreen(navController = navController)
        }
        composable(route = Screens.HELP_SCREEN.screenName) {
            HelpScreen(navController = navController)
        }

        composable(route = Screens.MEALSPROGRESS_SCREEN.screenName) {
            MealsWeekProgressScreen(navController = navController, sharedViewModel = sharedViewModel)
        }

        composable(route = Screens.MEALS_SCREEN.screenName + "/{mealId}") { navBackStackEntry ->
            val mealId = navBackStackEntry.arguments?.getString("mealId")
            MealsItemPreviewScreen(navController = navController, mealId = mealId, sharedViewModel = sharedViewModel)
        }
    }
}








