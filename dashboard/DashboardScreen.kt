package com.example.fitness.ui.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fitness.R
import com.example.fitness.ui.common.SharedViewModel
import com.example.fitness.ui.theme.Lightgreen_dark
import com.example.fitness.ui.theme.Ly_dark
import com.example.fitness.ui.theme.darkGreen_dark

@Composable
fun DashboardScreen(navController: NavController, sharedViewModel: SharedViewModel) {
    val sharedViewModelUIState by sharedViewModel.sharedVMUIState.collectAsState()
    DashboardContent(CalorieCard = {
        DailyCaloriesCard(
            caloriesPercentageProgress = sharedViewModelUIState.caloriesPercentageProgress,
            carbsPercentageProgress = sharedViewModelUIState.carbsPercentageProgress,
            proteinPercentageProgress = sharedViewModelUIState.proteinPercentageProgress,
            fatsPercentageProgress = sharedViewModelUIState.fatsPercentageProgress,
            currentCalories = sharedViewModelUIState.currentCalories,
            currentProtein = sharedViewModelUIState.currentProtein,
            currentCarbs = sharedViewModelUIState.currentCarbs,
            currentFats = sharedViewModelUIState.currentFats,
            totalCalories = sharedViewModelUIState.dashboardTotalCalories,
            totalProtein = sharedViewModelUIState.dashboardTotalProtein,
            totalCarbs = sharedViewModelUIState.dashboardTotalCarbs,
            totalFats = sharedViewModelUIState.dashboardTotalFats,
        )
    })
}

@Composable
fun DashboardContent(
     CalorieCard: @Composable ()-> Unit,
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Greeting()
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            CalorieCard()
            Spacer(modifier = Modifier.height(16.dp))
            WorkoutPlanCard()
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun Greeting() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Login Image",
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Precision Wellness",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun DailyCaloriesCard( caloriesPercentageProgress: Float = 0F,
                       carbsPercentageProgress: Float = 0F,
                       proteinPercentageProgress: Float = 0F,
                       fatsPercentageProgress: Float = 0F,
                       currentCalories: String? = null,
                       currentProtein: String? = null,
                       currentCarbs: String? = null,
                       currentFats: String? = null,
                       totalCalories: String? = null,
                       totalProtein: String? = null,
                       totalCarbs: String? = null,
                       totalFats: String? = null,) {
    DashboardCard(
        imageRes = R.drawable.vegies,
        title = "My Daily Calories",
        mainProgressText = "$currentCalories/$totalCalories kCal",
        mainProgressValue = caloriesPercentageProgress,
        labels = listOf("$currentFats/$totalFats Fats", "$currentCarbs/$totalCarbs Carbs", "$currentProtein/$totalProtein Proteins"),
        progressValues = listOf(fatsPercentageProgress, carbsPercentageProgress, proteinPercentageProgress)
    )
}

@Composable
fun WorkoutPlanCard() {
    DashboardCard(
        imageRes = R.drawable.gyms,
        title = "Workout Plan",
        mainProgressText = "Body Weight",
        mainProgressValue = 0.8F,
        labels = listOf("Progress"),
        progressValues = listOf(0.6f)
    )
}

@Composable
fun DashboardCard(
    imageRes: Int,
    title: String,
    mainProgressText: String,
    mainProgressValue: Float,
    labels: List<String>,
    progressValues: List<Float>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, darkGreen_dark, RoundedCornerShape(10.dp))
            .background(color = Lightgreen_dark, shape = RoundedCornerShape(10.dp))
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
                .width(1.dp)
                .height(200.dp),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Normal
                )
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = mainProgressText,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(8.dp))
            LinearProgressIndicator(
                progress = mainProgressValue, // to change
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .clip(RoundedCornerShape(4.dp)),
                color = Color.White,
                trackColor = Ly_dark
            )
            Spacer(modifier = Modifier.height(8.dp))
            //spacer placeholder
            var spacerEnd = 0.dp
            val actualSpacerSize = 8.dp
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                labels.forEachIndexed { index, label ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .padding(start = spacerEnd)
                    ) {
                        //add spacer for next content placeholder
                        spacerEnd = actualSpacerSize
                        Text(
                            text = label,
                            color = Color.White,
                            fontSize = 12.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        LinearProgressIndicator(
                            progress = progressValues.getOrElse(index) { 0.5f },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(8.dp)
                                .clip(RoundedCornerShape(4.dp)),
                            color = Color.White,
                            trackColor = Ly_dark
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun BottomNavigationItem(iconRes: Int, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(35.dp),
            colorFilter = ColorFilter.tint(Color.White)
        )
        Text(
            text = label,
            color = Color.White,
            fontSize = 12.sp
        )
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun DashboardScreenPreview() {
    DashboardContent(
        CalorieCard = {
            DailyCaloriesCard()
        }
    )
}
