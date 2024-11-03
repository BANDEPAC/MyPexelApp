package com.loc.mypexelapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.loc.mypexelapp.Constants.DEFAULT_CURATED_PHOTOS_COUNT
import com.loc.mypexelapp.data.remote.PexelAPI
import com.loc.mypexelapp.data.remote.PexelCuratedPhotosPagingSource
import com.loc.mypexelapp.data.remote.PexelFeaturedCollectionsPagingSource
import com.loc.mypexelapp.data.remote.PexelSearchPhotosPagingSource
import com.loc.mypexelapp.domain.model.FeaturedCollection
import com.loc.mypexelapp.domain.model.Photo
import com.loc.mypexelapp.domain.repository.PexelRepository
import kotlinx.coroutines.flow.Flow
import com.loc.mypexelapp.domain.model.Collection

class PexelRepositoryImpl(
    private val pexelAPI: PexelAPI
): PexelRepository {

    override fun getFeaturedCollections(): Flow<PagingData<Collection>> {
        return Pager(
            config = PagingConfig(pageSize = 7),
            pagingSourceFactory = {
                PexelFeaturedCollectionsPagingSource(
                    pexelAPI = pexelAPI
                )
            }
        ).flow
    }

    override fun getPhotosByQuery(query: String): Flow<PagingData<Photo>> {
        return Pager(
            config = PagingConfig(pageSize = 15),
            pagingSourceFactory = {
                PexelSearchPhotosPagingSource(
                    pexelAPI = pexelAPI,
                    searchQuery = query,
                )
            }

        ).flow

    }

    override fun getCuratedPhotos(): Flow<PagingData<Photo>> {
        return Pager(
            config = PagingConfig(pageSize = DEFAULT_CURATED_PHOTOS_COUNT),
            pagingSourceFactory = {
                PexelCuratedPhotosPagingSource(
                    pexelAPI = pexelAPI
                )
            }
        ).flow
    }
}
