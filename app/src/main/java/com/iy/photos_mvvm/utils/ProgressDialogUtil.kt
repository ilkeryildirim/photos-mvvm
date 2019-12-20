package com.iy.photos_mvvm.utils

import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.iy.photos_mvvm.R

class ProgressDialogUtil(mContext: Context){

    var mProgressDialog:ProgressDialog = ProgressDialog(mContext)

    init {
        if (mProgressDialog.window != null) mProgressDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        mProgressDialog.setContentView(R.layout.progress_dialog)
        mProgressDialog.isIndeterminate = true
        mProgressDialog.setCancelable(true)
        mProgressDialog.setCanceledOnTouchOutside(false)
    }

    fun show(){
        mProgressDialog.show()
    }

    fun dismiss(){
        mProgressDialog.dismiss()
    }
}