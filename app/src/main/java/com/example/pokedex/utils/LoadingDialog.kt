package com.example.pokedex.utils

import android.app.Activity
import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.example.pokedex.R

class LoadingDialog(val mActivity: Activity) {
    private lateinit var isDialog: AlertDialog
    fun startLoading(){
        val inflater = mActivity.layoutInflater
        val dialogView = inflater.inflate(R.layout.loading_item, null)
        val builder = AlertDialog.Builder(mActivity)
        builder.setView(dialogView)
        builder.setCancelable(false)
        isDialog = builder.create()
        isDialog.window?.decorView?.setBackgroundResource(R.drawable.dialog_background)
        isDialog.show()
    }
    fun isDismiss(){
        isDialog.dismiss()
    }
}