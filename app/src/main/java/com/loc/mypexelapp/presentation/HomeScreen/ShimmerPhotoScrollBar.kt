package com.loc.mypexelapp.presentation.HomeScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.loc.mypexelapp.domain.model.Photo
import com.loc.mypexelapp.presentation.common.PhotoCard
import com.loc.mypexelapp.presentation.common.ShimmerEffect

@Composable
fun ShimmerPhotosScrollBar(modifier: Modifier = Modifier) {
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2), // Две колонки
            modifier = Modifier
                .fillMaxSize()
                .then(modifier),
            horizontalArrangement = Arrangement.spacedBy(17.dp),
            verticalItemSpacing = 15.dp
        ) {
            items(10) {
                ShimmerEffect(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                )
            }
        }


}