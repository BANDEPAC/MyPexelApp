package com.loc.mypexelapp.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.loc.mypexelapp.domain.model.Collection

class PexelFeaturedCollectionsPagingSource(
    private val pexelAPI: PexelAPI
) : PagingSource<Int, Collection>() {

    override fun getRefreshKey(state: PagingState<Int, Collection>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Collection> {
        val page = params.key ?: 1
        return try {
            val response = pexelAPI.getFeaturedCollections(page = page)
            LoadResult.Page(
                data = response.collections,
                nextKey = page + 1,
                prevKey = null
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(throwable = e)
        }
    }

}