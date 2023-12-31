package com.example.supercomposeapp.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.supercomposeapp.R
import com.example.supercomposeapp.ui.theme.*


@Composable
fun TextComponent(
    modifier: Modifier,
    text: String,
    textColor: Color,
    fontSize: TextUnit,
    textStyle: TextStyle,
    textAlign: TextAlign = TextAlign.Center

) {
    Text(
        modifier = modifier,
        text = text,
        color = textColor,
        fontSize = fontSize,
        fontFamily = Bariol,
        style = textStyle,
        textAlign = textAlign
    )
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showSystemUi = true
)
@Composable
fun TextComponentPreview() {
    Column(
        modifier = Modifier
            .padding(top = 20.dp, start = 50.dp, end = 50.dp, bottom = 20.dp)

    ) {
        TextComponent(
            modifier = Modifier.fillMaxWidth(),
            text = "about you",
            textColor = darkMagneta,
            fontSize = 35.sp,
            textStyle = Typography.h1,
        )
        TextComponent(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            text = stringResource(R.string.fill_this_up_about_you_page),
            textColor = textColorLightGray,
            fontSize = 17.sp,
            textStyle = Typography.h2
        )

    }
}
