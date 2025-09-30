package com.example.fitness.ui.categories.meals

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.fitness.R
import com.example.fitness.common.Constant
import com.example.fitness.domain.dto.MealsDto
import com.example.fitness.ui.AppViewModelProvider
import com.example.fitness.ui.common.CommonDayCircleProgress
import com.example.fitness.ui.common.CommonHeader
import com.example.fitness.ui.common.PrimaryButton
import com.example.fitness.ui.common.SharedViewModel
import com.example.fitness.ui.common.TrophyOfExcellence
import com.example.fitness.ui.common.updateCompletedIndexValues
import com.example.fitness.ui.theme.MyColorTheme
import com.example.fitness.util.defaultPadding
import com.example.fitness.util.defaultPaddingStart
import com.example.fitnesstracker.common.Screens
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun MealsWeekProgressScreen(navController: NavController, sharedViewModel: SharedViewModel) {


    val mealsWeekProgressViewModel: MealsWeekProgressViewModel = viewModel(factory = AppViewModelProvider.Factory)

    val mealsUiState by mealsWeekProgressViewModel.uiState.collectAsState()
    val sharedVMUIState by sharedViewModel.sharedVMUIState.collectAsState()

    val initialWeeks = List(Constant.MAX_WEEK_COUNT) { 0 }
    var completedDaysList = remember {  mutableStateListOf(*initialWeeks.toTypedArray()) }

    LaunchedEffect(Unit) {
        CoroutineScope(Dispatchers.IO).launch{
            mealsWeekProgressViewModel.getMealsWeekProgress()
        }
        completedDaysList = updateCompletedIndexValues(completedDaysList, workWeek = mealsUiState.mealsWeekCount, workDay = mealsUiState.mealsDayCount)
    }

    //if this value changes change the progress
    LaunchedEffect(mealsUiState) {
        //update the list from database content
        completedDaysList = updateCompletedIndexValues(completedDaysList, workWeek = mealsUiState.mealsWeekCount, workDay = mealsUiState.mealsDayCount)
    }

    MealsProgressContent(
        completedDaysList = completedDaysList,
        mealsHighlights = sharedVMUIState.mealsWeekHighlights,
        onPreviousDayClick = { progressDayId ->
            CoroutineScope(Dispatchers.IO).launch {
                sharedViewModel.setPreviousDayMeals(progressDayID = progressDayId){
                    CoroutineScope(Dispatchers.Main).launch {
                        navController.navigate(Screens.MEALS_SCREEN.screenName+"/${Constant.NO_MEAL_HIGHLIGHT_ID}")//send only empty content -> to get from the enums
                    }
                }
            }
        }
    ){
        CoroutineScope(Dispatchers.IO).launch {
            //update the progress bar in Dashboard with new Content
            sharedViewModel.setCurrentDayMeals {
                CoroutineScope(Dispatchers.Main).launch {
                    /*  if(mealsUiState.mealsWeekCount == 0 && mealsUiState.mealsDayCount == 0){
                        navController.navigate(Screens.MEALS_SCREEN.screenName + "/${sharedVMUIState.mealsWeekHighlights.getOrNull(0)?.mealsId}")
                    }else{*/
                    //no highlights meal for now it will be only for displaying
                    navController.navigate(Screens.MEALS_SCREEN.screenName+"/${Constant.NO_MEAL_HIGHLIGHT_ID}")//send only empty content -> to get from the enums
                    //   }
                }
            }
        }
    }
}

@Composable
fun MealsProgressContent(
    completedDaysList: SnapshotStateList<Int>,
    mealsHighlights: List<MealsDto>,
    onPreviousDayClick: (String) -> Unit,
    startButtonClick: () -> Unit,
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(MyColorTheme.backgroundMainDirtyWhite)){
        CommonHeader(
            modifier = Modifier
                .fillMaxWidth()
                .defaultPadding(),
            text = "Weekly Meal Plan",
            subText = "Let's check your food nutrition & calories.",
            fontSize = 16.sp
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {

            item{
                Spacer(modifier = Modifier.height(5.dp))
                LazyRow(
                    modifier = Modifier.defaultPaddingStart()
                ) {
                    itemsIndexed(completedDaysList) { index, completedDays ->
                        mealsHighlights.getOrNull(index)?.let { meal ->
                            WeekMealSection(
                                mealsDto = meal,
                                weekNumber = index + 1,
                                completedDays = completedDays,
                                onDayCompleted = { day ->
                                    //if day already completed for preview only
                                    if(day <= completedDays){
                                        onPreviousDayClick(Constant.createMealsProgressDayID(
                                            month = 0,
                                            week = if(index-1 >= 0) index-1 else index,
                                            day = if(day-1 >= 0) day-1 else day,
                                        ))
                                    }
                                }
                            )
                        }
                    }

                }
            }

            item{
                BottomNote()

                Column(modifier = Modifier.defaultPadding()
                ) {
                    PrimaryButton(
                        modifier = Modifier,
                        text = "START",
                    ) {
                        startButtonClick()
                    }
                    Spacer(Modifier.height(20.dp))
                }
            }

        }
    }
}

@Composable
private fun BottomNote(){
    Spacer(modifier = Modifier.height( 20.dp))
    Box(modifier = Modifier.fillMaxWidth()){
        Column(modifier = Modifier
            .align(Alignment.Center)
            .fillMaxWidth()
            .defaultPaddingStart()
        ) {
            Column(
                Modifier

                    .shadow(elevation = 10.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .border(0.5.dp, Color.Gray.copy(0.4f), RoundedCornerShape(10.dp))
                    .background(Color.White)
                    .fillMaxWidth()
                    .heightIn(min = 90.dp)) {
                Column(
                    Modifier
                        .fillMaxWidth(0.7f)
                        .padding(10.dp)) {
                    Text(
                        text = "Balance Diet",
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.titleMedium,
                        color = MyColorTheme.greenMain_light
                    )
                    Text(
                        text = "Stay healthy and young by taking a healthy balanced diet!",
                        color = MyColorTheme.brumswick_green,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

        }

        Image(
            painter = painterResource(id = R.drawable.vegies),
            contentDescription = "Meal Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier

                .offset(x = 40.dp)
                .align(Alignment.CenterEnd)
                .size(150.dp)
                .clip(CircleShape)
        )
    }
}

@Composable
private fun WeekMealSection(mealsDto: MealsDto, weekNumber: Int, completedDays: Int, onDayCompleted: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .padding(top = 12.dp, end = 18.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Column(modifier = Modifier
            .border(1.dp, Color.Gray.copy(0.2f), RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .background(MyColorTheme.white)
            .width(
                if ((completedDays == 7)) {
                    350.dp
                } else {
                    300.dp
                }
            )
            .padding(top = 10.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Column(Modifier.padding(horizontal = 10.dp)){
                Text(
                    text = "Week $weekNumber",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    fontStyle = FontStyle.Normal,
                    modifier = Modifier.padding(bottom = 10.dp),
                    color = MyColorTheme.brumswick_green
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
                            isClickable = day <= completedDays,
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
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Menu highlights ✸",
                    style = MaterialTheme.typography.labelLarge,
                    color = MyColorTheme.greenMain_light,
                    modifier = Modifier.padding(bottom = 15.dp)
                )
            }
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(320.dp)){
                Image(
                    painter = painterResource(id = mealsDto.imageRes),
                    contentDescription = "Meal Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .matchParentSize()
                        .clip(RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
                )

                Text(
                    text = mealsDto.mealsName,
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.White,
                    modifier = Modifier
                        .clip(RoundedCornerShape(topEnd = 10.dp))
                        .background(MyColorTheme.brumswick_green)
                        .padding(10.dp)
                        .align(Alignment.BottomStart)
                )
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun MealsWeekProgressScreenPreview() {
    val initialWeeks = List(4) { 0 }
    val completedDaysList = remember { mutableStateListOf(*initialWeeks.toTypedArray()) }

    val list = listOf(
        MealsDto(
            mealsId = "MEALSBEGINNER-01",
            imageRes = R.drawable.egg_with_rice,
            mealsName = "Egg with Rice",
            ingredients = "Egg with Rice",
            calories = "120",
            fats = "120",
            protein = "120",
            carbs = "20",
            mealTime = "20",
        ),
        MealsDto(
            mealsId = "MEALSBEGINNER-01",
            imageRes = R.drawable.egg_with_rice,
            mealsName = "Egg with Rice",
            ingredients = "Egg with Rice",
            calories = "120",
            fats = "120",
            protein = "120",
            carbs = "20",
            mealTime = "20",
        ),
        MealsDto(
            mealsId = "MEALSBEGINNER-01",
            imageRes = R.drawable.egg_with_rice,
            mealsName = "Egg with Rice",
            ingredients = "Egg with Rice",
            calories = "120",
            fats = "120",
            protein = "120",
            carbs = "20",
            mealTime = "20",
        ),
        MealsDto(
            mealsId = "MEALSBEGINNER-01",
            imageRes = R.drawable.egg_with_rice,
            mealsName = "Egg with Rice",
            ingredients = "Egg with Rice",
            calories = "120",
            fats = "120",
            protein = "120",
            carbs = "20",
            mealTime = "20",
        )
    )
    MealsProgressContent(completedDaysList,list,{}){}
}
