package com.loc.mypexelapp.domain.model

data class FeaturedCollection(
    val collections: List<Collection>,
    val next_page: String?,
    val page: Int,
    val per_page: Int,
    val prev_page: String?,
    val total_results: Int
)