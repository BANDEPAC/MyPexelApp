package com.loc.mypexelapp.presentation.home_screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.loc.mypexelapp.R
import com.loc.mypexelapp.presentation.Dimens.PaddingBetweenCategories
import com.loc.mypexelapp.presentation.common.ButtonCloseToToolbar


@Composable
fun CategorySection(categories: List<String>) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        //var selectedCategory by remember { mutableStateOf(categories[0]) }

        items(categories) { category ->
            ButtonCloseToToolbar(
                modifier = Modifier.padding(horizontal = PaddingBetweenCategories),
                onClick = {  },
                text = category,
                containerColor = colorResource(id = R.color.grey),
                contentColor = colorResource(id = R.color.black),
            )
        }
    }
}
