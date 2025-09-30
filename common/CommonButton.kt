package com.example.fitness.ui.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitness.R
import com.example.fitness.ui.theme.greenMain_light
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun PrimaryButton(modifier: Modifier = Modifier, text: String, @DrawableRes iconSuffix: Int? = null, enabled: Boolean = true, onClick:() -> Unit){
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clip(RoundedCornerShape(80))
            .background(color = greenMain_light),
        shape = RoundedCornerShape(80),
        colors = ButtonDefaults.outlinedButtonColors(
            disabledContainerColor = Color.Gray,
            contentColor = Color.White),
    ) {

        Row(){
            iconSuffix?.let{
                Image(
                    painter = painterResource(id = iconSuffix),
                    contentDescription = "Login Image",
                    modifier = Modifier.padding(end = 5.dp)
                )
            }
            Text(text = text, fontSize = 17.sp)
        }

    }
}

@Preview
@Composable
private fun ButtonPreview(){
    PrimaryButton(
        iconSuffix =  R.drawable.ic_check,
        text = "DONE",
    ){

    }
}