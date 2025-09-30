package com.example.fitnesstracker.ui.categories

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.fitness.ui.AppViewModelProvider
import com.example.fitness.ui.categories.goals.BodyGoalsViewModel
import com.example.fitness.ui.common.CommonHeader
import com.example.fitness.ui.theme.darkGreen_dark
import com.example.fitness.ui.theme.greenMain_light
import com.example.fitnesstracker.common.Screens
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun BodyGoalsScreen(navController: NavController) {

    val bodyGoalsViewModel: BodyGoalsViewModel = viewModel(factory = AppViewModelProvider.Factory)
    var selectedBodyfatEnums by remember { mutableStateOf(GoalsAthEnum.ENHANCE) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        CommonHeader(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            text = "Athletic",
            subText =  "Please choose your goals.",
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(190.dp))
        ToggleButtons(
            typeClicked = selectedBodyfatEnums,
            onClick = { userClickedType ->
                selectedBodyfatEnums = userClickedType

            })

        Spacer(modifier = Modifier.height(100.dp))

        Button(
            onClick = {
                CoroutineScope(Dispatchers.IO).launch {
                    bodyGoalsViewModel.saveGoals(selectedBodyfatEnums.name)
                }
                navController.navigate(Screens.DASHBOARD_SCREEN.screenName)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .clip(RoundedCornerShape(80))
                .background(color = greenMain_light),
            shape = RoundedCornerShape(80),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
        ) {
            Text(
                text = "CONTINUE",
                fontSize = 17.sp,
                color = Color.White
            )
        }
    }
}



@Composable
fun ToggleButtons(
    typeClicked: GoalsAthEnum,
    onClick: (GoalsAthEnum) -> Unit
) {
    OutlinedButton(
        onClick = { onClick(GoalsAthEnum.ENHANCE) },
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        border = BorderStroke(1.dp, color = greenMain_light),
        shape = RoundedCornerShape(100),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = if (typeClicked == GoalsAthEnum.ENHANCE) darkGreen_dark else Color.Transparent,
            contentColor = if (typeClicked == GoalsAthEnum.ENHANCE) Color.White else darkGreen_dark
        )
    ) {
        Text(fontSize = 17.sp, text = "Enhance athletic performance")
    }

    Spacer(modifier = Modifier.height(20.dp))

    OutlinedButton(
        onClick = { onClick(GoalsAthEnum.BUILD) },
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        border = BorderStroke(1.dp, color = greenMain_light),
        shape = RoundedCornerShape(100),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = if (typeClicked == GoalsAthEnum.BUILD) darkGreen_dark else Color.Transparent,
            contentColor = if (typeClicked == GoalsAthEnum.BUILD) Color.White else darkGreen_dark
        )
    ) {
        Text(fontSize = 17.sp, text = "Build lean muscle mass")
    }

    Spacer(modifier = Modifier.height(20.dp))

    OutlinedButton(
        onClick = { onClick(GoalsAthEnum.ENDURANCE) },
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        border = BorderStroke(1.dp, color = greenMain_light),
        shape = RoundedCornerShape(100),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = if (typeClicked == GoalsAthEnum.ENDURANCE) darkGreen_dark else Color.Transparent,
            contentColor = if (typeClicked == GoalsAthEnum.ENDURANCE) Color.White else darkGreen_dark
        )
    ) {
        Text(fontSize = 17.sp, text = "Increase agility and endurance")
    }

    Spacer(modifier = Modifier.height(20.dp))
}

enum class GoalsAthEnum {
    ENHANCE,
    BUILD,
    ENDURANCE,
}



