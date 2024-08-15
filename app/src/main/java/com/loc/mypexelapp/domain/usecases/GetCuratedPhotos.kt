package com.loc.mypexelapp.domain.usecases

import androidx.paging.PagingData
import com.loc.mypexelapp.domain.model.Photo
import com.loc.mypexelapp.domain.repository.PexelRepository
import kotlinx.coroutines.flow.Flow

class GetCuratedPhotos(
    private val pexelRepository: PexelRepository
) {

    operator fun invoke() : Flow<PagingData<Photo>> {
        return pexelRepository.getCuratedPhotos()
    }
}