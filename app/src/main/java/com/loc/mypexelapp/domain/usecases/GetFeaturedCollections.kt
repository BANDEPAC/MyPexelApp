package com.loc.mypexelapp.domain.usecases

import com.loc.mypexelapp.domain.model.FeaturedCollection
import com.loc.mypexelapp.domain.repository.PexelRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFeaturedCollectins @Inject constructor(
    private val pexelRepository: PexelRepository
) {
    suspend operator fun invoke() : FeaturedCollection {
        return pexelRepository.getFeaturedCollections()
    }
}