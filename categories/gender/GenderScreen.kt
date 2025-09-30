package com.example.fitnesstracker.ui.categories

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitness.R
import com.example.fitness.common.Constant
import com.example.fitness.common.Gender
import com.example.fitness.ui.AppViewModelProvider
import com.example.fitness.ui.categories.gender.GenderViewModel
import com.example.fitness.ui.common.CommonHeader
import com.example.fitness.ui.theme.greenMain_light
import com.example.fitnesstracker.common.Screens
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun GenderScreen(navController: NavController) {

    val genderViewModel: GenderViewModel = viewModel(factory = AppViewModelProvider.Factory)
    var selectedGender by remember { mutableStateOf(Gender.DEFAULT) }

    Surface(color = MaterialTheme.colorScheme.background) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        ) {
            Column(
                modifier = Modifier.align(Alignment.TopStart)
            ) {
                Spacer(modifier = Modifier.height(32.dp))
                CommonHeader(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),
                    text = "Gender",
                    subText =  "Please select according to your gender.",
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(180.dp))
            }


            Column(
                modifier = Modifier.align(Alignment.Center),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                GenderSelection(selectedGender) { gender ->
                    selectedGender = gender
                }
                Spacer(modifier = Modifier.height(32.dp))
            }
            MyButton(
                modifier = Modifier.align(Alignment.BottomCenter),
                navController = navController,
                selectedGender = selectedGender.name){
                CoroutineScope(Dispatchers.IO).launch {
                    genderViewModel.saveGender(selectedGender.name)
                }
                navController.navigate(Screens.HEIGHT_SCREEN.screenName + "/${selectedGender}")
                Constant.getgender.value = selectedGender
            }
        }
    }
}

@Composable
fun GenderButton(
    text: String,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    imageResource: Int,
    onGenderSelected: () -> Unit
) {
    Box(
        modifier = modifier
            .size(180.dp)
            .clickable { onGenderSelected() },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(6.dp)),
            colorFilter = if (isSelected) null else ColorFilter.tint(Color.Gray)
        )
    }
}

@Composable
fun GenderSelection(selectedGender: Gender, onGenderSelected: (Gender) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        GenderButton(
            text = "Male",
            isSelected = selectedGender == Gender.MALE,
            modifier = Modifier
                .size(190.dp, 278.dp)
                .align(Alignment.CenterVertically),
            imageResource = R.drawable.males
        ) {
            onGenderSelected(Gender.MALE)
        }
        Spacer(modifier = Modifier.width(16.dp)) // Adjust the width as needed
        GenderButton(
            text = "Female",
            isSelected = selectedGender == Gender.FEMALE,
            modifier = Modifier
                .size(190.dp, 278.dp)
                .align(Alignment.CenterVertically),
            imageResource = R.drawable.fems
        ) {
            onGenderSelected(Gender.FEMALE)
        }
    }
}

@Composable
fun MyButton(modifier: Modifier, navController: NavController, selectedGender: String, onClick: () -> Unit) {
    Button(
        onClick = {
            onClick()
        },
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .clip(RoundedCornerShape(80)),
        shape = RoundedCornerShape(80),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selectedGender.isNotEmpty()) greenMain_light else Color.Gray,
            contentColor = Color.White
        ),
        enabled = selectedGender.isNotEmpty()
    ) {
        Text(
            text = "CONTINUE",
            fontSize = 17.sp
        )
    }
}




@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun GenderScreenPreview() {
    GenderScreen(rememberNavController())
}
