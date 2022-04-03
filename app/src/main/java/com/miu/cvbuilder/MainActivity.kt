package com.miu.cvbuilder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tablayoutkotlinlibrary.ViewPagerAdapter
import com.miu.cvbuilder.fragments.ContactFragment
import com.miu.cvbuilder.fragments.HomeFragment
import com.miu.cvbuilder.fragments.WorkFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create an object for the Adapter Class
        val adapter = ViewPagerAdapter(supportFragmentManager)
        // Call the addFragment to add Fragment tabs and Tab Title
        adapter.addFragment(HomeFragment(), "Home")
        adapter.addFragment(WorkFragment(), "Work")
        adapter.addFragment(ContactFragment(), "Contact")
        adapter.addFragment(ContactFragment(), "About Me")
        // set your adpater to the ViewPager UI on the Layout
        viewPager.adapter = adapter

        // set the ViewPager to the respective tabs
        tabs.setupWithViewPager(viewPager)
        // Setting Icon for the Tabs
        tabs.getTabAt(0)!!.setIcon(R.drawable.ic_home)
        tabs.getTabAt(1)!!.setIcon(R.drawable.ic_work)
        tabs.getTabAt(2)!!.setIcon(R.drawable.ic_contact)
        tabs.getTabAt(2)!!.setIcon(R.drawable.ic_profile)
    }
}