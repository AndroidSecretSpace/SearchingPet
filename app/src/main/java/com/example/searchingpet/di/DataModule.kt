package com.example.searchingpet.di

import com.example.searchingpet.repository.MainRepository
import com.example.searchingpet.repository.MainRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsMainRepository(
        mainRepository: MainRepositoryImpl
    ) : MainRepository
}