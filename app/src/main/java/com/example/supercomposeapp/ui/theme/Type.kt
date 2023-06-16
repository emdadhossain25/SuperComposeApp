package com.example.supercomposeapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.supercomposeapp.R

val Bariol = FontFamily(
    Font(R.font.bariol_regular, weight = FontWeight.Normal),
    Font(R.font.bariol_bold, weight = FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    h3 = TextStyle(
        fontFamily = Bariol,
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp
    ),
    h5 = TextStyle(
        fontFamily = Bariol,
        fontWeight = FontWeight.Normal,
        fontSize = 25.sp
    )
)