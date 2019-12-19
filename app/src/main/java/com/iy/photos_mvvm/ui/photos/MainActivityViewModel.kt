package com.iy.photos_mvvm.ui.photos


import androidx.lifecycle.MutableLiveData
import com.iy.photosMVVM.model.Photos
import com.iy.photos_mvvm.api.ApiInterface
import com.iy.photos_mvvm.base.BaseViewModel
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import workOnBackground
import javax.inject.Inject

class MainActivityViewModel : BaseViewModel() {

    @Inject
    lateinit var apiInterface: ApiInterface

    val photosListAdapter: PhotosAdapter = PhotosAdapter()

    val loadingVisibility = MutableLiveData<Int>()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val photosAdapter: PhotosAdapter = PhotosAdapter()
    private lateinit var subscription: Disposable

    init {
        getPhotos()
    }

    private fun getPhotos() {
        val observable: Observable<List<Photos>> = apiInterface.getPhotos().workOnBackground()
        subscription = observable.subscribe({


        }, {

        })


    }
}

