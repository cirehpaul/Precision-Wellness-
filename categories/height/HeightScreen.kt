package com.example.fitness.ui.categories.height

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitness.R
import com.example.fitness.common.Gender
import com.example.fitness.ui.AppViewModelProvider
import com.example.fitness.ui.common.CommonHeader
import com.example.fitness.ui.theme.greenMain_light
import com.example.fitnesstracker.common.Screens
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun HeightScreen(navController: NavController, gender: String = Gender.MALE.name) {

    val heightViewModel: HeightViewModel = viewModel(factory = AppViewModelProvider.Factory)

    var height by remember { mutableFloatStateOf(150f) } // Starting height in the middle of the range
    val minHeight = 100f
    val maxHeight = 226.06f

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.TopStart)
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            CommonHeader(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                text = "Height",
                subText =  "Slide to set your height.",
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(32.dp))
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 9.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    text = "${height.toInt()} cm"
                )
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    Image(
                        painter = painterResource(id = getGenderResourceId(gender)),
                        contentDescription = null,
                        contentScale = ContentScale.FillHeight,
                        modifier = Modifier
                            .width(150.dp)
                            .height((height * 2).dp)
                            .padding(bottom = 16.dp)
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .padding(vertical = 9.dp)
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Slider(
                value = height,
                onValueChange = { height = it },
                valueRange = minHeight..maxHeight,
                modifier = Modifier.padding(horizontal = 16.dp),
                colors = SliderDefaults.colors(
                    thumbColor = greenMain_light,
                    activeTrackColor = greenMain_light
                )
            )

            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    CoroutineScope(Dispatchers.IO).launch {
                        heightViewModel.saveHeight(height.toString())
                    }
                    navController.navigate(Screens.WEIGHT_SCREEN.screenName + "/${gender}")
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
}

fun getGenderResourceId(gender: String): Int {
    return if (gender == Gender.MALE.name) {
        R.drawable.males
    } else {
        R.drawable.fems
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun HeightScreenPreview() {
    HeightScreen(rememberNavController())
}
