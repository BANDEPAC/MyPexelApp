package com.loc.mypexelapp.presentation.HomeScreen

import com.loc.mypexelapp.domain.model.Collection
import com.loc.mypexelapp.domain.model.FeaturedCollection
import com.loc.mypexelapp.domain.model.Photo

data class HomeState(
    var featuredCollections: List<Collection> = emptyList(),
    val photos : List<Photo> = emptyList()
)