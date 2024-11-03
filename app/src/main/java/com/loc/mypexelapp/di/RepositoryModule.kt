package com.loc.mypexelapp.di

import android.content.Context
import com.loc.mypexelapp.data.NetworkCheck
import com.loc.mypexelapp.data.remote.PexelAPI
import com.loc.mypexelapp.data.repository.PexelRepositoryImpl
import com.loc.mypexelapp.domain.NetworkProvider
import com.loc.mypexelapp.domain.repository.PexelRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providePexelRepository(pexelAPI: PexelAPI) : PexelRepository{
        return PexelRepositoryImpl(pexelAPI)
    }

    @Provides
    @Singleton
    fun provideNetworkRepository(@ApplicationContext context: Context): NetworkProvider {
        return NetworkCheck(context)
    }


}