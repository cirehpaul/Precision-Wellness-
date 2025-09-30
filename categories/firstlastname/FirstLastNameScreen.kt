package com.example.fitness.ui.categories.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitness.ui.AppViewModelProvider
import com.example.fitness.ui.categories.firstlastname.FirstLastNameViewModel
import com.example.fitness.ui.common.CommonHeader
import com.example.fitness.ui.theme.greenMain_light
import com.example.fitnesstracker.common.Screens
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun FirstLastNameScreen(navController: NavController) {

    val firstLastNameViewModel: FirstLastNameViewModel = viewModel(factory = AppViewModelProvider.Factory)

    var firstname by remember { mutableStateOf(TextFieldValue("")) }
    var lastname by remember { mutableStateOf(TextFieldValue("")) }
    var age by remember { mutableStateOf("") }


        Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
            Spacer(modifier = Modifier.height(32.dp))
            CommonHeader(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                text = "Enter your details",
                subText =  "A dynamic professional with a passion for innovation.",
                fontSize = 16.sp
            )

        Spacer(modifier = Modifier.height(125.dp))

        // First Name Input
        OutlinedTextField(
                value = firstname,
                onValueChange = { firstname = it },
                label = { Text("First Name",color = Color.Black) },
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = greenMain_light,
                ),
            )
        Spacer(modifier = Modifier.height(12.dp))

        // Last Name Input
        OutlinedTextField(
            value = lastname,
            onValueChange = { lastname = it },
            label = { Text("Last Name",color = Color.Black) },
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.fillMaxWidth(),
         colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = greenMain_light,
         ),
        )
        Spacer(modifier = Modifier.height(12.dp))
        // Age Input
        OutlinedTextField(

            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = true,
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            value = age,
            onValueChange = { age = it },
            label = { Text("Age",color = Color.Black) },
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = greenMain_light,
            )
        )
        Spacer(modifier = Modifier.height(200.dp))

        Button(
            onClick = {
                CoroutineScope(Dispatchers.IO).launch {
                    firstLastNameViewModel.saveNaming(firstname = firstname.text,lastname = lastname.text, age = age)
                }
                navController.navigate(Screens.GENDER_SCREEN.screenName)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .clip(RoundedCornerShape(80))
                .background(color = greenMain_light),
            shape = RoundedCornerShape(80),
            colors = ButtonDefaults.textButtonColors(contentColor = Color.White)
        ) {
            Text(
                text = "CONTINUE",
                fontSize = 17.sp,
                color = Color.White
            )
        }
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun FirstLastNameScreenPreview() {
    FirstLastNameScreen(rememberNavController())
}
