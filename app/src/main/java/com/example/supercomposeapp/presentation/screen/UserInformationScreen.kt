package com.example.supercomposeapp.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
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
            .padding(top = 40.dp, start = 50.dp, end = 50.dp, bottom = 20.dp),


        ) {
        TextComponent(
            modifier = Modifier.fillMaxWidth(),
            text = "login",
            textColor = darkMagneta,
            fontSize = 35.sp,
            textStyle = Typography.h1,
        )
        TextComponent(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            text = stringResource(R.string.login_description),
            textColor = textColorLightGray,
            fontSize = 17.sp,
            textStyle = Typography.h2
        )
    }
    Column(
        modifier = Modifier
            .padding(start = 50.dp, end = 50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally


    ) {


        TextFieldComponent(
            description = "Email Address",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            placeHolderText = "abc@xyz.com",
            textValue = "",
            trailingIcon = Icons.Filled.Email,
            textColor = textColorLightGray,
            cursorColor = textColorLightGray,
            onValueChanged = {},
            onTrailingIconClick = {},
            textStyle = Typography.h2,
            enabled = true,
            trailingIconClick = {},
            textSize = 17.sp,

            placeHolderTextColor = textColorLightGray

        )
        TextFieldComponent(
            description = "enter password",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            placeHolderText = "enter your password",
            textValue = "textinput",
            textColor = textColorLightGray,
            trailingIcon = Icons.Filled.RemoveRedEye,
            cursorColor = textColorLightGray,
            onValueChanged = {},
            onTrailingIconClick = {},
            textStyle = Typography.h2,
            enabled = true,
            trailingIconClick = {},
            textSize = 17.sp,
            placeHolderTextColor = textColorLightGray,
            visualTransformation = PasswordVisualTransformation()

        )



        ButtonComponent(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            text = "Login",
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