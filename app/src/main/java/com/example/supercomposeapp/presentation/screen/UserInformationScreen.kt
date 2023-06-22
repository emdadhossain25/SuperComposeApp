package com.example.supercomposeapp.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.supercomposeapp.R
import com.example.supercomposeapp.presentation.components.ButtonComponent
import com.example.supercomposeapp.presentation.components.TextComponent
import com.example.supercomposeapp.presentation.components.TextFieldComponent
import com.example.supercomposeapp.ui.theme.Typography
import com.example.supercomposeapp.ui.theme.darkMagneta
import com.example.supercomposeapp.ui.theme.textColorLightGray
import com.example.supercomposeapp.ui.theme.white

@Composable
fun UserInformationScreen() {
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
        TextFieldComponent(
            description = "Email Address",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            placeHolderText = "emdad@ergo-ventures.com",
            textValue = "",
            textColor = textColorLightGray,
            trailingIcon = Icons.Filled.Email,
            cursorColor = textColorLightGray,
            onValueChanged = {},
            onTrailingIconClick = {},
            textStyle = Typography.h2,
            enabled = true,
            trailingIconClick = {},
            textSize = 17.sp,

            placeHolderTextColor = textColorLightGray

        )


        ButtonComponent(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            text = "save my profile",
            backgroundColor = darkMagneta,
            contentColor = white,
            onButtonClick = { /*TODO*/ },
            isLoading = false,
            borderColor = Color.Transparent,
            buttonHeight = 40.dp,
            fontSize = 20.sp,
            style = Typography.h1
        )

    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun UserInformationScreenPreview() {
    UserInformationScreen()
}