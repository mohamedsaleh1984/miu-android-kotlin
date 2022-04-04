package com.miu.cvbuilder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.miu.cvbuilder.adapters.MyViewAdapter
import com.miu.cvbuilder.fragment.AboutMeFragment
import com.miu.cvbuilder.fragment.ContactFragment
import com.miu.cvbuilder.fragment.HomeFragment
import com.miu.cvbuilder.fragment.WorkFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // init views
        val adapter = MyViewAdapter(supportFragmentManager,lifecycle)
        viewPager.adapter = adapter

        /* Setting up Tab Layout with the ViewPageg2 is handled by the TabLayoutMediator
        * by passing your tablayout id and viewpager id*/
        TabLayoutMediator(tablayaout,viewPager){tab,position->
            when(position){
                0->{
                    tab.text="Home"
                    tab.setIcon(R.drawable.ic_home)
                }
                1->{
                    tab.text="Work"
                    tab.setIcon(R.drawable.ic_work)
                }
                2->{
                    tab.text = "Projects"
                    tab.setIcon(R.drawable.ic_projects)
                }
                3->{
                    tab.text = "About Me"
                    tab.setIcon(R.drawable.ic_profile)
                }
                4->{
                    tab.text="Contact"
                    tab.setIcon(R.drawable.ic_contact)
                }
            }
        }.attach()
    }
    override fun onBackPressed() {
        if (viewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            // Otherwise, select the previous step.
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }
}