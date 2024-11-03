package com.loc.mypexelapp.presentation.HomeScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.loc.mypexelapp.ui.theme.Black
import com.loc.mypexelapp.ui.theme.LightGrey
import com.loc.mypexelapp.ui.theme.MyPexelAppTheme
import com.loc.mypexelapp.ui.theme.Red
import com.loc.mypexelapp.ui.theme.White


@Composable
fun FeaturedButton(onClick : () -> Unit, isSelected: Boolean, text: String) {

    Button(
        onClick = onClick,
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(end = 11.dp),
        colors = ButtonDefaults
            .buttonColors(containerColor = if (isSelected) Red else LightGrey)
        ) {
        Text(
            text = text,
            color = if (isSelected) White else Black,
            style = MaterialTheme.typography.headlineLarge
        )

    }

}

@Preview
@Composable
private fun Test() {
    MyPexelAppTheme {
        FeaturedButton(onClick = {}, isSelected = false,text = "Ice")
    }

}