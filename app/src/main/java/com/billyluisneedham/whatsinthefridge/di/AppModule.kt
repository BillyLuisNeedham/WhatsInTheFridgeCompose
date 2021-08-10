package com.billyluisneedham.whatsinthefridge.di

import com.billyluisneedham.whatsinthefridge.data.repository.FoodRepositoryImpl
import com.billyluisneedham.whatsinthefridge.domain.FoodRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideFoodRepository(
    ): FoodRepository {
        return FoodRepositoryImpl()
    }
}