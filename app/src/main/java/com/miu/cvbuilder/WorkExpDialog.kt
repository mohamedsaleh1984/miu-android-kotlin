package com.miu.cvbuilder

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.miu.cvbuilder.adapters.OnAddWorkExperienceListener
import com.miu.cvbuilder.models.WorkExperince
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
        /*
        btnCancel.setOnClickListener({onClickCancel()})
        btnAdd.setOnClickListener({onClickAdd()})
        */
        return super.onCreateDialog(savedInstanceState)
    }

    private fun onClickAdd(){
        var wrkExp = WorkExperince(
        etJobTitle.text.toString(),
            etCompanyName.text.toString(),
            etFrom.text.toString(),
            etTo.text.toString(),
            etLocation.text.toString(),
            etTasks.text.toString(),
            R.drawable.company_default_logo
        );
        onAddWork.onAddWork(workExperienceEntry = wrkExp)
        this.dismiss()
    }

    private fun onClickCancel(){
        this.dismiss()
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        dialog!!.window?.setLayout(width,ViewGroup.LayoutParams.WRAP_CONTENT);
    }

}
