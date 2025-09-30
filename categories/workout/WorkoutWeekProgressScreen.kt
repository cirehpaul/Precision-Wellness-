package com.example.fitness.ui.categories.workout

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.fitness.common.Constant
import com.example.fitness.ui.AppViewModelProvider
import com.example.fitness.ui.common.CommonDayCircleProgress
import com.example.fitness.ui.common.CommonHeader
import com.example.fitness.ui.common.PrimaryButton
import com.example.fitness.ui.common.TrophyOfExcellence
import com.example.fitness.ui.common.updateCompletedIndexValues
import com.example.fitness.ui.theme.MyColorTheme
import com.example.fitness.ui.theme.green
import com.example.fitnesstracker.common.Screens
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun WorkoutWeekProgressScreen(navController: NavController) {

    val workoutWeekProgressViewModel: WorkoutWeekProgressViewModel = viewModel(factory = AppViewModelProvider.Factory)
    val workoutUiState by workoutWeekProgressViewModel.uiState.collectAsState()

    val initialWeeks = List(Constant.MAX_WEEK_COUNT) { 0 }
    var completedDaysList = remember {  mutableStateListOf(*initialWeeks.toTypedArray()) }

    LaunchedEffect(Unit) {
        CoroutineScope(Dispatchers.IO).launch{
            workoutWeekProgressViewModel.getWorkoutWeekProgress()
        }
        completedDaysList = updateCompletedIndexValues(completedDaysList, workWeek = workoutUiState.workoutWeekCount, workDay = workoutUiState.workoutDayCount)
    }

    //if this value changes change the progress
    LaunchedEffect(workoutUiState) {
        //update the list from database content
        completedDaysList = updateCompletedIndexValues(completedDaysList, workWeek = workoutUiState.workoutWeekCount, workDay = workoutUiState.workoutDayCount)
    }
    WorkoutProgressContent(
        completedDaysList = completedDaysList,
    ){
        navController.navigate(Screens.WORKOUT_LIST_SCREEN.screenName + "/${workoutUiState.workoutWeekCount + 1}")
    }
}

@Composable
fun WorkoutProgressContent(completedDaysList: SnapshotStateList<Int>,
                           startButtonClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize().padding(18.dp)){
        Column(
            modifier = Modifier.align(Alignment.TopStart).matchParentSize()
        ) {
            CommonHeader(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                text = "Workout",
                subText = "Stay motivated on your workout journey.",
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            LazyColumn(
                modifier = Modifier
            ) {
                itemsIndexed(completedDaysList) { index, completedDays ->
                    WeekSection(
                        weekNumber = index + 1,
                        completedDays = completedDays,
                        onDayCompleted = { day ->
                            //TODO Remove the clicking of the button for now and add it to startButton
                            // completedDaysList[index] = day
                        }
                    )
                }

            }
        }



        Column(modifier = Modifier.align(Alignment.BottomCenter)){
            StartButton() {
                startButtonClick()
            }
            Spacer(Modifier.height(20.dp))
        }

    }

}

@Composable
fun StartButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    PrimaryButton(
        modifier = modifier,
        text = "START",
    ){
        onClick()
    }
}

@Composable
fun WeekSection(weekNumber: Int, completedDays: Int, onDayCompleted: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .padding(vertical = 12.dp, horizontal = 8.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Column(modifier = Modifier
            .border(1.dp, Color.Gray.copy(0.2f), RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .background(MyColorTheme.white)
            .padding(start = 10.dp, top = 10.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Week $weekNumber",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                fontStyle = FontStyle.Normal,
                modifier = Modifier.padding(bottom = 10.dp),
                color = green
            )
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 5.dp)
            ) {
                (1..7).forEach { day ->
                    CommonDayCircleProgress(
                        day = day,
                        hasExtraLine = day > 1,
                        isCompleted = day <= completedDays,
                        isClickable = day == completedDays + 1 && completedDays < 7,
                        onDayClick = { onDayCompleted(day) }
                    )
                }
                Spacer(modifier = Modifier)
                if ((completedDays == 7)) {
                    AnimatedVisibility(
                        visible = true,
                        enter = scaleIn(
                            animationSpec = tween(durationMillis = 500)
                        ) + fadeIn(animationSpec = tween(durationMillis = 500)),
                        exit = scaleOut(
                            animationSpec = tween(durationMillis = 500)
                        ) + fadeOut(animationSpec = tween(durationMillis = 500))
                    ) {
                        TrophyOfExcellence()
                    }
                }
            }
        }
        }
    }


@Preview(showBackground = true)
@Composable
fun WeeksProgressPreview() {
    MaterialTheme {
        Surface {
            val initialWeeks = List(4) { 0 }
            val completedDaysList = remember { mutableStateListOf(*initialWeeks.toTypedArray()) }
            WorkoutProgressContent(completedDaysList,){}
        }
    }
}
