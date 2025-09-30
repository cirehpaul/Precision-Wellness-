package com.example.fitness.ui.categories.workout.item

import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.example.fitness.R
import com.example.fitness.domain.dto.WorkoutItemDto
import com.example.fitness.ui.common.PrimaryButton

@Composable
fun WorkoutItemPreviewDialog(
    modifier: Modifier = Modifier,
    workoutItemDto: WorkoutItemDto,
    isLastWorkout: Boolean = false,
    backOnClick: () -> Unit,
    onDoneClick: () -> Unit,
    onWorkoutFinishedClick: () -> Unit
) {
    val imageLoader = rememberImageLoader()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White)
            .clip(RoundedCornerShape(16.dp)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Backbutton(onClick = backOnClick)

        WorkoutGif(gifResId = workoutItemDto.imageRes, imageLoader = imageLoader)

        Spacer(modifier = Modifier.height(16.dp))
        ExerciseInfo(exerciseName = workoutItemDto.workoutName, reps = "${workoutItemDto.reps}")

        Spacer(modifier = Modifier.height(16.dp))
        NavigationOptions(isLastWorkout = isLastWorkout, onClick = {
            if (isLastWorkout) onWorkoutFinishedClick() else onDoneClick()
        })
    }
}

@Composable
private fun Backbutton(onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { onClick() }) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
        }
    }
}

@Composable
private fun WorkoutGif(gifResId: Int, imageLoader: ImageLoader) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                model = gifResId,
                imageLoader = imageLoader
            ),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillHeight
        )
    }
}

@Composable
private fun ExerciseInfo(exerciseName: String, reps: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = exerciseName,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            fontStyle = FontStyle.Italic,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "×$reps",
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            color = Color.Black
        )
    }
}

@Composable
private fun NavigationOptions(
    isLastWorkout: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 20.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        PrimaryButton(
            iconSuffix = if (isLastWorkout) R.drawable.ic_flag else R.drawable.ic_check,
            text = if (isLastWorkout) "FINISH WORKOUT" else "DONE",
            onClick = onClick
        )
    }
}

@Composable
private fun rememberImageLoader(): ImageLoader {
    val context = LocalContext.current
    return ImageLoader.Builder(context)
        .components {
            if (Build.VERSION.SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()
}

