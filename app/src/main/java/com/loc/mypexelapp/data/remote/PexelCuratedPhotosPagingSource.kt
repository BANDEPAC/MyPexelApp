package com.loc.mypexelapp.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.loc.mypexelapp.data.remote.dto.PexelCuratedPhotosResponse
import com.loc.mypexelapp.domain.model.Photo

class PexelCuratedPhotosPagingSource(
    private val pexelAPI: PexelAPI
): PagingSource<Int,Photo>() {

    private var totalPhotosCount = 0

    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        val page = params.key ?: 1
        return try {
            val pexelResponse = pexelAPI.getCuratedPhotos(page = page)
            totalPhotosCount += pexelResponse.photos.size

            LoadResult.Page(
                data = pexelResponse.photos,
                nextKey = if (totalPhotosCount == pexelResponse.per_page) null else page + 1,
                prevKey = null

            )

        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(
                throwable = e
            )
        }
    }

}