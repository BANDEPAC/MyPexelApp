package com.loc.mypexelapp.data.remote.dto

import com.loc.mypexelapp.domain.model.Collection

data class PexelFeaturedCollectionResponse(
    val collections: List<Collection>,
    val next_page: String,
    val page: Int,
    val per_page: Int,
    val prev_page: String,
    val total_results: Int
)