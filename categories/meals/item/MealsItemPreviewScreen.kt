import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.fitness.R
import com.example.fitness.common.Constant
import com.example.fitness.common.MealTime
import com.example.fitness.common.MealsStatus
import com.example.fitness.domain.dto.MealsDto
import com.example.fitness.ui.AppViewModelProvider
import com.example.fitness.ui.categories.meals.item.MealsItemPreviewViewModel
import com.example.fitness.ui.common.CommonHeader
import com.example.fitness.ui.common.DialogSuccess
import com.example.fitness.ui.common.IngredientsDialog
import com.example.fitness.ui.common.PrimaryButton
import com.example.fitness.ui.common.SharedViewModel
import com.example.fitness.ui.theme.MyColorTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Locale

@Composable
fun MealsItemPreviewScreen(navController: NavHostController, sharedViewModel: SharedViewModel, mealId: String?) {
    val mealsItemPreviewViewModel: MealsItemPreviewViewModel =
        viewModel(factory = AppViewModelProvider.Factory)
    val sharedVMUIState by sharedViewModel.sharedVMUIState.collectAsState()

   /* TODO: Not needed for now mealID
   LaunchedEffect(Unit) {
        mealId?.let { mealId ->
            CoroutineScope(Dispatchers.IO).launch {
                sharedViewModel.getMealsDayHighlightsPreview(mealId)
            }
        }
    }*/

    var isDialogOpen by remember { mutableStateOf(false) }
    var selectedMeal by remember { mutableStateOf(MealTime.BREAKFAST.label) }
    var showFinishedDialog by remember { mutableStateOf(false) }

    if (sharedVMUIState.mealsWeekHighlights.isEmpty()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator(modifier = Modifier.size(50.dp), color = Color.LightGray)
        }
    } else {
        MealsItemPreviewContent(
            navController = navController,
            meals = sharedVMUIState.mealsDay,
            totalCalories = sharedVMUIState.totalCalories,
            totalProtein = sharedVMUIState.totalProtein,
            totalCarbs = sharedVMUIState.totalCarbs,
            totalFats = sharedVMUIState.totalFats,
            selectedMeal = selectedMeal,
            isDialogOpen = isDialogOpen,
            isShowFinishedDialog = showFinishedDialog,
            selectionMealClick = { selectedMeal = it },
            dialogOpenClick = { isDialogOpen = it },
            showFinishedDialogClick = { showFinishedDialog = it },
            doneMealClick = {
                CoroutineScope(Dispatchers.IO).launch {
                    sharedVMUIState.mealsDay.firstOrNull{
                        it.mealTime == selectedMeal && it.mealsDayProgress == Constant.cachedProgressDayID
                    }?.let {
                        sharedViewModel.updateCurrentMealStatus(
                            mealsId = it.mealsId,
                            mealTime = selectedMeal,
                            mealsProgressDay = it.mealsDayProgress,
                            mealsStatus = MealsStatus.DONE
                        )
                    }
                }
            },
            finalizeMealClick = {
               CoroutineScope(Dispatchers.IO).launch {
                   //after finishing the meal
                    mealsItemPreviewViewModel.updateDoneProgressCount{
                        //update the last meal
                        CoroutineScope(Dispatchers.IO).launch {
                            sharedVMUIState.mealsDay.firstOrNull{it.mealTime == selectedMeal}?.let {
                                sharedViewModel.updateCurrentMealStatus(
                                    mealsId = it.mealsId,
                                    mealTime = selectedMeal,
                                    mealsProgressDay = it.mealsDayProgress,
                                    mealsStatus = MealsStatus.DONE
                                )
                            }
                        }
                    }
               }
            }
        )
    }
    if (isDialogOpen) {
        val selectedMealData = sharedVMUIState.mealsWeekHighlights.firstOrNull { it.mealTime == selectedMeal }
        IngredientsDialog(
            showDialog = isDialogOpen,
            onDismiss = { isDialogOpen = false },
            ingredients = selectedMealData?.ingredients.orEmpty(),
            greenMainLight = MyColorTheme.greenMain_light,
            imageRes = selectedMealData?.imageRes
        )
    }
}
@Composable
private fun MealsItemPreviewContent(
    navController: NavHostController,
    meals: List<MealsDto>,
    totalCalories: String?,
    totalProtein: String?,
    totalCarbs: String?,
    totalFats: String?,
    selectedMeal: String,
    isDialogOpen: Boolean,
    isShowFinishedDialog: Boolean,
    selectionMealClick: (String) -> Unit,
    dialogOpenClick: (Boolean) -> Unit,
    showFinishedDialogClick: (Boolean) -> Unit,
    doneMealClick: () -> Unit,
    finalizeMealClick: () -> Unit,
) {
    if (isShowFinishedDialog) {
        DialogSuccess(
            icon = R.drawable.ic_success,
            text = "Good job!",
            buttonText = "OKAY"
        ) {
            showFinishedDialogClick(false)
            navController.popBackStack()
        }
    }
    Column(Modifier.verticalScroll(rememberScrollState())) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)) {
            CommonHeader(
                text = "Meal Plan",
                subText = "Complete your daily nutrition.",
                fontSize = 26.sp,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(15.dp))
        }

        NutritionSection(modifier = Modifier.padding(vertical = 10.dp),
            totalCalories = totalCalories,
            totalProtein = totalProtein,
            totalCarbs = totalCarbs,
            totalFats = totalFats,
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            TabContent(
                meals = meals,
                selectedMeal = selectedMeal,
                dialogOpenClick = dialogOpenClick,
                doneMealClick = doneMealClick,
                selectionMealClick = { meal ->
                    selectionMealClick(meal)
                },
                finalizeMealClick = {
                    finalizeMealClick()
                    showFinishedDialogClick(true)
                }
            )
        }
    }
}
@Composable
fun NutritionSection(modifier: Modifier = Modifier,
                     totalCalories: String?,
                     totalProtein: String?,
                     totalFats: String?,
                     totalCarbs: String?,
) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .size(150.dp, 150.dp)
            .padding(start = 10.dp)
        ,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        item {
            NutritionCard(
                title = "Calories",
                name = "Total:",
                value = "${totalCalories}kcal",
                color = Color(0xFFACFFEB),
                icon = R.drawable.ic_fire
            )
        }
        item {
            NutritionCard(
                title = "Protein",
                name = "Total:",
                value = "${totalProtein}g",
                color = Color(0xFFA3F3A6),
                icon = R.drawable.ic_protein
            )
        }
        item {
            NutritionCard(
                title = "Carbs",
                name = "Total:",
                value =  "${totalCarbs}g",
                color = Color(0xFFF6BFFF),
                icon = R.drawable.ic_water
            )
        }
        item {
            NutritionCard(
                title = "Fats",
                name = "Total:",
                value =  "${totalFats}g",
                color = Color(0xFFFDB299),
                icon = R.drawable.ic_fire
            )
        }
    }
}
@Composable
fun NutritionCard(
    title: String,
    name: String,
    value: String,
    color: Color,
    icon: Int
) {
    Card(
        modifier = Modifier
            .size(120.dp, 150.dp)
            .clip(RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(containerColor = color),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                    color = Color.Black
                )
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = "$title Icon",
                    tint = Color.Black,
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.DarkGray
                )
                Text(
                    text = value,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color.Black
                )
            }
        }
    }
}

@Composable
private fun TabContent(
    meals: List<MealsDto>,
    selectedMeal: String,
    dialogOpenClick: (Boolean) -> Unit,
    selectionMealClick: (String) -> Unit,
    doneMealClick: () -> Unit,
    finalizeMealClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {

        MealTime.values().forEach { mealTime ->
            TabButton(
                text = mealTime.label,
                isCurrentMealDone = meals.firstOrNull {
                    it.mealTime.lowercase(Locale.getDefault()) == mealTime.name.lowercase(Locale.getDefault()) }
                    ?.mealsStatusProgress == MealsStatus.DONE.name,
                isSelected = selectedMeal == mealTime.label,
                onClick = { selectionMealClick(mealTime.label) }
            )
        }
    }
    meals.firstOrNull { it.mealTime == selectedMeal }?.let { currentMeal ->
        Column(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .clickable { dialogOpenClick(true) }
            ) {
                Image(
                    painter = painterResource(id = currentMeal.imageRes),
                    contentDescription = "Meal Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .matchParentSize()
                        .clip(RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
                )
                Text(
                    text = currentMeal.mealsName,
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.White,
                    modifier = Modifier
                        .clip(RoundedCornerShape(topEnd = 10.dp))
                        .background(MyColorTheme.brumswick_green)
                        .padding(10.dp)
                        .align(Alignment.BottomStart)
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                NutritionInfo(currentMeal.calories, "Calories", Color(0xFFACFFEB))
                NutritionInfo(currentMeal.protein, "Protein", Color(0xFFA3F3A6))
                NutritionInfo(currentMeal.carbs, "Carbs", Color(0xFFF6BFFF))
                NutritionInfo(currentMeal.fats, "Fats", Color(0xFFFDB299))
            }

            Spacer(modifier = Modifier.height(20.dp))

            //Show Finish meal button when breakfast and lunch was done
            val isBreakfastAndLunchDone = meals.firstOrNull {
                it.mealTime.lowercase(Locale.getDefault()) == MealTime.BREAKFAST.name.lowercase(Locale.getDefault()) }
                ?.mealsStatusProgress == MealsStatus.DONE.name && meals.firstOrNull {
                it.mealTime.lowercase(Locale.getDefault()) == MealTime.LUNCH.name.lowercase(Locale.getDefault()) }
                ?.mealsStatusProgress == MealsStatus.DONE.name

            NavigationButtonOptions(
                isLastMeal = selectedMeal == MealTime.DINNER.label,
                isBreakfastAndLunchDone = isBreakfastAndLunchDone,
                isCurrentMealDone = currentMeal.mealsStatusProgress == MealsStatus.DONE.name,
                onMealFinishedClick = finalizeMealClick,
                onDoneClick = doneMealClick
            )
        }
    }
}

@Composable
fun NavigationButtonOptions(
    isLastMeal: Boolean,
    isBreakfastAndLunchDone: Boolean,
    isCurrentMealDone: Boolean,
    onMealFinishedClick: () -> Unit,
    onDoneClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(visible = !isCurrentMealDone) {

            if(isLastMeal && isBreakfastAndLunchDone){
                PrimaryButton(
                    iconSuffix = R.drawable.ic_flag,
                    text = "FINISH MEAL PREP",
                    onClick = {onMealFinishedClick()}
                )
            }else if(!isLastMeal){
                PrimaryButton(
                    iconSuffix = R.drawable.ic_check,
                    text = "DONE",
                    onClick ={ onDoneClick() }
                )
            }
        }
    }
}

@Composable
fun TabButton(text: String, isCurrentMealDone: Boolean, isSelected: Boolean, onClick: () -> Unit) {

    Row(
        Modifier
            .clickable { onClick() }
            .background(
                color = if (isCurrentMealDone) {
                    MyColorTheme.greenMain_light.copy(0.2f)
                } else if (isSelected) {
                    Color(0xFF31493C)
                } else {
                    Color(0xFFF5F5F5)
                },
                shape = RoundedCornerShape(20.dp)
            )
            .border(
                width = 1.dp,
                color = if (isSelected) {
                    if (isCurrentMealDone) {
                        Color(0xFF001A23).copy(0.7f)
                    } else {
                        Color.Transparent
                    }
                } else {
                    Color(0xFF001A23)
                },
                shape = RoundedCornerShape(20.dp)
            )
            .padding(horizontal = 15.dp, vertical = 10.dp)
    ) {
        if(isCurrentMealDone) {
            Image(
                painter = painterResource(id = R.drawable.ic_check),
                contentDescription = "check",
                colorFilter = ColorFilter.tint(MyColorTheme.darkGreen_dark),
                modifier = Modifier.padding(end = 3.dp)
            )
        }
        Text(
            text = text,
            color =  if (isSelected) {
                if (isCurrentMealDone) {
                    Color(0xFF001A23).copy(0.7f)
                } else {
                    Color.White
                }
            } else {
                Color(0xFF001A23)
            },
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
        )
    }
}

@Composable
fun NutritionInfo(value: String, label: String, color: Color) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 8.dp)
    ) {
        Text(
            text = value,
            style = MaterialTheme.typography.titleLarge,
            color = Color.Black
        )
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(4.dp))
        Box(
            modifier = Modifier
                .width(50.dp)
                .height(10.dp)
                .background(color = color, shape = RoundedCornerShape(50))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MealsItemPreviewScreenPreview() {
    MealsItemPreviewContent(
        navController = rememberNavController(),
        meals =  emptyList(),
        totalCalories= "",
        totalProtein= "",
        totalCarbs= "",
        totalFats= "",
        selectedMeal = "selectedMeal",
        isDialogOpen = false,
        isShowFinishedDialog = false,
        selectionMealClick = {},
        dialogOpenClick = {},
        showFinishedDialogClick = {},
        doneMealClick = {},
        finalizeMealClick = {}
    )
}