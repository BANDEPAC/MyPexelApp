package com.loc.mypexelapp.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.loc.mypexelapp.Constants.DEFAULT_CURATED_PHOTOS_COUNT
import com.loc.mypexelapp.domain.model.Photo
import com.loc.mypexelapp.domain.repository.PexelRepository

class PexelCuratedPhotosPagingSource(
    private val pexelAPI: PexelAPI
    ) : PagingSource<Int, Photo>() {

    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    private var totalPhotosCount = 0

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int,Photo> {
        val page = params.key ?: 1
        return try {
            val pexelResponse = pexelAPI.getCuratedPhotos(page = page)

            totalPhotosCount += pexelResponse.photos.size

            LoadResult.Page(
                data = pexelResponse.photos,
                nextKey = if (totalPhotosCount == DEFAULT_CURATED_PHOTOS_COUNT) null else page + 1,
                prevKey = null
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(throwable = e)
        }
    }
}
