package com.example.fitness

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.example.fitness.common.Constant
import com.example.fitness.ui.navigation.BottomNavigationBar
import com.example.fitnesstracker.common.Screens
import com.example.fitnesstracker.ui.navigation.NavMainController

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val context = LocalContext.current.applicationContext
            val showBottomForNow = false

            //get selectedScreen from Database
            //default is Screens.LOGIN_SCREEN.screenName
            val defaultScreen = if(Constant.isLogin.value)Screens.DASHBOARD_SCREEN.screenName else Screens.LOGIN_SCREEN.screenName
            var selectedScreen by remember { mutableStateOf(defaultScreen) }

            //if already done in login
            Scaffold(
                bottomBar = {
                    if(Constant.isShowBottomNav.value || Constant.isLogin.value){
                        BottomNavigationBar(selectedScreen) { screenName ->
                            selectedScreen = screenName
                        }
                    }
                }
            ) { paddingValues ->
                NavMainController(
                    modifier = Modifier.padding(paddingValues),
                    navController = navController, startDestination = selectedScreen)
            }

        }
    }
}
