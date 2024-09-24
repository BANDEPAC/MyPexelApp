package com.loc.mypexelapp.presentation

import androidx.compose.foundation.clickable
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.loc.mypexelapp.R
import com.loc.mypexelapp.ui.theme.Black
import com.loc.mypexelapp.ui.theme.Grey
import com.loc.mypexelapp.ui.theme.MyPexelAppTheme
import com.loc.mypexelapp.ui.theme.Red
import com.loc.mypexelapp.ui.theme.White


@Composable
fun FeaturedButton(onClick : () -> Unit, isSelected: Boolean, text: String) {

    Button(
        onClick = onClick,
        modifier = Modifier
            .clickable(onClick = onClick),
        colors = ButtonDefaults
            .buttonColors(containerColor = if (isSelected) Red else Grey)
        ) {
        Text(
            text = text,
            color = if (isSelected) White else Black,
            fontFamily = FontFamily(Font(R.font.mulish_regular))
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