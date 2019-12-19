package com.iy.photos_mvvm.ui.photos

import androidx.lifecycle.MutableLiveData
import com.iy.photos_mvvm.base.BaseViewModel
import com.iy.photosMVVM.model.Photos

class PhotosItemViewModel : BaseViewModel() {

    private val author = MutableLiveData<String>()
    private val downloadUrl = MutableLiveData<String>()

    fun bind(photos: Photos) {

        author.value=photos.author
        downloadUrl.value=photos.author
    }
    fun getPhotoAuthor()=author

    fun getPhotoUrl()=downloadUrl
}