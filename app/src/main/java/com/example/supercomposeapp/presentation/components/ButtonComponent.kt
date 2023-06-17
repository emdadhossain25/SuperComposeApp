package com.example.supercomposeapp.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.supercomposeapp.ui.theme.Bariol
import com.example.supercomposeapp.ui.theme.Typography
import com.example.supercomposeapp.ui.theme.darkMagneta
import com.example.supercomposeapp.ui.theme.white

@Composable
fun ButtonComponent(
    text: String,
    backgroundColor: Color,
    contentColor: Color,
    enabled: Boolean = true,
    onButtonClick: () -> Unit,
    isLoading: Boolean,
    modifier: Modifier = Modifier,
    borderColor: Color,
    buttonHeight: Dp,
    fontSize: TextUnit = 15.sp,
    style: TextStyle

) {
    Button(
        modifier = modifier.height(buttonHeight),
        onClick = {
            onButtonClick()
        },
        shape = RoundedCornerShape(25.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = contentColor,
            disabledBackgroundColor = backgroundColor,
            disabledContentColor = contentColor
        ),
        enabled = enabled,
        border = BorderStroke(
            width = 2.dp,
            color = borderColor
        )

    ) {
        if (isLoading) {
            CircularProgressIndicator(
                color = contentColor,
                modifier = Modifier.size(20.dp)
            )
        } else {
            Text(
                fontFamily = Bariol,
                style = style,
                text = text,
                fontSize = fontSize
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ButtonComponentPreview() {
    Column() {

        ButtonComponent(
            text = "Login",
            backgroundColor = darkMagneta,
            contentColor = white,
            onButtonClick = { /*TODO*/ },
            isLoading = false,
            modifier = Modifier.fillMaxWidth(),
            borderColor = white,
            buttonHeight = 40.dp,
            fontSize = 20.sp,
            style = Typography.h1

        )
        ButtonComponent(
            text = "Signup",
            backgroundColor = white,
            contentColor = darkMagneta,
            onButtonClick = { /*TODO*/ },
            isLoading = false,
            modifier = Modifier.fillMaxWidth(),
            borderColor = darkMagneta,
            buttonHeight = 30.dp,
            fontSize = 12.sp,
            style = Typography.h2

        )
    }
}