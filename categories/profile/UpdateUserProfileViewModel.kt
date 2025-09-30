//package com.example.fitness.ui.categories.profile
//
//import android.util.Log
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.fitness.domain.usecase.profile.UpdateUserProfileUseCase
//import com.google.firebase.firestore.FirebaseFirestore
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.tasks.await
//
//class UpdateUserProfileViewModel(
//    private val updateUserProfileUseCase: UpdateUserProfileUseCase
//) : ViewModel() {
//
//    val updateProfile: Any
//    private val db = FirebaseFirestore.getInstance()
//    private val userId = "user_id"
//
//
//    // Function to update the user profile
//    fun UpdateUserProfile(
//        firstName: String,
//        lastName: String,
//        age: Int,
//        height: String,
//        weight: String,
//        gender: String,
//        bodyFat: String,
//        bodyType: String
//    ) {
//        viewModelScope.launch {
//            val userProfile = UpdateUserProfile(
//                firstName,
//                lastName,
//                age,
//                height,
//                weight,
//                gender,
//                bodyFat,
//                bodyType
//            )
//            try {
//                // Update the user profile in the Firestore database
//                db.collection("users")
//                    .document(userId)
//                    .set(userProfile)
//                    .await()
//
//
//            } catch (e: Exception) {
//                Log.e("UpdateUserProfileViewModel", "Error updating profile", e)
//            }
//        }
//    }
//
//    fun updateUserProfile() {
//
//    }
//}