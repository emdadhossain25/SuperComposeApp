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
import com.example.supercomposeapp.ui.theme.darkMagneta
import com.example.supercomposeapp.ui.theme.white

@Composable
fun SuperWhiteButtonComponent(
    modifier: Modifier,
    backgroundColor: Color,
    contentColor: Color,
    text: String,
    isLoading: Boolean,
    onButtonClick: () -> Unit, // this is a function which doesn't take any parameters as input and does not return anything
    enabled: Boolean = true,
    borderColor: Color
) {
    Button(
        modifier = modifier,
        onClick = { onButtonClick() },
        shape = RoundedCornerShape(25.dp),
        enabled = enabled,

        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = contentColor,
            disabledContentColor = contentColor,
            disabledBackgroundColor = backgroundColor,

            ),
        border = BorderStroke(
            width = 2.dp,
            color = borderColor
        )
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(20.dp),
                color = contentColor
            )
        } else {
            Text(
                text = text,
                style = MaterialTheme.typography.h3,
                fontFamily = Bariol

            )
        }

    }

}

@Preview
@Composable
fun SuperWhiteButtonComponentPreview() {
    SuperWhiteButtonComponent(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = white,
        contentColor = darkMagneta,
        text = "Sign Up",
        isLoading = false,
        onButtonClick = {},
        enabled = true,
        borderColor = darkMagneta
    )
}
