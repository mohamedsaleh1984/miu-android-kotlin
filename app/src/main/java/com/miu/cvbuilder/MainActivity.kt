package com.miu.cvbuilder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // init views
        viewPager = findViewById(R.id.fragmentHolder)
       
    }
}