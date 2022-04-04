package com.miu.cvbuilder.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.miu.cvbuilder.R
import com.miu.cvbuilder.models.WorkExperince

class WorkExperienceAdapter (var workExplist:ArrayList<WorkExperince>) : RecyclerView.Adapter<WorkExperienceAdapter.WorkExpViewHolder>(){
    var onItemClick: ((WorkExperince) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkExperienceAdapter.WorkExpViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.work_experience,parent,false)
        return WorkExpViewHolder(view)
    }

    override fun onBindViewHolder(holder: WorkExperienceAdapter.WorkExpViewHolder, position: Int) {
        val workEntry = workExplist[position]
        holder.imageView.setImageResource(workEntry.image)
        holder.jobTitle.text = workEntry.jobTitle
        holder.company.text = workEntry.company
        holder.dateFrom.text = workEntry.dateFrom
        holder.dateTo.text = workEntry.dateTo
        holder.location.text = workEntry.location
        holder.description.text = workEntry.description
    }

    override fun getItemCount(): Int {
        return workExplist.size
    }

    class WorkExpViewHolder(wex: View) : RecyclerView.ViewHolder(wex){
        val imageView: ImageView = itemView.findViewById(R.id.img_cop_logo)
        val jobTitle: TextView = itemView.findViewById(R.id.jobTitle)
        val company: TextView = itemView.findViewById(R.id.company)
        val dateFrom: TextView = itemView.findViewById(R.id.dateFrom)
        val dateTo: TextView = itemView.findViewById(R.id.dateTo)
        val location: TextView = itemView.findViewById(R.id.location)
        val description: TextView = itemView.findViewById(R.id.description)
    }
}