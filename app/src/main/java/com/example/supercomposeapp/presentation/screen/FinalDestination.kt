package com.example.supercomposeapp.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.supercomposeapp.presentation.components.TextComponent
import com.example.supercomposeapp.ui.theme.Typography
import com.example.supercomposeapp.ui.theme.darkMagneta

@Composable
fun FinalDestination() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,

        ) {
        TextComponent(
            text = "Final Destination",
            modifier = Modifier,
            textColor = darkMagneta,
            fontSize = 25.sp,
            textStyle = Typography.h2

        )

    }

}