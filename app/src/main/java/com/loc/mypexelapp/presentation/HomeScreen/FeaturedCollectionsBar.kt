package com.loc.mypexelapp.presentation.HomeScreen

import android.util.Log
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.compose.LazyPagingItems
import com.loc.mypexelapp.domain.model.Collection
import com.loc.mypexelapp.domain.model.Photo
import com.loc.mypexelapp.presentation.common.PhotoCard
import com.loc.mypexelapp.ui.theme.MyPexelAppTheme

@Composable
fun FeaturedCollectionBar(modifier: Modifier = Modifier, featuredCollections : LazyPagingItems<Collection>, onClick: (String) -> Unit) {

    var selectedCollection by remember {
        mutableStateOf<String?>(null)
    }

    LazyRow(
        modifier = modifier,
    ) {
        items(featuredCollections.itemCount) { index ->
            featuredCollections[index]?.let{ collection ->
                FeaturedButton(
                    onClick = {
                        selectedCollection = collection.id
                        onClick(collection.title)
                    },
                    isSelected = collection.id == selectedCollection,
                    text = collection.title
                )
            }

        }
    }
}

@Preview
@Composable
private fun FeaturedCollectionBarTest() {
    MyPexelAppTheme {
        //FeaturedCollectionBar(collections = listOf("Penis","Xyu","Zalupa"))
    }
}
