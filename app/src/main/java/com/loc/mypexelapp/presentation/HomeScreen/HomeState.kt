package com.loc.mypexelapp.presentation.HomeScreen

import androidx.paging.PagingData
import com.loc.mypexelapp.domain.model.Collection
import com.loc.mypexelapp.domain.model.Photo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

sealed class HomeUiState {
    object Loading : HomeUiState()
    object NoInternet : HomeUiState()
}

data class HomeState(
    val query: String = "",
    val uiState: HomeUiState = HomeUiState.Loading,
    val collections: Flow<PagingData<Collection>> = emptyFlow(),
    val photos: Flow<PagingData<Photo>> = emptyFlow()
)