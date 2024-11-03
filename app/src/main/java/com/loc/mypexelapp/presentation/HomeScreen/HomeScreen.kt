package com.loc.mypexelapp.presentation.HomeScreen
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.loc.mypexelapp.domain.model.FeaturedCollection
import com.loc.mypexelapp.domain.model.Photo
import com.loc.mypexelapp.presentation.EmptyScreen
import com.loc.mypexelapp.presentation.NoNetworkScreen
import com.loc.mypexelapp.ui.theme.MyPexelAppTheme
import com.loc.mypexelapp.presentation.common.PhotosScrollBar
import com.loc.mypexelapp.presentation.common.ShimmerEffect
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flowOf

@Composable
fun HomeScreen(
    homeState: State<HomeState>,
    queryChange: (String) -> Unit,
    search: () -> Unit,
    onRetry: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(start = 24.dp, top = 12.dp, end = 24.dp)
            .statusBarsPadding(),
    ) {
        SearchBar(
            onQueryChange = queryChange,
            onSearch = search
        )
        FeaturedCollectionDisplay(state = homeState.value, onSearch = search, queryChange = queryChange)
        PhotosDisplay(state = homeState.value, onRetry = onRetry)
    }
}

@Composable
fun PhotosDisplay(
    state: HomeState,
    onRetry: () -> Unit
) {
    val currentPhotos = state.photos.collectAsLazyPagingItems()
    val refreshState = currentPhotos.loadState.refresh

    if (state.uiState is HomeUiState.NoInternet) {
        NoNetworkScreen { onRetry() }
        return
    }

    when (refreshState) {
        is LoadState.Loading -> {
            // Индикатор загрузки при обновлении
            Spacer(modifier = Modifier.padding(vertical = 12.dp))
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
            ShimmerPhotosScrollBar() // Эффект загрузки
        }
        is LoadState.Error -> {
            EmptyScreen("Error: ${refreshState.error.localizedMessage}") { onRetry() }
        }
        is LoadState.NotLoading -> {
            if (currentPhotos.itemCount > 0) {
                Spacer(modifier = Modifier.padding(vertical = 12.dp))
                PhotosScrollBar(items = currentPhotos)
            } else {
                EmptyScreen("No results found") { onRetry() }
            }
        }
    }
}

@Composable
fun FeaturedCollectionDisplay(
    state: HomeState,
    onSearch: () -> Unit,
    queryChange: (String) -> Unit
) {
    val currentFeaturedCollection = state.collections.collectAsLazyPagingItems()
    val refreshState = currentFeaturedCollection.loadState.refresh

    when(refreshState){
        is LoadState.Loading -> {
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
        }
        is LoadState.NotLoading -> {
            Spacer(modifier = Modifier.padding(vertical = 12.dp))
            FeaturedCollectionBar(
                featuredCollections = currentFeaturedCollection,
                onClick = { query ->
                    queryChange(query)
                    onSearch()
                }
            )
        }
        is LoadState.Error -> {}
    }


}