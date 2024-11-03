package com.loc.mypexelapp.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.loc.mypexelapp.R
import com.loc.mypexelapp.ui.theme.MyPexelAppTheme

@Composable
fun BackButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .size(40.dp)
            .clickable { onClick() }
            .background(
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                shape = RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center,
             // Добавляем округление
    ) {
        Image(
            painter = painterResource(R.drawable.ic_back),
            contentDescription = "Back Button",
            modifier = Modifier.size(24.dp) ,
        )
    }
}

@Preview
@Composable
private fun Try() {
    MyPexelAppTheme {
        Column {
            BackButton { }
        }
    }
}