package com.miu.cvbuilder.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.miu.cvbuilder.R
import com.miu.cvbuilder.WorkExpDialog
import com.miu.cvbuilder.adapters.OnAddWorkExperienceListener
import com.miu.cvbuilder.adapters.WorkExperienceAdapter
import com.miu.cvbuilder.models.WorkExperince
import kotlinx.android.synthetic.main.fragment_work.*


class WorkFragment : Fragment(), OnAddWorkExperienceListener {
    private lateinit var wrkExpAdapter: WorkExperienceAdapter
    lateinit var fabButton: FloatingActionButton

    var workExps = ArrayList<WorkExperince>()
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
        fabButton = view.findViewById(R.id.fab)
        fabButton.setOnClickListener { showAdWorkExperienceFragment() }
        setDataSeeding()

        work_recycler.layoutManager = LinearLayoutManager(requireContext())
        wrkExpAdapter = WorkExperienceAdapter(workExps)
        work_recycler.adapter = wrkExpAdapter
    }

    private fun showAdWorkExperienceFragment() {
        WorkExpDialog(this).show(childFragmentManager, "WorkExpDialogTAG")
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

        workExps.add(
            WorkExperince("Microsoft Dynamics Developer ","Genena Group","01/2019","01/2020","Egypt, New Cairo",
                "Tasks Performed:\n" +
                        "•\tLed design of new AX modules and added new features and customizations, security for modules\n" +
                        "•\tDesign and integrate SSRS reports with MS Dynamics AX 2012 R3.\n" +
                        "•\tCoordinate production environment backups and releases.\n" +
                        "Achievement:\n" +
                        "•\tIntroduced and Implemented Property Management module instead of buying another product and integrate it to Dynamics AX.\n" +
                        "Technologies Used: X++, AOT, MS SQL (TSQL), SSRS, .NET Framework 4.6 (C#.NET).\n" +
                        "" +
                        "",R.drawable.company_default_logo))

        workExps.add(
            WorkExperince("Backend Software Developer","DR SULAIMAN AL HABIB MEDICAL GROUP","01/2015","07/2017","Saudi Arabia, Riyadh",
                "Tasks Performed:\n" +
                        "•\tDevelop different sub-modules (Infection Control, Doctor Workspace)\n" +
                        "•\tWrite complex SQL queries, triggers, and stored procedures.\n" +
                        "Achievements:\n" +
                        "•\tEstablished e-mail alerting system including scheduling, e-mail templates, viewer based on Windows service.\n" +
                        "Technologies Used: .NET Framework 3.5 (C#.NET), MS Composite UI Application Block Framework, LINQ, SQL Server 2008, Crystal Reports 2010, TFS, Windows Services, JSON, SOAP, Web Services/API, Infragistics (Windows), LLBLGen 2.4 (ORM). \n",R.drawable.hmg))

        workExps.add(
            WorkExperince("Software Developer","LOGICA I-TECH","02/2014","12/2014","Egypt, Giza",
                "Tasks Performed:\n" +
                        "•\tCreate interactive applications for a single and multi-touch screen.\n" +
                        "•\tDevelop IPC programs in Win32 / C++ to communicate with Action Script 3.\n" +
                        "Achievements:\n" +
                        "•\tProgram middleware to integrate Arduino, Action Script 3, and Windows application.\n" +
                        "•\tProvide training on AS3 for newcomer software developers.\n" +
                        "Technologies Used: .NET Framework, C#, Win32 API, C++, Micro-C, Arduino, ActionScript 3.\n",R.drawable.company_default_logo))
    }

    override fun onAddWork(workExperienceEntry: WorkExperince) {
        //push the data from the Dialog
        workExps.add(workExperienceEntry)
        //Notify the RecyclerView to redraw the list.
        wrkExpAdapter.notifyItemInserted(workExps.size)
    }
}


