package com.iy.photos_mvvm.ui.photos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.iy.photos_mvvm.R
import com.iy.photos_mvvm.databinding.ActivityMainBinding

import com.iy.photos_mvvm.di.ViewModelFactory

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private val viewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory(this)).get(MainActivityViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner
        binding.viewModel = viewModel
    }
}
