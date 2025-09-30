package com.example.fitness.ui.navigation

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitness.R
import com.example.fitness.ui.theme.greenMain_light
import com.example.fitnesstracker.common.Screens

@Composable
fun BottomNavigationBar(selectedScreen: String, onItemSelected: (String) -> Unit) {

    //create default dashboard
    
    var currentScreen = selectedScreen
    if(selectedScreen.isEmpty() || selectedScreen == Screens.LOGIN_SCREEN.screenName){
        currentScreen = Screens.DASHBOARD_SCREEN.screenName
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(0.5.dp)
            .background(greenMain_light))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFFFFFFFF))
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavigationItem(
                iconRes = R.drawable.home,
                label = "Home",
                isSelected = currentScreen == Screens.DASHBOARD_SCREEN.screenName,
                onClick = { onItemSelected(Screens.DASHBOARD_SCREEN.screenName) }
            )
            BottomNavigationItem(
                iconRes = R.drawable.workout,
                label = "Workout",
                isSelected = currentScreen == Screens.WORKOUTPROGRESS_SCREEN.screenName,
                onClick = { onItemSelected(Screens.WORKOUTPROGRESS_SCREEN.screenName) }
            )
            BottomNavigationItem(
                iconRes = R.drawable.meals,
                label = "Meals",
                isSelected = currentScreen == Screens.MEALSPROGRESS_SCREEN.screenName,
                onClick = { onItemSelected(Screens.MEALSPROGRESS_SCREEN.screenName) }
            )
            BottomNavigationItem(
                iconRes = R.drawable.humburger,
                label = "Settings",
                isSelected = currentScreen == Screens.HAMBURGER_SCREEN.screenName,
                onClick = { onItemSelected(Screens.HAMBURGER_SCREEN.screenName) }
            )
        }
    }

}

@Composable
fun BottomNavigationItem(iconRes: Int, label: String, isSelected: Boolean, onClick: () -> Unit) {
    val tint by animateColorAsState(targetValue = if (isSelected) greenMain_light else Color.Gray )
    val textColor by animateColorAsState(targetValue = if (isSelected) greenMain_light else Color.Gray)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 6.dp)
            .clickable(onClick = onClick)
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier
                .size(30.dp)
                .padding(bottom = 4.dp),
            colorFilter = ColorFilter.tint(tint)
        )
        Text(
            text = label,
            color = textColor,
            fontSize = 12.sp
        )
    }
}

@Preview
@Composable
fun BottomNavigationBarPreview(){
    BottomNavigationBar(selectedScreen = Screens.DASHBOARD_SCREEN.screenName ){}
}