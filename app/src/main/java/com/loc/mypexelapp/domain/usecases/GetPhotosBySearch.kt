package com.loc.mypexelapp.domain.usecases

import androidx.paging.PagingData
import com.loc.mypexelapp.domain.model.Photo
import com.loc.mypexelapp.domain.repository.PexelRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPhotosBySearch @Inject constructor(
   private val pexelRepository: PexelRepository
) {
    operator fun invoke(query: String) : Flow<PagingData<Photo>> {
        return pexelRepository.getPhotosByQuery(query)
    }
}