
package com.example.fitness.ui.common

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitness.ui.theme.MyColorTheme

@Composable
fun CommonDayCircleProgress(day: Int,hasExtraLine: Boolean, isCompleted: Boolean, isClickable: Boolean, onDayClick: () -> Unit) {
    val transitionState = remember { MutableTransitionState(false).apply { targetState = isCompleted } }
    val transition = updateTransition(transitionState, label = "DayTransition")

    val scale by transition.animateFloat(
        label = "ScaleAnimation",
        transitionSpec = { tween(durationMillis = 500) }
    ) { state ->
        if (state) 1.5f else 0.8f
    }

    val rotation by transition.animateFloat(
        label = "RotationAnimation",
        transitionSpec = { tween(durationMillis = 300) }
    ) { state ->
        if (state) 360f else 0f
    }

    val backgroundColor = if (isCompleted) {
        Brush.linearGradient(
            //colors = listOf(MyColorTheme.yellow, MyColorTheme.green)
            colors = listOf(MyColorTheme.greenMain_light, MyColorTheme.brumswick_green)
        )
    } else {
        Brush.linearGradient(
            colors = listOf(Color(0xFFE0E0E0), Color(0xFFBDBDBD))
        )
    }
    if(hasExtraLine){
        Spacer(modifier = Modifier
            .height(2.dp)
            .width(5.dp)
            .background(MyColorTheme.gradientGray01))
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(35.dp)
            .clip(CircleShape)
            .background(brush = backgroundColor)
            .border(
                if (isCompleted) 1.dp else 2.dp,
                if (isCompleted) MyColorTheme.greenMain_light else Color.LightGray,
                CircleShape
            )
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
                //rotationZ = rotation
            }
            .clickable(enabled = isClickable) {
                if (isClickable) onDayClick()  //TODO disable click for now
            }
            .semantics {
                contentDescription =
                    "Day $day ${if (isCompleted) "Completed" else "Incomplete"}"
            }
    ) {
        Text(
            text = if(isCompleted) "✓" else "$day",
            fontSize =  if(isCompleted) 18.sp else 15.sp,
            fontWeight = if (isCompleted) FontWeight.Black else FontWeight.Normal,
            color = if (isCompleted) Color.White else Color.DarkGray
        )
    }
}

@Composable
fun TrophyOfExcellence() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(CircleShape)
            .padding(bottom = 5.dp)
            .semantics { contentDescription = "Trophy of Excellence" }
    ) {
        Text(text = "🏆", fontSize = 28.sp)
    }
}

//to update the Text and progress
fun updateCompletedIndexValues(completedDaysList: SnapshotStateList<Int>, workWeek: Int, workDay: Int): SnapshotStateList<Int> {
    //update each index if there are new weeks
    //add less than week (<) to not affect the result of actual work week
    (0..<workWeek).forEach{ index ->
        completedDaysList[index] = 7 //add seven (7) since the workout for each was already over
    }
    completedDaysList[workWeek] = workDay

    return completedDaysList
}
