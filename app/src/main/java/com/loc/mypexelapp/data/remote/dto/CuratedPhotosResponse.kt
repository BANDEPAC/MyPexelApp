package com.loc.mypexelapp.data.remote.dto

data class CuratedPhotosResponse(
    val next_page: String?,
    val page: Int?,
    val per_page: Int?,
    val photos: List<Photo?>?
)