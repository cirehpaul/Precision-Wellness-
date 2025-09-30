package com.example.fitnesstracker.ui.categories

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import com.example.fitness.common.BodyType
import com.example.fitness.common.Constant
import com.example.fitness.common.Gender
import com.example.fitness.ui.AppViewModelProvider
import com.example.fitness.ui.categories.bodytype.BodyTypeViewModel
import com.example.fitness.ui.common.CommonHeader
import com.example.fitness.ui.theme.darkGreen_dark
import com.example.fitness.ui.theme.greenMain_light
import com.example.fitnesstracker.common.Screens
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun BodyTypeScreen(navController: NavController,) {

    val bodytypeViewModel: BodyTypeViewModel = viewModel(factory = AppViewModelProvider.Factory)

    var selectedBodyType by remember { mutableStateOf(BodyType.BEGINNER) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        CommonHeader(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            text = "Body Type Level",
            subText =  "Choose your body type level.",
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(100.dp))

        Image(
            modifier = Modifier
                .width(350.dp)
                .height(230.dp)
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 9.dp),
            painter = painterResource(id = getBodyTypeResourceId(selectedBodyType)),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
        )
        Spacer(modifier = Modifier.height(15.dp))

        ToggleButtons(
            selectedType = selectedBodyType,
            onTypeSelected = { selectedBodyType = it }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                CoroutineScope(Dispatchers.IO).launch {
                    bodytypeViewModel.saveBodytype(selectedBodyType.name)
                }
                navController.navigate(Screens.BODYFAT_SCREEN.screenName)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .clip(RoundedCornerShape(80)),
            shape = RoundedCornerShape(80),
            colors = ButtonDefaults.buttonColors(
                containerColor = greenMain_light,
                contentColor = Color.White
            ),
            enabled = true
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
    selectedType: BodyType,
    onTypeSelected: (BodyType) -> Unit,
) {
    Column {
        BodyType.values().forEach { type ->
            ButtonRow(
                bodyType = type,
                selectedType = selectedType,
                onTypeSelected = onTypeSelected
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun ButtonRow(
    bodyType: BodyType,
    selectedType: BodyType,
    onTypeSelected: (BodyType) -> Unit
) {
    OutlinedButton(
        onClick = { onTypeSelected(bodyType) },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        border = BorderStroke(1.dp, color = greenMain_light),
        shape = RoundedCornerShape(100),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = if (selectedType == bodyType) darkGreen_dark else Color.Transparent,
            contentColor = if (selectedType == bodyType) Color.White else darkGreen_dark
        )
    ) {
        Text(fontSize = 17.sp, text = bodyType.name.capitalize())
    }
}



fun getGenderImageId(): Int {
    return if (Constant.getgender.value == Gender.MALE) {
        R.drawable.males
    } else {
        R.drawable.fems
    }
}


@Composable
fun getBodyTypeResourceId(bodyType: BodyType): Int {
    return when (bodyType) {
        BodyType.BEGINNER -> if (Constant.getgender.value == Gender.MALE) R.drawable.beginer else R.drawable.g_beginner
        BodyType.INTERMEDIATE -> if (Constant.getgender.value == Gender.MALE) R.drawable.intermediate else R.drawable.g_intermediate
        BodyType.ADVANCE -> if (Constant.getgender.value == Gender.MALE) R.drawable.advance else R.drawable.g_advanced
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun BodyTScreenPreview() {
    BodyTypeScreen(rememberNavController())
}
