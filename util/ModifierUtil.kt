package com.example.fitness.util

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Modifier.defaultPadding(): Modifier{
    return this.padding(18.dp)
}

@Composable
fun Modifier.defaultPaddingStart(): Modifier{
    return this.padding(start = 18.dp)
}