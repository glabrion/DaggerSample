package com.example.a1_basic.services

import com.example.a1_basic.AppConst
import com.example.a1_basic.data.Photo
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