package com.example.fitness.ui.login

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.fitness.ui.AppViewModelProvider
import com.example.fitness.ui.common.PrimaryButton
import com.example.fitness.ui.common.SharedViewModel
import com.example.fitness.ui.theme.greenMain_light
import com.example.fitnesstracker.common.Screens
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.compose.material3.Text as Text

@Composable
fun LoginScreen(navController: NavController, sharedViewModel: SharedViewModel) {

    val loginViewModel: LoginViewModel = viewModel(factory = AppViewModelProvider.Factory)

    val coroutineScope = rememberCoroutineScope()

    val username = loginViewModel.username
    val password = loginViewModel.password
    var passwordVisible by remember { mutableStateOf(false) }
    val loginState = loginViewModel.loginState

    //Side effect - check only when the loginState variable was changed from the loginViewModel
    LaunchedEffect(loginState.value) {
        if(loginState.value == LoginState.SUCCESS){
            //TODO TO ADD ALSO TO SIGN UP PAGE
            CoroutineScope(Dispatchers.IO).launch{
                //get the current Day Meal
                sharedViewModel.setCurrentDayMeals{
                    CoroutineScope(Dispatchers.Main).launch{
                        //wait for the load of content to Finish
                        navController.navigate(Screens.FIRSTLAST_SCREEN.screenName)
                    }
                }
            }
        }else if(loginState.value == LoginState.SUCCESS_SKIP_TO_DASHBOARD){
            CoroutineScope(Dispatchers.IO).launch{
                //get the current Day Meal
                sharedViewModel.setCurrentDayMeals{
                    CoroutineScope(Dispatchers.Main).launch{
                        //wait for the load of content to Finish
                        navController.navigate(Screens.DASHBOARD_SCREEN.screenName)
                    }
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
           painter = painterResource(id = com.example.fitness.R.drawable.logo),
            contentDescription = "Login Image",
            modifier = Modifier.size(260.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = username.value,
            onValueChange = {
                loginViewModel.setUsername(it)
            },
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = greenMain_light,
            ),
            label = { Text(
                fontSize = 17.sp,
                color = Color.Black,
                text = "Username") },
            isError =  loginState.value == LoginState.ERROR,
            supportingText = {
                if ( loginState.value == LoginState.ERROR) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Wrong username detected",
                        color = MaterialTheme.colorScheme.error
                    )
                }
            },
            trailingIcon = {
                if ( loginState.value == LoginState.ERROR) {
                    Icon(Icons.Filled.Warning, "error", tint = MaterialTheme.colorScheme.error)
                }
            }
        )

        Spacer(modifier = Modifier.height(1.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            value = password.value,
            onValueChange = {
                loginViewModel.setPassword(it)
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = greenMain_light,
            ),
            label = { Text(
                text = "Password",
                color = Color.Black,
                fontSize = 17.sp) },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            isError = loginState.value == LoginState.ERROR,
            supportingText = {
                if ( loginState.value == LoginState.ERROR) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.ExtraBold,
                        text = "Wrong password detected",
                        color = MaterialTheme.colorScheme.error
                    )
                }
            },
            trailingIcon = {
                if ( loginState.value == LoginState.ERROR) {
                    Icon(Icons.Filled.Warning, "error", tint = MaterialTheme.colorScheme.error)
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        PrimaryButton(
            enabled = loginViewModel.enableButton.value,
            text = "Log in",
        ){
            CoroutineScope(Dispatchers.IO).launch {
                loginViewModel.performLogin()
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
        SignUpText(navController)
        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun SignUpText(navController: NavController) {
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Black, fontWeight = FontWeight.Bold)) {
            append("Don't have an account? ")
        }
        withStyle(style = SpanStyle(color = greenMain_light)) {
            append("Sign Up")
        }
    }

    ClickableText(
        text = annotatedString,
        onClick = {
            navController.navigate(Screens.REGISTER_SCREEN.screenName)
        }
    )
}
