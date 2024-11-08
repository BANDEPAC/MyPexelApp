package com.loc.mypexelapp.data.remote.dto

import com.loc.mypexelapp.domain.model.Photo

data class PhotoResponse(
    val next_page: String?,
    val page: Int,
    val per_page: Int,
    val photos: List<Photo>,
    val total_results: Int
)