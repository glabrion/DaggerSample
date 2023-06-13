package com.example.daggersample.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.daggersample.services.PhotoRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class MainViewModelFactory @AssistedInject constructor(
    @Assisted("page") private val page: Int,
    private val photoRepository: PhotoRepository,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == MainViewModel::class)
        return MainViewModel(1, photoRepository) as T
    }

    @AssistedFactory
    interface Factory {
        fun create(@Assisted("page") page: Int): MainViewModelFactory
    }
}