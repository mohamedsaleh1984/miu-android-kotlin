package com.miu.cvbuilder.adapters

import com.miu.cvbuilder.models.WorkExperince

interface OnAddWorkExperienceListener {
    fun onAddWork(workExperienceEntry: WorkExperince)
}
