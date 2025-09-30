package com.example.fitness.ui.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.fitness.R
import com.example.fitness.ui.theme.greenMain_light
import androidx.compose.material.*
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.*
import androidx.compose.ui.window.DialogProperties


@Composable
fun DialogSuccess(modifier: Modifier = Modifier,
                  @DrawableRes icon: Int =R.drawable.ic_success,
                  text: String = "Updated successfully ",
                  buttonText: String = "OKAY",
                  onclick: () -> Unit) {

    Dialog(onDismissRequest = {  onclick() },
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false,
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(.99f)
                .padding(horizontal = 16.dp)
               // .align(Alignment.Center)
                .background(
                    Color.White, RoundedCornerShape(20.dp)
                )
                .border(
                    1.dp, Color(0xFFBDBDBD),
                    RoundedCornerShape(20.dp)
                )
                .clip(RoundedCornerShape(10.dp))
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = "Login Image",
                modifier = Modifier.size(110.dp)
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Normal,
                text = text,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
            )
            Button(
                onClick = onclick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = greenMain_light,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp)
                    .padding(16.dp),
            ){
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    fontWeight = FontWeight.Normal,
                    text = buttonText,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Composable
fun DialogConfirmation(modifier: Modifier = Modifier,
                       @DrawableRes icon: Int =R.drawable.goals,
                       text: String = " ",
                       buttonYesText: String = "Yes",
                       buttonNoText: String = "No",
                       onYesClick: () -> Unit,
                       onNoClick: () -> Unit,
                       ) {
    Dialog(onDismissRequest = {  onNoClick() },
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false,
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(.99f)
                .padding(horizontal = 16.dp)
                .background(
                    Color.White, RoundedCornerShape(20.dp)
                )
                .border(
                    1.dp, Color(0xFFBDBDBD),
                    RoundedCornerShape(20.dp)
                )
                .clip(RoundedCornerShape(10.dp))
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = "Login Image",
                modifier = Modifier.size(110.dp)
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Normal,
                text = text,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
            )
            Row(modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly) {
                Button(
                    onClick = onYesClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = greenMain_light,
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .widthIn(min = 150.dp)
                        .padding(vertical = 12.dp)
                        .padding(16.dp),
                ){
                    Text(
                        fontWeight = FontWeight.Normal,
                        text = buttonYesText,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                    )
                }

                Button(
                    onClick = onNoClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .widthIn(min = 150.dp)
                        .padding(vertical = 12.dp)
                        .padding(16.dp),
                ){
                    Text(
                        fontWeight = FontWeight.Normal,
                        text = buttonNoText,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}



@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun DialogConfirmationPreview() {
    DialogConfirmation(
        text = "Are you sure?",

        onYesClick = {

        },
        onNoClick = {

        }
    )
}


