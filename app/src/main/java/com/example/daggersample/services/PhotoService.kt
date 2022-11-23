package com.example.daggersample.services

import com.example.daggersample.common.AppConst
import com.example.daggersample.model.Photo
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoService {

    @GET("photos")
    suspend fun getListPhotos(
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int? = 50,
        @Query("client_id") clientId: String = AppConst.ACCESS_KEY
    ): List<Photo>
}