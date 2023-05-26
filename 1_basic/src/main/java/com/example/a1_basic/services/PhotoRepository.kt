package com.example.a1_basic.services

import com.example.a1_basic.analytics.Analytics
import com.example.a1_basic.data.Photo
import javax.inject.Inject

interface PhotoRepository {
    suspend fun getListPhotos(page: Int?): List<Photo>
}

open class PhotoRepositoryImp @Inject constructor(
    private var photoService: PhotoService,
    private var analytics: Analytics
) :
    PhotoRepository {

    override suspend fun getListPhotos(page: Int?): List<Photo> {
        analytics.sendEventGetPhotos()
        return photoService.getListPhotos(page)
    }
}