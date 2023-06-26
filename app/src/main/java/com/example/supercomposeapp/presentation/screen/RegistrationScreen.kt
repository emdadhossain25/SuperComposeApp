package com.example.supercomposeapp.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.supercomposeapp.R
import com.example.supercomposeapp.presentation.components.ButtonComponent
import com.example.supercomposeapp.presentation.components.TextComponent
import com.example.supercomposeapp.presentation.components.TextFieldComponent
import com.example.supercomposeapp.presentation.viewmodel.RegistrationViewModel
import com.example.supercomposeapp.ui.theme.Typography
import com.example.supercomposeapp.ui.theme.darkMagneta
import com.example.supercomposeapp.ui.theme.textColorLightGray
import com.example.supercomposeapp.ui.theme.white


@Composable
fun RegistrationScreen(
    onRegistrationSuccessNavigation: () -> Unit,
    onNavigateToLoginScreen: () -> Unit,
    registrationViewModel: RegistrationViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .padding(top = 40.dp, start = 50.dp, end = 50.dp, bottom = 20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)


        ) {
            TextComponent(
                modifier = Modifier.fillMaxWidth(),
                text = "Register",
                textColor = darkMagneta,
                fontSize = 35.sp,
                textStyle = Typography.h1,
            )
            TextComponent(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                text = stringResource(R.string.register_description),
                textColor = textColorLightGray,
                fontSize = 17.sp,
                textStyle = Typography.h2
            )

            RegistrationContainer(
                emailInput = { registrationViewModel.registrationState.emailInput },
                emailValueChanged = registrationViewModel::emailInputChange,
                passwordInput = { registrationViewModel.registrationState.passwordInput },
                passwordInputChanged = registrationViewModel::passwordInputChange,
                onTrailingIconClick = registrationViewModel::onToggleVisualTransformationForPassword,
                isPasswordShowing = { registrationViewModel.registrationState.isPasswordShown },
                retypePasswordInput = { registrationViewModel.registrationState.passwordRepeatedInput },
                repeatPasswordValueChanged = registrationViewModel::repeatPasswordInputChange,
                onRepeatPasswordTrailingIconClick = registrationViewModel::onToggleVisualTransformationForRepeatPassword,
                isRepeatPasswordShown = { registrationViewModel.registrationState.isRepeatPasswordShown },
                isLoading = { registrationViewModel.registrationState.isLoading },
                isEnabled = { registrationViewModel.registrationState.isValidInput }
            )


        }
        Row(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .align(Alignment.BottomCenter),
        ) {
            Text(
                text = "Already Registered?",
                style = Typography.h2
            )
            Text(

                modifier = Modifier
                    .padding(start = 5.dp)
                    .clickable {
                        onNavigateToLoginScreen()
                    },
                text = "Login",
                color = darkMagneta,
                style = Typography.h1
            )
        }
    }
}

@Composable
fun RegistrationContainer(
    emailInput: () -> String,
    emailValueChanged: (String) -> Unit,
    passwordInput: () -> String,
    passwordInputChanged: (String) -> Unit,
    onTrailingIconClick: () -> Unit,
    isPasswordShowing: () -> Boolean,
    retypePasswordInput: () -> String,
    repeatPasswordValueChanged: (String) -> Unit,
    onRepeatPasswordTrailingIconClick: () -> Unit,
    isRepeatPasswordShown: () -> Boolean,
    isLoading: () -> Boolean,
    isEnabled: () -> Boolean


) {


    TextFieldComponent(
        description = "Email Address",
        modifier = Modifier
            .fillMaxWidth(),
        placeHolderText = "abc@xyz.com",
        textValue = emailInput(),
        trailingIcon = Icons.Filled.Email,
        textColor = textColorLightGray,
        cursorColor = textColorLightGray,
        onValueChanged = emailValueChanged,
        onTrailingIconClick = null,
        textStyle = Typography.h2,
        enabled = true,
        textSize = 17.sp,

        placeHolderTextColor = textColorLightGray

    )
    TextFieldComponent(
        description = "enter password",
        modifier = Modifier
            .fillMaxWidth(),
        placeHolderText = "enter your password",
        textValue = passwordInput(),
        textColor = textColorLightGray,
        trailingIcon = Icons.Filled.RemoveRedEye,
        cursorColor = textColorLightGray,
        onValueChanged = passwordInputChanged,
        onTrailingIconClick = onTrailingIconClick,
        textStyle = Typography.h2,
        enabled = true,
        textSize = 17.sp,
        placeHolderTextColor = textColorLightGray,
        visualTransformation = if (isPasswordShowing()) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }

    )

    TextFieldComponent(
        description = "retype password",
        modifier = Modifier
            .fillMaxWidth(),
        placeHolderText = "enter your password",
        textValue = retypePasswordInput(),
        textColor = textColorLightGray,
        trailingIcon = Icons.Filled.RemoveRedEye,
        cursorColor = textColorLightGray,
        onValueChanged = repeatPasswordValueChanged,
        onTrailingIconClick = onRepeatPasswordTrailingIconClick,
        textStyle = Typography.h2,
        enabled = true,
        textSize = 17.sp,
        placeHolderTextColor = textColorLightGray,
        visualTransformation = if (isRepeatPasswordShown()) PasswordVisualTransformation() else VisualTransformation.None

    )



    ButtonComponent(
        modifier = Modifier
            .fillMaxWidth(),
        text = stringResource(R.string.register),
        backgroundColor = if (isEnabled()) darkMagneta else textColorLightGray,
        enabled = isEnabled(),
        contentColor = white,
        onButtonClick = { /*TODO*/ },
        isLoading = isLoading(),
        borderColor = Color.Transparent,
        buttonHeight = 45.dp,
        fontSize = 24.sp,
        style = Typography.h1
    )
}