package com.loc.mypexelapp.data.remote.dto

data class FeaturedCollection(
    val collections: List<Collection?>?,
    val next_page: String?,
    val page: Int?,
    val per_page: Int?,
    val total_results: Int?
)