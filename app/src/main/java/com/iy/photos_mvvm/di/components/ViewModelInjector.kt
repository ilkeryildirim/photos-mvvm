package com.iy.photos_mvvm.di.components

import com.iy.photos_mvvm.di.modules.NetworkModule
import com.iy.photos_mvvm.ui.photos.PhotosItemViewModel
import com.iy.photos_mvvm.ui.photos.MainActivityViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    fun inject(photosItemViewModel: PhotosItemViewModel)
    fun inject(mainActivityViewModel: MainActivityViewModel)

    @Component.Builder
    interface Builder {

        fun build(): ViewModelInjector
        fun networkModule(networkModule: NetworkModule): Builder
    }

}