package com.example.fitness.ui.categories.workout.item

import android.os.Build.VERSION.SDK_INT
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.example.fitness.R
import com.example.fitness.common.Constant
import com.example.fitness.ui.AppViewModelProvider
import com.example.fitness.domain.dto.DayContent
import com.example.fitness.domain.dto.WorkoutItemDto
import com.example.fitness.ui.common.CommonHeader
import com.example.fitness.ui.common.DialogConfirmation
import com.example.fitness.ui.common.DialogSuccess
import com.example.fitness.ui.common.PrimaryButton
import com.example.fitness.ui.theme.MyColorTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun WorkoutListScreen(navController: NavController, dayId: Int = 1) {

    var selectedDay by remember { mutableStateOf(dayId + 1) }

    var showWorkoutPreview by remember { mutableStateOf(false) }

    var showFinishedWorkout by remember { mutableStateOf(false) }

    var showBackPressedProgressDismiss by remember { mutableStateOf(false) }

    val workoutListViewModel: WorkoutListViewModel =
        viewModel(factory = AppViewModelProvider.Factory)
    val workoutItemUiState by workoutListViewModel.uiState.collectAsState()

    val dayContent = workoutItemUiState.workoutDayContent

    //counter of the workout list
    var listWorkoutCounter by remember { mutableIntStateOf(0) }


    //Show Dialog on BackPressed
    BackHandler {
        showBackPressedProgressDismiss = true
    }

    LaunchedEffect(Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            workoutListViewModel.getWorkoutAllList()
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        if (showWorkoutPreview && dayContent.workouts.isNotEmpty()) {
            dayContent.workouts.getOrNull(listWorkoutCounter)?.let {
                WorkoutItemPreviewDialog(
                    modifier = Modifier.matchParentSize(),
                    workoutItemDto = it,
                    isLastWorkout = listWorkoutCounter == (dayContent.workouts.size - 1),
                    backOnClick = {
                        //hide preview
                        showWorkoutPreview = false
                    },
                    onDoneClick = {
                        //proceed to next workout if available
                        if ((listWorkoutCounter + 1) < dayContent.workouts.size) {
                            listWorkoutCounter += 1

                            //update the list status
                            workoutListViewModel.updateWorkoutDone(it.workoutId)
                        }
                    },
                    onWorkoutFinishedClick = {

                        //update the list status
                        workoutListViewModel.updateWorkoutDone(it.workoutId)

                        // show success finished
                        showFinishedWorkout = true

                    }
                )
            }
        } else {
            WorkoutScreenContent(
                modifier = Modifier.matchParentSize(),
                dayContent = dayContent,
                selectedDay = selectedDay,
            ) {
                showWorkoutPreview = true
            }
        }

        //show finish dialog
        if (showFinishedWorkout) {
            DialogSuccess(
                modifier = Modifier.matchParentSize(),
                icon = R.drawable.ic_success,
                text = "Good job!",
                buttonText = "OKAY"
            ) {
                showFinishedWorkout = false


                CoroutineScope(Dispatchers.IO).launch {
                    workoutListViewModel.updateDoneProgressCount()
                }


                navController.popBackStack()

            }
        }
        //show WARNING to user Progress will be reset
        if (showBackPressedProgressDismiss) {

            DialogConfirmation(
                text = "Are you sure?",
                icon = R.drawable.ic_warning,
                onYesClick = {
                    navController.popBackStack()
                },
                onNoClick = {
                    showBackPressedProgressDismiss = false
                }
            )

        }
    }
}






@Composable
fun WorkoutScreenContent(modifier: Modifier = Modifier, dayContent: DayContent, selectedDay: Int, onClick: () -> Unit) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        WorkOutContent(day = selectedDay, dayContent = dayContent, onClick = onClick)
    }
}

@Composable
fun WorkOutContent(day: Int, dayContent: DayContent, onClick: () -> Unit) {

    val imageLoader = rememberImageLoader()
    val totalDuration = getTotalWorkoutDuration(dayContent)

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Header(day, dayContent.workouts.size, totalDuration)

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(vertical = 16.dp)
        ) {
            WorkoutList(dayContent.workouts, imageLoader)
        }

        Spacer(modifier = Modifier.height(16.dp))

        GoButton { onClick() }
    }
}

@Composable
fun Header(day: Int, workoutCount: Int, totalDuration: Int) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CommonHeader(
            textAlign = TextAlign.Center,
            text = Constant.bodyTypeCategory,
            fontSize = 16.sp
        )
        Text(
            text = "Workouts: $workoutCount",
            fontSize = 18.sp,
            color = Color.Gray
        )
        Text(
            text = "Total Duration: $totalDuration secs",
            fontSize = 18.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun WorkoutList(workouts: List<WorkoutItemDto>, imageLoader: ImageLoader) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        items(workouts) { workout ->
            WorkoutRow(workout = workout, imageLoader = imageLoader, isWorkoutCompleted = workout.hasCompleted == Constant.COMPLETED_STATUS)
            Divider(
                color = Color.Gray.copy(0.3f),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            )
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Composable
fun WorkoutRow(workout: WorkoutItemDto, imageLoader: ImageLoader, isWorkoutCompleted: Boolean) {
    Box(modifier = Modifier.fillMaxWidth()){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            WorkoutImage(workout.imageRes, imageLoader)
            Spacer(modifier = Modifier.width(16.dp))
            WorkoutDetails(workout)
        }
        if(isWorkoutCompleted){
            CheckWorkoutDone(modifier = Modifier.align(Alignment.CenterEnd))
        }
    }

}

@Preview
@Composable
fun CheckWorkoutDone(modifier: Modifier = Modifier){

    Box(modifier = modifier
        .size(30.dp)
        .clip(CircleShape)
        .background(MyColorTheme.green)
        .padding(2.dp)){
        Image(
            painter = painterResource(id = R.drawable.ic_check),
            contentDescription = "Login Image",
            modifier = Modifier
                .matchParentSize()
                .align(Alignment.Center)
        )
    }
}

@Composable
fun WorkoutImage(imageRes: Int, imageLoader: ImageLoader) {
    Image(
        painter = rememberAsyncImagePainter(model = imageRes, imageLoader = imageLoader),
        contentDescription = null,
        modifier = Modifier
            .size(64.dp)
            .clip(RoundedCornerShape(8.dp)),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun WorkoutDetails(workout: WorkoutItemDto) {
    Column {
        Text(
            text = workout.workoutName,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Text(
            text = "${workout.reps} reps, ${workout.duration} sec",
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun GoButton(onClick: () -> Unit) {
    PrimaryButton(
        text = "GO",
    ){
        onClick()
    }
}

@Composable
private fun rememberImageLoader(): ImageLoader {
    val context = LocalContext.current
    return ImageLoader.Builder(context)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()
}

private fun getTotalWorkoutDuration(dayContent: DayContent): Int {
    return dayContent.workouts.sumOf { it.duration }
}

/*** >>>>>>>>>>>>>>>>>>>>>>>>>>>> FOR PREVIEWING THE WORKOUT LIST <<<<<<<<<<<<<<<<<<<<<<<<<<<< **/




@Preview(showBackground = true)
@Composable
fun WorkoutScreenContentPreview() {
    WorkoutScreenContent(
        dayContent = DayContent(
            workouts = listOf(
                WorkoutItemDto(
                    workoutId = "PLANKS-05",
                    imageRes = R.drawable.bk_male ,
                    workoutName = "Plank Shoulder Tap",
                    reps = 5,
                    duration = 15)
            )
        ),
        selectedDay = 1
    ){}
}

