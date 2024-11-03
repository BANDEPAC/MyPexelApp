package com.loc.mypexelapp.domain.usecases

import androidx.paging.PagingData
import com.loc.mypexelapp.domain.model.Collection
import com.loc.mypexelapp.domain.model.FeaturedCollection
import com.loc.mypexelapp.domain.model.Photo
import com.loc.mypexelapp.domain.repository.PexelRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFeaturedCollections @Inject constructor(
    private val pexelRepository: PexelRepository
) {
    operator fun invoke() : Flow<PagingData<Collection>> {
        return pexelRepository.getFeaturedCollections()
    }
}