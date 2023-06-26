package com.example.supercomposeapp.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.supercomposeapp.ui.theme.Bariol
import com.example.supercomposeapp.ui.theme.Typography
import com.example.supercomposeapp.ui.theme.textColorLightGray
import com.example.supercomposeapp.ui.theme.white

@Composable
fun TextFieldComponent(

    description: String,
    textValue: String,
    keyboardType: KeyboardType = KeyboardType.Ascii,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChanged: (String) -> Unit,
    trailingIcon: ImageVector? = null,
    onTrailingIconClick: (() -> Unit)?, // lambda function does not take anything, return anything , also optional
    modifier: Modifier = Modifier,
    textStyle: TextStyle,
    textSize: TextUnit,
    textColor: Color,
    cursorColor: Color,
    placeHolderText: String,
    placeHolderTextColor: Color,
    enabled: Boolean
) {
    Column(
        modifier = modifier
    ) {
        TextField(
            modifier = modifier
                .fillMaxWidth()
                .border(
                    0.5.dp,
                    textColor,
                    RoundedCornerShape(25.dp)
                )
                .height(50.dp)
                .shadow(
                    3.dp,
                    RoundedCornerShape(25.dp)
                ),
            value = textValue,
            colors = TextFieldDefaults.textFieldColors(
                textColor = textColor,
                disabledTextColor = textColor,
                placeholderColor = placeHolderTextColor,
                backgroundColor = white,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            onValueChange = onValueChanged,
            shape = RoundedCornerShape(25.dp),
            singleLine = true,


            trailingIcon = {
                if (trailingIcon != null) {
                    Icon(imageVector = trailingIcon, contentDescription = null, tint = cursorColor,
                        modifier = Modifier
                            .height(20.dp)
                            .width(20.dp)
                            .clickable {
                                if (onTrailingIconClick != null) onTrailingIconClick()
                            })
                }
            },
            placeholder = {
                Text(
                    text = placeHolderText,
                    fontFamily = Bariol,
                    fontSize = textSize,
                    style = textStyle,
                    textAlign = TextAlign.Left

                )

            },
            textStyle = textStyle,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            visualTransformation = visualTransformation
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TextFieldComponentPreview() {
    TextFieldComponent(
        description = "Email Address",
        modifier = Modifier.fillMaxWidth(),
        placeHolderText = "emdad@ergo-ventures.com",
        textValue = "",
        textColor = textColorLightGray,
        trailingIcon = Icons.Filled.Email,
        cursorColor = textColorLightGray,
        onValueChanged = {},
        onTrailingIconClick = {},
        textStyle = Typography.h2,
        enabled = true,
        textSize = 18.sp,
        placeHolderTextColor = textColorLightGray

    )
}