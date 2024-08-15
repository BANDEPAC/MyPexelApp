package com.loc.mypexelapp.domain.repository

import androidx.paging.PagingData
import com.loc.mypexelapp.domain.model.Photo
import kotlinx.coroutines.flow.Flow

interface PexelRepository {
    fun getCuratedPhotos() : Flow<PagingData<Photo>>
}