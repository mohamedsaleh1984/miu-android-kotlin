package com.miu.cvbuilder

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.miu.cvbuilder.adapters.OnAddWorkExperienceListener
import kotlinx.android.synthetic.main.work_exp_dialog.*


class WorkExpDialog(private val onAddWork: OnAddWorkExperienceListener) : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.work_exp_dialog,container,false)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        btnCancel.setOnClickListener({
            dismiss()
        })

        return super.onCreateDialog(savedInstanceState)

    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.widthPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width,height);
    }

}
