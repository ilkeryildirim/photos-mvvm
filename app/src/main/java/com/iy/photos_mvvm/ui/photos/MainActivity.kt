package com.iy.photos_mvvm.ui.photos

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.iy.photos_mvvm.R
import com.iy.photos_mvvm.databinding.ActivityMainBinding
import com.iy.photos_mvvm.di.ViewModelFactory


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    lateinit var mProgressDialog: Dialog
    private var errorSnackbar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this, ViewModelFactory(this))
            .get(MainActivityViewModel::class.java)

        binding.viewModel = viewModel
        binding.rvPhotos.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        viewModel.errorMessage.observe(this, Observer { errorMessage ->
            if (errorMessage != null) showError(errorMessage) else hideError()
        })

        viewModel.loadingVisibility.observe(this, Observer { visibility ->
            if (visibility == View.VISIBLE) showLoading() else hideLoading()

        })

    }

    private fun hideLoading() {
        mProgressDialog.dismiss()
    }

    private fun showLoading() {
        mProgressDialog = Dialog(this)
        mProgressDialog.apply {
            window?.let {
                it.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                it.requestFeature(Window.FEATURE_NO_TITLE)
            }
            setContentView(R.layout.progress_dialog)
            setCancelable(true)
            setCanceledOnTouchOutside(false)
        }.show()

    }

    private fun showError(errorMessage: String) {
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.show()

    }

    private fun hideError() {
        errorSnackbar?.dismiss()
    }


}
