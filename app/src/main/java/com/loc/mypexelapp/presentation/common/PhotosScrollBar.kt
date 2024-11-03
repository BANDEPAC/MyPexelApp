package com.loc.mypexelapp.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.loc.mypexelapp.domain.model.Photo
import com.loc.mypexelapp.presentation.HomeScreen.HomeState

@Composable
fun PhotosScrollBar(modifier: Modifier = Modifier, items: LazyPagingItems<Photo>) {

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2), // Две колонки
            modifier = Modifier
                .fillMaxSize()
                .then(modifier),
            horizontalArrangement = Arrangement.spacedBy(17.dp),
            verticalItemSpacing = 15.dp
        ) {
            items(items.itemCount) { index ->
                items[index]?.let { photo ->
                    PhotoCard(photo = photo)
                }
            }
        }


}