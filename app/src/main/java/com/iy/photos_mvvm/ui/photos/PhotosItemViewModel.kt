package com.iy.photos_mvvm.ui.photos

import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import com.iy.photos_mvvm.base.BaseViewModel
import com.iy.photos_mvvm.databinding.ItemPhotosRowBinding
import com.iy.photos_mvvm.model.Photos


class PhotosItemViewModel : BaseViewModel() {

    private val author = MutableLiveData<String>()
    private val downloadUrl = MutableLiveData<String>()

    fun bind(photos: Photos, binding: ItemPhotosRowBinding) {

        author.value = photos.author
        downloadUrl.value = photos.download_url
        loadImage(binding.ivPhoto,downloadUrl.value)

    }

    fun loadImage(view: ImageView, url: String?) {
        Glide.with(view.context).load(url).into(view)

    }

    fun getPhotoAuthor() = author

    fun getPhotoUrl() = downloadUrl
}