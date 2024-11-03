package com.loc.mypexelapp.presentation.HomeScreen

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.compose.collectAsLazyPagingItems
import com.loc.mypexelapp.domain.model.Collection
import com.loc.mypexelapp.domain.model.Photo
import com.loc.mypexelapp.domain.usecases.CheckConnection
import com.loc.mypexelapp.domain.usecases.GetCuratedPhotos
import com.loc.mypexelapp.domain.usecases.GetFeaturedCollections
import com.loc.mypexelapp.domain.usecases.GetPhotosBySearch
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

//@HiltViewModel
//class HomeViewModel @Inject constructor(
//    private val getFeaturedCollections: GetFeaturedCollections,
//    private val getPhotosBySearch: GetPhotosBySearch,
//    private val getCuratedPhotos: GetCuratedPhotos,
//    private val isInternetAvailable: CheckConnection
//) : ViewModel() {
//
//    private val _state = MutableStateFlow(HomeState())
//    val state: StateFlow<HomeState> = _state
//
//    private val curatedPhotos: Flow<PagingData<Photo>> = getCuratedPhotos().cachedIn(viewModelScope)
//    private val featuredCollections: Flow<PagingData<Collection>> = getFeaturedCollections().cachedIn(viewModelScope)
//
//    init {
//        checkInternetConnection()
//        loadInitialData()
//    }
//
//    private fun loadInitialData() {
//        searchPhotos()
//    }
//
//    fun updateQuery(query: String) {
//        _state.value = _state.value.copy(query = query)
//        searchPhotos()
//    }
//
//    fun searchPhotos() {
//        checkInternetConnection()
//        if(_state.value.uiState == HomeUiState.NoInternet){
//            return
//        }
//
//        _state.value = _state.value.copy(uiState = HomeUiState.Loading)
//        val currentQuery = _state.value.query
//
//        if (currentQuery.isNotBlank()) {
//            val photosFlow = getPhotosBySearch(currentQuery)
//            _state.value = _state.value.copy(
//                collections = featuredCollections,
//                photos = photosFlow,
//                uiState = HomeUiState.Loaded
//            )
//        } else {
//            _state.value = _state.value.copy(
//                uiState = HomeUiState.Loaded,
//                collections = featuredCollections,
//                photos = curatedPhotos
//            )
//        }
//    }
//
//    fun checkInternetConnection() {
//        viewModelScope.launch {
//            val isConnected = isInternetAvailable()
//            _state.value = if (isConnected)
//                _state.value.copy(uiState = HomeUiState.Loading)
//            else {
//                _state.value.copy(uiState = HomeUiState.NoInternet)
//                //дальше подкачиваем с кеша здесь
//            }
//
//            //Здесь будет ветвление. Если у нас имеются данные в кеше,
//            // то мы подтягиваем из него,в обратном случае мы сообщаем об ошибке пользователю
//        }
//    }
//}

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getFeaturedCollections: GetFeaturedCollections,
    private val getPhotosBySearch: GetPhotosBySearch,
    private val getCuratedPhotos: GetCuratedPhotos,
    private val isInternetAvailable: CheckConnection
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state

    init {
        checkInternetConnection()
        downloadCuratedPhotos()
        downloadFeaturedCollections()
    }

    fun updateQuery(query: String) {
        _state.value = _state.value.copy(query = query)
    }

    fun searchPhotos() {
        val query = _state.value.query
        val photos = getPhotosBySearch(query = query).cachedIn(viewModelScope)
        _state.value = _state.value.copy(photos = photos)
    }

    fun downloadCuratedPhotos() {
        val curatedPhotos = getCuratedPhotos().cachedIn(viewModelScope)
        _state.value = _state.value.copy(photos = curatedPhotos)
    }

    fun downloadFeaturedCollections() {
        val featuredCollections = getFeaturedCollections().cachedIn(viewModelScope)
        _state.value = _state.value.copy(collections = featuredCollections)
    }

    fun checkInternetConnection() {
        val isConnected = isInternetAvailable()
        if (isConnected) {
            _state.value = _state.value.copy(uiState = HomeUiState.Loading)
        } else {
            _state.value = _state.value.copy(uiState = HomeUiState.NoInternet)
        }
    }

}