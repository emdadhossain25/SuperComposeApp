package com.example.supercomposeapp.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.supercomposeapp.ui.theme.Bariol
import com.example.supercomposeapp.ui.theme.Typography
import com.example.supercomposeapp.ui.theme.darkMagneta
import com.example.supercomposeapp.ui.theme.white

@Composable
fun MagnetaButtonComponent(
    text: String,
    backgroundColor: Color,
    contentColor: Color,
    enabled: Boolean = true,
    onButtonClick: () -> Unit,
    isLoading: Boolean,
    modifier: Modifier = Modifier,
    borderColor: Color
) {
    Button(
        modifier = modifier,
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
                style = Typography.h3,
                text = text
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SuperAppButtonComponenPreview() {
    MagnetaButtonComponent(
        text = "Login",
        backgroundColor = darkMagneta,
        contentColor = white,
        onButtonClick = { /*TODO*/ },
        isLoading = false,
        modifier = Modifier.fillMaxWidth(),
        borderColor = white
    )
}