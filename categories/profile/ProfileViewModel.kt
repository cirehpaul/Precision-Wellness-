import androidx.lifecycle.ViewModel
import com.example.fitness.common.Constant
import com.example.fitness.domain.dto.UserDetailsDto
import com.example.fitness.domain.usecase.profile.GetUserProfileUseCase
import com.example.fitness.domain.usecase.profile.UpdateUserProfileUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

// Data class to hold user profile information
data class UserProfile(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val height: String,
    val weight: String,
    val gender: String,
    val bodyFat: String,
    val bodyType: String
)

class ProfileViewModel(
    private val getUserProfileUseCase: GetUserProfileUseCase,
    private val updateUserProfileUseCase: UpdateUserProfileUseCase
) : ViewModel() {

    private val _profileData = MutableStateFlow<UserDetailsDto?>(null)
    val profileData: StateFlow<UserDetailsDto?> = _profileData

    private val _isUpdateSuccessful = mutableStateOf<Boolean>(false)
    val isUpdateSuccessful: MutableState<Boolean> = _isUpdateSuccessful

    private val userId = Constant.userId.longValue

    // Function to retrieve the user profile
    suspend fun getUserProfile() {
            try {
                val updatedProfile = getUserProfileUseCase.invoke(userId)
                _profileData.value = updatedProfile
            } catch (e: Exception) {
                Log.e("ProfileViewModel", "Error fetching user profile", e)
            }
    }

    fun resetSuccessDialog(){
        _isUpdateSuccessful.value = false
    }

    // Function to update user profile
    suspend fun updateUserProfile(
        firstName: String,
        lastName: String,
        age: String,
        height: String,
        weight: String,
        gender: String,
        bodyFat: String,
        bodyType: String,
        profilePic: String
    ) {
            try {
                updateUserProfileUseCase.invoke(
                    profilePic = profilePic,
                    userId = userId,
                    firstname = firstName,
                    lastname = lastName,
                    age = age,
                    height = height,
                    weight = weight,
                    bodytype = bodyType,
                    bodyfat = bodyFat,
                    gender = gender
                )
                _isUpdateSuccessful.value = true

            } catch (e: Exception) {
                Log.e("ProfileViewModel", "Error updating user profile", e)
            }
    }
}
