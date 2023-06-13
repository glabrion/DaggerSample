package com.example.daggersample.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggersample.model.Photo
import com.example.daggersample.services.PhotoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    val page: Int,
    private val photoRepository: PhotoRepository
) : ViewModel() {

    private val _photos: MutableStateFlow<List<Photo>> = MutableStateFlow(emptyList())
    val photos: StateFlow<List<Photo>> = _photos.asStateFlow()

    fun getPhotos() {
        viewModelScope.launch {
            _photos.value = photoRepository.getListPhotos(page)
        }
    }
}