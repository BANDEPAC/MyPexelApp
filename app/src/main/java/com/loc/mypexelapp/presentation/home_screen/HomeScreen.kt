package com.loc.mypexelapp.presentation.home_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.loc.mypexelapp.presentation.Dimens.BetweenSearchBarAndFeaturedCollections
import com.loc.mypexelapp.presentation.Dimens.EdgesPadding
import com.loc.mypexelapp.presentation.Dimens.TopPadding
import com.loc.mypexelapp.presentation.common.SearchBar
import com.loc.mypexelapp.ui.theme.MyPexelAppTheme

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(EdgesPadding)
    ){

        SearchBar(
            modifier = Modifier,
            text = "",
            readOnly = true,
            onValueChange = {},
            onSearch = {}
        )
        Spacer(modifier = Modifier.height(BetweenSearchBarAndFeaturedCollections))

        CategorySection(categories = exemples)



    }
}

@Preview
@Composable
private fun Test() {
    MyPexelAppTheme {
        HomeScreen()
    }

}

var exemples = listOf("Ice","Watches","Grizlie","Pie")