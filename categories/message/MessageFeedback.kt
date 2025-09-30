package com.example.fitness.ui.categories.message

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitness.ui.theme.greenMain_light

@Composable
fun MessageFeedbackScreen(navController: NavController) {
    var feedbackText by remember { mutableStateOf(TextFieldValue("")) }
    var feedbackMessages by remember { mutableStateOf(listOf<String>()) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.TopStart)
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Message",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Please enter your feedback ",
                fontSize = 18.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Light,
            )
            Spacer(modifier = Modifier.height(150.dp))


            BasicTextField(
                value = feedbackText,
                onValueChange = { feedbackText = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .border(4.dp, Color.Black)
                    .padding(16.dp),
                singleLine = false,
                decorationBox = { innerTextField ->
                    if (feedbackText.text.isEmpty()) {
                        Text(
                            text = " ",
                            color = Color.Gray
                        )
                    }
                    innerTextField()
                }
            )
        }
        SubmitButton(
            onClick = {
                if (feedbackText.text.isNotBlank()) {
                    feedbackMessages = feedbackMessages + feedbackText.text
                    feedbackText = TextFieldValue("")
                }
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 1.dp, vertical = 1.dp)
        )
    }
}

@Composable
fun SubmitButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier
            .clip(RoundedCornerShape(80))
            .background(color = greenMain_light),
        shape = RoundedCornerShape(80),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
    ) {
        Text(text = "Submit")
    }
}

@Composable
fun FeedbackList(feedbackMessages: List<String>) {
    Column {
        for (message in feedbackMessages) {
            FeedbackItem(message)
        }
    }
}

@Composable
fun FeedbackItem(message: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
    ) {
        Text(
            text = message,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun DefaultPreview() {
    MessageFeedbackScreen(navController = rememberNavController())
}
