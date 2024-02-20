package com.example.foodsapp.di

import com.example.foodsapp.data.datasource.FoodsDataSoruce
import com.example.foodsapp.data.repo.FoodsRepository
import com.example.foodsapp.data.retrofit.ApiUtils
import com.example.foodsapp.data.retrofit.FoodsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideFoodsDataSource(fdao:FoodsDao):FoodsDataSoruce{
        return FoodsDataSoruce(fdao)
    }
    @Provides
    @Singleton
    fun provideFoodRepository(fds:FoodsDataSoruce):FoodsRepository{
        return FoodsRepository(fds)
    }
    @Provides
    @Singleton
    fun provideFoodsDao():FoodsDao{
        return ApiUtils.getFoodsDao()
    }


}