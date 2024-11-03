package com.loc.mypexelapp.domain.repository

import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.loc.mypexelapp.domain.model.Photo
import kotlinx.coroutines.flow.Flow
import com.loc.mypexelapp.domain.model.Collection
import com.loc.mypexelapp.domain.model.FeaturedCollection

interface PexelRepository {

    fun getFeaturedCollections() : Flow<PagingData<Collection>>

    fun getPhotosByQuery(query: String): Flow<PagingData<Photo>>

    fun getCuratedPhotos(): Flow<PagingData<Photo>>

}