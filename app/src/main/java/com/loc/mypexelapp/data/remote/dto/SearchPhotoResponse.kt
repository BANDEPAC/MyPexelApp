package com.loc.mypexelapp.data.remote.dto

data class SearchPhoto(
    val next_page: String?,
    val page: Int?,
    val per_page: Int?,
    val photos: List<Photo?>?,
    val total_results: Int?
)