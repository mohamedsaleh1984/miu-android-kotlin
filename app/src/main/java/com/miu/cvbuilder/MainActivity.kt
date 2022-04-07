package com.miu.cvbuilder

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuBuilder
import com.google.android.material.tabs.TabLayoutMediator
import com.miu.cvbuilder.adapters.MyViewAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // init views
        val adapter = MyViewAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        /* Setting up Tab Layout with the ViewPageg2 is handled by the TabLayoutMediator
        * by passing your tabLayout id and viewpager id*/
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Home"
                    tab.setIcon(R.drawable.ic_home)
                }
                1 -> {
                    tab.text = "Work"
                    tab.setIcon(R.drawable.ic_work)
                }
                2 -> {
                    tab.text = "Projects"
                    tab.setIcon(R.drawable.ic_projects)
                }
                3 -> {
                    tab.text = "About Me"
                    tab.setIcon(R.drawable.ic_profile)
                }
                4 -> {
                    tab.text = "Contact"
                    tab.setIcon(R.drawable.ic_contact)
                }
            }
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        // Code to get the title and icon on the option overflow
        if (menu is MenuBuilder) {
            menu.setOptionalIconsVisible(true)
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onBackPressed() {
        if (viewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            // Otherwise, select the previous step.
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.whatsappMe -> sendWhatsAppMessage()
            else ->
                Toast.makeText(applicationContext, item.title.toString(), Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun sendWhatsAppMessage() {
        val whatsAppAppId = "com.whatsapp"
        try {
            intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            val text ="Hi, Moe"
            intent.`package`= whatsAppAppId
            intent.putExtra(Intent.EXTRA_TEXT, text);
            //startActivity(intent)
            startActivity(Intent.createChooser(intent, "Share with"));

        } catch (e: PackageManager.NameNotFoundException) {
            Toast.makeText(applicationContext, "You need to install WhatsApp", Toast.LENGTH_LONG).show()
        }
    }
}