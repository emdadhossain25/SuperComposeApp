package com.example.supercomposeapp.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.supercomposeapp.R
import com.example.supercomposeapp.presentation.components.ButtonComponent
import com.example.supercomposeapp.presentation.components.TextComponent
import com.example.supercomposeapp.presentation.components.TextFieldComponent
import com.example.supercomposeapp.presentation.viewmodel.LoginViewModel
import com.example.supercomposeapp.ui.theme.Typography
import com.example.supercomposeapp.ui.theme.darkMagneta
import com.example.supercomposeapp.ui.theme.textColorLightGray
import com.example.supercomposeapp.ui.theme.white


@Composable
fun LoginScreen(
    onLoginSuccessNavigation: () -> Unit,
    onNavigateToRegisterScreen: () -> Unit,
    loginViewModel: LoginViewModel = hiltViewModel()
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
                text = "login",
                textColor = darkMagneta,
                fontSize = 35.sp,
                textStyle = Typography.h1,
            )
            TextComponent(
                modifier = Modifier
                    .fillMaxWidth(),
                text = stringResource(R.string.login_description),
                textColor = textColorLightGray,
                fontSize = 17.sp,
                textStyle = Typography.h2
            )

            LoginContainer(
                emailInput = { loginViewModel.loginState.emailInput },
                passwordInput = { loginViewModel.loginState.passwordInput },
                isButtonEnabled = { loginViewModel.loginState.isInputValid },
                onEmailChanged = loginViewModel::emailInputChange,
                onPasswordChanged = loginViewModel::passwordInputChange,
                onLoginButtonClick = loginViewModel::onLoginClick,
                isPasswordShown = { loginViewModel.loginState.isPasswordShowing },
                onTrailingIconClick = loginViewModel::onToggleVisualTransformation,
                errorHint = {
                    loginViewModel.loginState.errorMessageInput
                },
                isLoading = {
                    loginViewModel.loginState.isLoading
                }

            )


        }
        Row(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "No Account Yet?",
                style = Typography.h2
            )
            Text(
                text = "Register",
                modifier = Modifier
                    .padding(start = 5.dp)
                    .clickable {
                        onNavigateToRegisterScreen()
                    },
                color = darkMagneta,
                style = Typography.h1
            )
        }
    }


}

@Composable
fun LoginContainer(
    emailInput: () -> String,
    passwordInput: () -> String,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    isButtonEnabled: () -> Boolean,
    isLoading: () -> Boolean,
    isPasswordShown: () -> Boolean,
    onTrailingIconClick: () -> Unit,
    onLoginButtonClick: () -> Unit,
    errorHint: () -> String?,
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
        onValueChanged = onEmailChanged,
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
        onValueChanged = onPasswordChanged,
        onTrailingIconClick = {
            onTrailingIconClick()
        },
        textStyle = Typography.h2,
        enabled = true,
        textSize = 17.sp,
        placeHolderTextColor = textColorLightGray,
        visualTransformation = if (isPasswordShown()) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()

        },
        keyboardType = KeyboardType.Password

    )



    ButtonComponent(
        modifier = Modifier
            .fillMaxWidth(),
        text = "Login",
        backgroundColor = darkMagneta,
        contentColor = white,
        onButtonClick = onLoginButtonClick,
        isLoading = isLoading(),
        enabled = isButtonEnabled(),
        borderColor = Color.Transparent,
        buttonHeight = 45.dp,
        fontSize = 24.sp,
        style = Typography.h1,

        )
    Text(
        errorHint() ?: "",
        style = MaterialTheme.typography.caption
    )

}
