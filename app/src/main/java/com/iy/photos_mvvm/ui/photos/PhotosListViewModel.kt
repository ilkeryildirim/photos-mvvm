package com.iy.photos_mvvm.ui.photos


import androidx.lifecycle.MutableLiveData
import com.iy.photos_mvvm.api.ApiInterface
import com.iy.photos_mvvm.base.BaseViewModel
import javax.inject.Inject

class PhotosListViewModel : BaseViewModel() {

    @Inject
    lateinit var apiInterface: ApiInterface

    val loadingVisibility= MutableLiveData<Int>()
    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val photosAdapter: PhotosAdapter = PhotosAdapter()

}