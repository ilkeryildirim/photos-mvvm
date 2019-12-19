package com.iy.photos_mvvm.ui.photos


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

import com.iy.photosMVVM.model.Photos
import com.iy.photos_mvvm.R
import com.iy.photos_mvvm.databinding.ItemPhotosRowBinding

class PhotosAdapter: RecyclerView.Adapter<PhotosAdapter.ViewHolder>() {
    private lateinit var photosList:List<Photos>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemPhotosRowBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_photos_row, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(photosList[position])
    }

    override fun getItemCount(): Int {
        return if(::photosList.isInitialized) photosList.size else 0
    }

    fun updatePhotosList(postList:List<Photos>){
        this.photosList = postList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemPhotosRowBinding): RecyclerView.ViewHolder(binding.root){
        private val viewModel = PhotosItemViewModel()

        fun bind(photos:Photos){
            viewModel.bind(photos)
            binding.viewModel = viewModel
        }
    }
}