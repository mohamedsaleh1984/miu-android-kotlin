package com.miu.cvbuilder.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.miu.cvbuilder.R
import com.miu.cvbuilder.adapters.WorkExperienceAdapter
import com.miu.cvbuilder.models.WorkExperince
import kotlinx.android.synthetic.main.fragment_work.*

class WorkFragment : Fragment() {
    private lateinit var wrkExpAdapter: WorkExperienceAdapter
    private var workExps = ArrayList<WorkExperince>()
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         return inflater.inflate(R.layout.fragment_work, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.work_recycler)

        setDataSeeding()

        work_recycler.layoutManager = LinearLayoutManager(requireContext())
        wrkExpAdapter = WorkExperienceAdapter(workExps)
        work_recycler.adapter = wrkExpAdapter
    }


    private fun setDataSeeding(){
        workExps.add(
            WorkExperince("Software Developer","eVero Corporation","12/2020","Present","USA, New York",
            "Tasks Performed:\n" +
                    "•\tDevelop, test, and debug .Net Core RESTful Web Services and SPA (React, Vue) frameworks.\n" +
                    "•\tHands on database design and TSQL scripting.\n" +
                    "•\tIntegrate our products with different 3rd Party applications ()\n" +
                    "•\tResolve support tickets.\n" +
                    "Achievement:\n" +
                    "•\tMigrating over 100 projects from TFVC to Self-hosted Microsoft ADO Environment; setup the pipeline templates, develop internal tools to generate multi-stage pipelines.\n" +
                    "•\tScripting docker-compose for .net core applications.\n" +
                    "•\tDeveloped annotation-based framework to dynamically generate CRUD operations (Back-end/Front-end) and client-side validation for specific table schema.\n" +
                    "Technologies Used: C# Language, .Net Core, REST API, Vue.JS, ReactJS, TypeScript, AzureDevOps CI/CD, Yaml, MS SQL 2019, Docker, Git, Agile.\n",R.drawable.evero))



    }
}