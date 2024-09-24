package com.loc.mypexelapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.loc.mypexelapp.ui.theme.Black
import com.loc.mypexelapp.ui.theme.MyPexelAppTheme
import com.loc.mypexelapp.ui.theme.Red

@Composable
fun EmptyBookmarks(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "You haven't saved anything yet",
                style = MaterialTheme.typography.bodyMedium,
                color = Black,
                modifier = Modifier.clickable {
                    onClick()
                }
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Explore",
                style = MaterialTheme.typography.bodyLarge,
                color = Red,
                modifier = Modifier.clickable {
                    onClick()
                }
            )
        }
    }
}

@Preview
@Composable
private fun EmptyBookmarksTest() {
    MyPexelAppTheme {
        EmptyBookmarks(onClick = {})
    }

}