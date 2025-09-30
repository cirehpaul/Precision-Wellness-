package com.example.fitness.ui.help

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HelpScreen(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()), // Enable vertical scrolling
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Help & Support",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            val sectionModifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .background(Color(0xFFF0F0F0), RoundedCornerShape(8.dp))
                .padding(16.dp)

            // Getting Started Section
            Column(modifier = sectionModifier) {
                Text(
                    text = "Getting Started",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Learn how to set up your account and navigate the app effectively."
                )
            }

            // Workout Guidance Section
            Column(modifier = sectionModifier) {
                Text(
                    text = "Workout Guidance",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Access a library of exercises and personalized workout plans."
                )
            }

            // Nutrition Support Section
            Column(modifier = sectionModifier) {
                Text(
                    text = "Nutrition Support",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Get tips on meal planning and logging your nutritional intake."
                )
            }

            // Tracking Progress Section
            Column(modifier = sectionModifier) {
                Text(
                    text = "Tracking Progress",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Learn how to track your workouts and set fitness goals."
                )
            }

            // Troubleshooting Section
            Column(modifier = sectionModifier) {
                Text(
                    text = "Troubleshooting",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Find solutions to common issues and learn about offline functionality."
                )
            }

            // Community and Support Section
            Column(modifier = sectionModifier) {
                Text(
                    text = "Community and Support",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Connect with fellow users for motivation and assistance."
                )
            }

            // Additional Resources Section
            Column(modifier = sectionModifier) {
                Text(
                    text = "Additional Resources",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Access articles, videos, and fitness challenges to enhance your journey."
                )
            }
        }
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun HelpScreenPreview() {
    HelpScreen(navController = rememberNavController())
}
