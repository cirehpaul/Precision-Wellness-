package com.example.fitnesstracker.ui.signup

import android.content.Context
import android.content.Intent
import android.net.Uri
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
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.fitness.R
import com.example.fitness.ui.AppViewModelProvider
import com.example.fitness.ui.signup.RegisterViewModel
import com.example.fitness.ui.theme.Lightgreen_dark
import com.example.fitness.ui.theme.greenMain_light
import com.example.fitnesstracker.common.Screens
import kotlinx.coroutines.launch

@Composable
fun RegisterScreen(navController: NavHostController) {
    val registerViewModel: RegisterViewModel = viewModel(factory = AppViewModelProvider.Factory)

    val coroutineScope = rememberCoroutineScope()

    val username = registerViewModel.username
    val password = registerViewModel.password
    val confirmPassword = registerViewModel.confirmPassword
    val registerState = registerViewModel.registerState

    LaunchedEffect(registerState.value) {
        if (registerState.value == RegisterViewModel.RegisterState.SUCCESS) {
            navController.navigate(Screens.LOGIN_SCREEN.screenName)
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
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Login Image",
            modifier = Modifier.size(140.dp)
        )

        Text(fontSize = 36.sp, fontWeight = FontWeight.Bold, text = "Create an account")
        Text(fontSize = 17.sp, text = "Be physically active!")
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            value = username.value,
            onValueChange = { registerViewModel.setUsername(it) },
            label = { Text(
                fontSize = 17.sp,
                color = Color.Black,
                text = "Username") },
            isError = registerState.value == RegisterViewModel.RegisterState.ERROR,
            supportingText = {
                if (registerState.value == RegisterViewModel.RegisterState.ERROR) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = " ",
                        color = MaterialTheme.colorScheme.error
                    )
                }
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = greenMain_light,
            ),
            trailingIcon = {
                if (registerState.value == RegisterViewModel.RegisterState.ERROR) {
                    Icon(Icons.Filled.Warning, "error", tint = MaterialTheme.colorScheme.error)
                }
            }
        )

        Spacer(modifier = Modifier.height(1.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            value = password.value,
            onValueChange = { registerViewModel.setPassword(it) },
            label = { Text(
                text = "Password",
                color = Color.Black ,
                fontSize = 17.sp) },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = greenMain_light,
            ),
            isError = registerState.value == RegisterViewModel.RegisterState.ERROR,
            supportingText = {
                if (registerState.value == RegisterViewModel.RegisterState.ERROR) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.ExtraBold,
                        text = "Password not match ",
                        color = MaterialTheme.colorScheme.error
                    )
                }
            },
            trailingIcon = {
                if (registerState.value == RegisterViewModel.RegisterState.ERROR) {
                    Icon(Icons.Filled.Warning, "error", tint = MaterialTheme.colorScheme.error)
                }
            }
        )

        Spacer(modifier = Modifier.height(1.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            value = confirmPassword.value,
            onValueChange = { registerViewModel.setConfirmPassword(it) },
            label = { Text(
                text = "Confirm Password",
                color = Color.Black,
                fontSize = 17.sp) },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = greenMain_light,
            ),
            isError = registerState.value == RegisterViewModel.RegisterState.ERROR,
            supportingText = {
                if (registerState.value == RegisterViewModel.RegisterState.ERROR) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.ExtraBold,
                        text = "Password not match",
                        color = MaterialTheme.colorScheme.error
                    )
                }
            },
            trailingIcon = {
                if (registerState.value == RegisterViewModel.RegisterState.ERROR) {
                    Icon(Icons.Filled.Warning, "error", tint = MaterialTheme.colorScheme.error)
                }
            }
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                coroutineScope.launch {
                    registerViewModel.registerNewUser()
                } },
            enabled = registerViewModel.enableButton.value,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .clip(RoundedCornerShape(80))
                .background(color = greenMain_light),
            shape = RoundedCornerShape(80),
            colors = ButtonDefaults.outlinedButtonColors(
                disabledContainerColor = Color.Gray,
                contentColor = Color.White)
        ) {
            Text(text = "Create account", fontSize = 17.sp)
        }

        Spacer(modifier = Modifier.height(32.dp))

        val annotatedString = buildAnnotatedString {
            append("Already have an account? ")
            pushStringAnnotation("login", "login")
            withStyle(style = SpanStyle(color = Color(0xFF31A062))) {
                append("Login")
            }
            pop()
        }

        ClickableText(
            text = annotatedString,
            onClick = { offset ->
                annotatedString.getStringAnnotations(offset, offset).firstOrNull()?.let { annotation ->
                    if (annotation.tag == "login") {
                        navController.navigate(Screens.LOGIN_SCREEN.screenName)
                    }
                }
            }
        )

        Spacer(modifier = Modifier.height(32.dp))

        TermsOfUseCheckbox()
    }
}

@Composable
fun TermsOfUseCheckbox() {
    var checked by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Row(
        modifier = Modifier.padding(16.dp)
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it },
            modifier = Modifier.absoluteOffset((9).dp, -11.dp)
        )

        val annotatedString = buildAnnotatedString {
            append("I accept and agree to the ")
            pushStringAnnotation(
                tag = "URL",
                annotation = "https://www.nianticlabs.com/privacy?hl=en"
            )
            withStyle(
                style = SpanStyle(
                    color = Lightgreen_dark,
                    fontSize = 13.sp,
                    textDecoration = TextDecoration.Underline
                )
            ) {
                append("Terms of Use")
            }
            pop()
            append(".")
        }

        ClickableText(
            text = annotatedString,
            onClick = { offset ->
                annotatedString.getStringAnnotations(offset, offset).firstOrNull()?.let { annotation ->
                    if (annotation.tag == "URL") {
                        showTermsAndConditions(context, annotation.item)
                    }
                }
            },
            modifier = Modifier.padding(start = 8.dp),
            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp)
        )
    }
}

fun showTermsAndConditions(context: Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}

data class Datasets(
    val username: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val agreeToTerms: Boolean = false
)

@Preview(showBackground = true)
@Composable
fun RegistrationScreenPrev() {
    val navController = rememberNavController()
    RegisterScreen(navController)
}
