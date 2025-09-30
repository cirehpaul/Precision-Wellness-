import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
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
import com.example.fitness.ui.theme.greenMain_light
import com.example.fitnesstracker.common.Screens

import com.example.fitness.ui.categories.height.getGenderResourceId
import com.example.fitness.ui.categories.weight.WeightViewModel
import com.example.fitness.ui.common.CommonHeader
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun WeightScreen(navController: NavController, gender: String = Gender.MALE.name) {

    val weightViewModel: WeightViewModel = viewModel(factory = AppViewModelProvider.Factory)
    var weight by remember { mutableStateOf(60f) } // Starting weight
    val minWeight = 20f
    val maxWeight = 200f

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
                text = "Weight",
                subText =  "Slide to set your weight.",
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
                    text = "${weight.toInt()} kg"
                )
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(bottom = 80.dp)
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = getGenderResourceId(gender)),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxSize()
                            .width(150.dp)
                            .aspectRatio(1f) // Ensure image maintains aspect ratio
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
                value = weight,
                onValueChange = { weight = it },
                valueRange = minWeight..maxWeight,
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
                        weightViewModel.saveWeight(weight.toString())
                    }
                    navController.navigate(Screens.BODYTYPE_SCREEN.screenName)

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
                    fontSize = 17.sp
                )
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

}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun WeightScreenPreview() {
    WeightScreen(rememberNavController())
}
