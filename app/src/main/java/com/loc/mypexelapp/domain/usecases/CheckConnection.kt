package com.loc.mypexelapp.domain.usecases

import com.loc.mypexelapp.domain.NetworkProvider
import javax.inject.Inject

class CheckConnection @Inject constructor(
    private val provider : NetworkProvider
) {
    operator fun invoke() : Boolean{
        return provider.isNetworkAvailable()
    }
}