package com.example.fitness.ui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.fitness.ui.theme.MyColorTheme.gradientGray01
import com.example.fitness.ui.theme.greenMain_light

@Composable
fun CommonHeader(
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start,
    text: String,
    subText: String = "",
    fontSize: TextUnit
) {

   Column(modifier = modifier) {
       Text(
           textAlign = textAlign,
           text = text,
           fontSize = 32.sp,
           fontWeight = FontWeight.Bold,
           color = greenMain_light,
           modifier = Modifier
               .fillMaxWidth()
       )
       Text(
           textAlign = textAlign,
           text = subText,
           fontSize = 16.sp,
           fontWeight = FontWeight.Medium,
           color = gradientGray01,
           modifier = Modifier
               .fillMaxWidth()
       )
   }

}
