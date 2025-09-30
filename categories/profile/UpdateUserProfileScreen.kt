//package com.example.fitness.ui.categories.profile
//
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.NavController
//import com.example.fitness.ui.AppViewModelProvider
//
//@Composable
//fun UpdateUserProfileScreen(navController: NavController) {
//    val updateUserProfileViewModel: UpdateUserProfileViewModel =
//        viewModel(factory = AppViewModelProvider.Factory)
//    val updateProfile by updateUserProfileViewModel.updateProfile.collectAsState()
//
//    LaunchedEffect(true) {
//        updateUserProfileViewModel.updateUserProfile()
//    }
//}