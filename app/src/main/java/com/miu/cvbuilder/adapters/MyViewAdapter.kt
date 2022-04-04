package com.miu.cvbuilder.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.miu.cvbuilder.fragment.*

//Adapter
class MyViewAdapter(fm: FragmentManager, lc: Lifecycle) : FragmentStateAdapter(fm,lc) {
    override fun getItemCount(): Int = 5
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->  HomeFragment()
            1->  WorkFragment()
            2-> ProjectsFragment()
            3->  AboutMeFragment()
            4-> ContactFragment()
            else-> Fragment()
        }
    }
}