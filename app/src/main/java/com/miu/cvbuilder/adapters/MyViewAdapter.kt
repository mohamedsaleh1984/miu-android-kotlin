package com.miu.cvbuilder.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.miu.cvbuilder.fragment.AboutMeFragment
import com.miu.cvbuilder.fragment.ContactFragment
import com.miu.cvbuilder.fragment.HomeFragment
import com.miu.cvbuilder.fragment.WorkFragment

//Adapter
class MyViewAdapter(fm: FragmentManager, lc: Lifecycle) : FragmentStateAdapter(fm,lc) {
    override fun getItemCount(): Int = 4
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->  HomeFragment()
            1->  WorkFragment()
            2-> ContactFragment()
            3->  AboutMeFragment()
            else-> Fragment()
        }
    }
}