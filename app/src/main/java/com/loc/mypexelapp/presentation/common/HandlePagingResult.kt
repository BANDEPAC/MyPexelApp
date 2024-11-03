package com.loc.mypexelapp.presentation.common

import androidx.compose.runtime.Composable
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.loc.mypexelapp.presentation.NoNetworkScreen

//,onClick : () -> Unit

@Composable
fun <T : Any> handlePagingResult(items: LazyPagingItems<T>,Issue :@Composable () -> Unit): Boolean {
    val loadState = items.loadState
    val error = when {
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        else -> null
    }

    return when {
        loadState.refresh is LoadState.Loading -> {
            false
        }

        error != null -> {
            Issue()
            false
        }

        else -> {
            true
        }
    }
}