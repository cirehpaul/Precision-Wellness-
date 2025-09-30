package com.example.fitnesstracker.ui.categories

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitness.R
import com.example.fitness.common.BodyFatLevel
import com.example.fitness.common.Constant
import com.example.fitness.common.Gender
import com.example.fitness.ui.AppViewModelProvider
import com.example.fitness.ui.categories.bodyfat.BodyFatViewModel
import com.example.fitness.ui.common.CommonHeader
import com.example.fitness.ui.theme.darkGreen_dark
import com.example.fitness.ui.theme.greenMain_light
import com.example.fitnesstracker.common.Screens
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun BodyFatScreen(navController: NavController) {

    val bodyfatViewModel: BodyFatViewModel = viewModel(factory = AppViewModelProvider.Factory)

    var selectedBodyFatLevel by remember { mutableStateOf(BodyFatLevel.LEAN) }

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
            text = "Body Fat Level",
            subText =  "Choose your Body level.",
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = getBodyFatLevelResourceId(selectedBodyFatLevel)),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(330.dp)
                .padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        ToggleButtons(
            selectedBodyFatLevel = selectedBodyFatLevel,
            onBodyFatLevelSelected = { level ->
                selectedBodyFatLevel = level
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                CoroutineScope(Dispatchers.IO).launch {
                    bodyfatViewModel.saveBodyFat(selectedBodyFatLevel.name)
                }
                when (selectedBodyFatLevel) {
                    BodyFatLevel.LEAN -> navController.navigate(Screens.GOALSLEAN_SCREEN.screenName)
                    BodyFatLevel.ATHLETIC -> navController.navigate(Screens.BODYGOALS_SCREEN.screenName)
                    BodyFatLevel.NATURAL -> navController.navigate(Screens.GOALSNATURAL_SCREEN.screenName)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .clip(RoundedCornerShape(80))
                .background(color = greenMain_light),
            shape = RoundedCornerShape(80),
            colors = ButtonDefaults.buttonColors(
                containerColor = greenMain_light,
                contentColor = Color.White
            ),
            enabled = selectedBodyFatLevel != null
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
    selectedBodyFatLevel: BodyFatLevel,
    onBodyFatLevelSelected: (BodyFatLevel) -> Unit,
) {
    Column {
        BodyFatLevel.values().forEach { level ->
            ButtonRow(
                bodyFatLevel = level,
                selectedBodyFatLevel = selectedBodyFatLevel,
                onBodyFatLevelSelected = onBodyFatLevelSelected
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun ButtonRow(
    bodyFatLevel: BodyFatLevel,
    selectedBodyFatLevel: BodyFatLevel,
    onBodyFatLevelSelected: (BodyFatLevel) -> Unit
) {
    OutlinedButton(
        onClick = { onBodyFatLevelSelected(bodyFatLevel) },
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp),
        border = BorderStroke(1.dp, color = greenMain_light),
        shape = RoundedCornerShape(100),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = if (selectedBodyFatLevel == bodyFatLevel) darkGreen_dark else Color.Transparent,
            contentColor = if (selectedBodyFatLevel == bodyFatLevel) Color.White else darkGreen_dark
        )
    ) {
        Text(fontSize = 17.sp, text = bodyFatLevel.name.capitalize())
    }
}


fun getGenderImgId(): Int {
    return if (Constant.getgender.value == Gender.MALE) {
        R.drawable.males
    } else {
        R.drawable.fems
    }
}

@Composable
fun getBodyFatLevelResourceId(bodyFatLevel: BodyFatLevel): Int {
    return when (bodyFatLevel) {
        BodyFatLevel.LEAN ->  if (Constant.getgender.value == Gender.MALE) R.drawable.lean else R.drawable.g_lean
        BodyFatLevel.ATHLETIC ->if (Constant.getgender.value == Gender.MALE) R.drawable.natural else R.drawable.g_athletic
        BodyFatLevel.NATURAL -> if (Constant.getgender.value == Gender.MALE) R.drawable.athletic else R.drawable.g_natural
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun BodyFScreenPreview() {
    BodyFatScreen(rememberNavController())
}
