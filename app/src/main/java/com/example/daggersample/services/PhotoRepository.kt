package com.example.daggersample.services

import com.example.daggersample.analytics.Analytics
import com.example.daggersample.model.Photo
import javax.inject.Inject

interface PhotoRepository {
    suspend fun getPhotos(page: Int?): List<Photo>
}

open class PhotoRepositoryImp @Inject constructor(
    private var photoService: PhotoService,
    private var analytics: Analytics
) :
    PhotoRepository {

    override suspend fun getPhotos(page: Int?): List<Photo> {
        analytics.sendEventGetPhotos()
        return photoService.getPhotos(page)
    }
}