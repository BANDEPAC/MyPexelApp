package com.loc.mypexelapp.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.loc.mypexelapp.R
import com.loc.mypexelapp.presentation.HomeScreen.FeaturedButton
import com.loc.mypexelapp.ui.theme.DarkGrey
import com.loc.mypexelapp.ui.theme.MyPexelAppTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PexelSearchBar(modifier: Modifier = Modifier) {

    var text by remember { mutableStateOf("") }

    var active by remember { mutableStateOf(false) }

    SearchBar(
        query = text,
        onQueryChange = {
            text = it
        },
        onSearch = {
            active = false
        },
        active = active,
        onActiveChange ={
            active = it
        },
        placeholder = {
            Text(text = "Search", color = DarkGrey)
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search icon",
                tint = Color.Unspecified
            )
        },
        trailingIcon = {
            if(active){
                Icon(
                    modifier = Modifier.clickable {
                        if(text.isNotEmpty()){
                            text = ""
                        } else {
                            active = false
                        }
                    },
                    painter = painterResource(id = R.drawable.ic_close),
                    contentDescription = "Close icon",
                    tint = Color.DarkGray
                )
            }
        },
    ) {

    }
}

@Preview
@Composable
private fun Test2() {
    MyPexelAppTheme {
        Column {
            PexelSearchBar()
            FeaturedButton(onClick = {  }, isSelected = true, text = "Search")
        }

    }

}