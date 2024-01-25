package com.example.gcashtestjweatherapp.utils

import android.app.Activity
import com.google.android.material.bottomsheet.BottomSheetDialog

class BaseBottomSheetDialog(private val activity: Activity, theme: Int) :
    BottomSheetDialog(activity, theme) {

    override fun onStart() {
        super.onStart()
        this.window?.let {
            it.callback = UserInteractionAwareCallback(it.callback, activity)
        }
    }
}
