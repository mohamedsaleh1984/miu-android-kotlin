package com.miu.cvbuilder

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window

class WorkExpDialog(context: Context) : Dialog(context) {
    init {
        setCancelable(false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.work_exp_dialog)
    }
}