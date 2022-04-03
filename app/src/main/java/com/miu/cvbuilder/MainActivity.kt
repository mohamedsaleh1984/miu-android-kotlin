package com.miu.cvbuilder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // init views
        val adapter = MyViewAdapter(supportFragmentManager,lifecycle)
        viewpager.adapter = adapter
        TabLayoutMediator(tlayaout,viewpager){tab,position->
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
                    tab.text="Contact"
                    tab.setIcon(R.drawable.ic_contact)
                }
                3->{
                    tab.text = "About Me"
                    tab.setIcon(R.drawable.ic_profile)
                }
            }
        }.attach()

    }

    class MyViewAdapter(fm: FragmentManager, lc: Lifecycle) : FragmentStateAdapter(fm,lc) {
        override fun getItemCount(): Int = 4
        override fun createFragment(position: Int): Fragment {
            return   when(position){
                0->  HomeFragment()
                1->  WorkFragment()
                2-> ContactFragment()
                3->  AboutMeFragment()
                else-> Fragment()
            }
        }
    }


}