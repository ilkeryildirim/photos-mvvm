package com.iy.photos_mvvm.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.iy.photos_mvvm.ui.photos.MainActivityViewModel

class ViewModelFactory(private val activity:AppCompatActivity):ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {

        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}