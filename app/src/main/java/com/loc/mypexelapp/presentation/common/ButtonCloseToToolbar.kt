package com.loc.mypexelapp.presentation.common

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.loc.mypexelapp.R
import com.loc.mypexelapp.ui.theme.MyPexelAppTheme

@Composable
fun ButtonCloseToToolbar(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    containerColor: Color,
    contentColor: Color,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        shape = MaterialTheme.shapes.extraLarge
    ) {
        Text(text = text)
    }
}

@Composable
@Preview
fun Test(modifier: Modifier = Modifier) {
    MyPexelAppTheme {
        ButtonCloseToToolbar(
            onClick = { },
            text = "Watches",
            containerColor = colorResource(id = R.color.grey),
            contentColor = colorResource(id = R.color.black),
        )
    }
}