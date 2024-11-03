package com.loc.mypexelapp.data.remote

import com.loc.mypexelapp.Constants.API_KEY
import com.loc.mypexelapp.Constants.DEFAULT_CURATED_PHOTOS_COUNT
import com.loc.mypexelapp.Constants.DEFAULT_FEATURED_COLLECTIONS_COUNT
import com.loc.mypexelapp.Constants.FIRST_PAGE
import com.loc.mypexelapp.data.remote.dto.CuratedPhotosResponse
import com.loc.mypexelapp.data.remote.dto.PhotoResponse
import com.loc.mypexelapp.domain.model.FeaturedCollection
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface PexelAPI {

    @GET("v1/search")
    suspend fun searchPhotos(
        @Header("Authorization") apiKey: String = API_KEY,
        @Query("query") query: String,
        @Query("page") page : Int = FIRST_PAGE
    ): PhotoResponse


    @GET("v1/collections/featured")
    suspend fun getFeaturedCollections(
        @Header("Authorization") apiKey: String = API_KEY,
        @Query("per_page") perPage: Int = DEFAULT_FEATURED_COLLECTIONS_COUNT,
        @Query("page") page : Int
    ): FeaturedCollection

    @GET("v1/curated")
    suspend fun getCuratedPhotos(
        @Header("Authorization") apiKey: String = API_KEY,
        @Query("per_page") perPage: Int = DEFAULT_CURATED_PHOTOS_COUNT,
        @Query("page") page: Int
    ): CuratedPhotosResponse


}