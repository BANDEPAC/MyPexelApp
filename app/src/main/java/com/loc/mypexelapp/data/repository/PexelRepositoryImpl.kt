package com.loc.mypexelapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.loc.mypexelapp.data.remote.PexelAPI
import com.loc.mypexelapp.data.remote.PexelCuratedPhotosPagingSource
import com.loc.mypexelapp.domain.model.Photo
import com.loc.mypexelapp.domain.repository.PexelRepository
import kotlinx.coroutines.flow.Flow

class PexelRepositoryImpl(
    private val pexelAPI: PexelAPI
): PexelRepository {
    override fun getCuratedPhotos(): Flow<PagingData<Photo>> {
        return Pager(
            config = PagingConfig(pageSize = 5),
            pagingSourceFactory = {
                PexelCuratedPhotosPagingSource(pexelAPI)
            }
        ).flow
    }

}