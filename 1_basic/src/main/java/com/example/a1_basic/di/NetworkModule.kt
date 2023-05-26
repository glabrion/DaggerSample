package com.example.a1_basic.di

import com.example.a1_basic.AppConst
import com.example.a1_basic.services.PhotoService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
class NetworkModule {

    @Provides
    fun providePhotoService(): PhotoService {
        val retrofit = Retrofit.Builder().baseUrl(AppConst.BASE_URL).build()
        return retrofit.create()
    }
}