package com.loc.mypexelapp.data.remote

import com.loc.mypexelapp.Constants.API_KEY
import com.loc.mypexelapp.Constants.DEFAULT_CURATED_PHOTOS_COUNT
import com.loc.mypexelapp.data.remote.dto.PexelFeaturedCollectionResponse
import com.loc.mypexelapp.data.remote.dto.PexelCuratedPhotosResponse
import com.loc.mypexelapp.data.remote.dto.PexelSearchPhotosResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface PexelAPI {

    @GET("v1/curated")
    fun getCuratedPhotos(
        @Header("Authorization") apiKey: String = API_KEY,
        @Query("page") page : Int,
        @Query("per_page") perPage: Int = DEFAULT_CURATED_PHOTOS_COUNT
    ): PexelCuratedPhotosResponse

    @GET("v1/search")
    fun searchPhotos(
        @Header("Authorization") apiKey: String = API_KEY,
        @Query("query") query: String,
        @Query("per_page") perPage: Int
    ): PexelSearchPhotosResponse


    @GET("v1/collections/featured")
    fun getFeaturedCollections(
        @Header("Authorization") apiKey: String = API_KEY,
        @Query("per_page") perPage: Int
    ): PexelFeaturedCollectionResponse

}