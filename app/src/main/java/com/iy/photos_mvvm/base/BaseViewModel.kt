package com.iy.photos_mvvm.base

import androidx.lifecycle.ViewModel
import com.iy.photosMVVM.di.components.DaggerViewModelInjector
import com.iy.photos_mvvm.di.components.ViewModelInjector
import com.iy.photos_mvvm.di.modules.NetworkModule
import com.iy.photos_mvvm.ui.photos.PhotosItemViewModel
import com.iy.photos_mvvm.ui.photos.PhotosListViewModel

abstract class BaseViewModel : ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {

        inject()
    }

    private fun inject() {
        when (this) {
            is PhotosListViewModel -> injector.inject(this)
            is PhotosItemViewModel -> injector.inject(this)
        }
    }
}

