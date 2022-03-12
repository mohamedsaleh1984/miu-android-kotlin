package com.miu.assigfour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_items_list.*

class ItemsList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items_list)


        val  techItems = ArrayList<Product>()
        techItems.add(Product("Iphone",500,"Blue",R.drawable.ABlue,"777899","IPhone - Blue Desc"))
        techItems.add(Product("Iphone",600,"Green",R.drawable.AGreen,"8888","Iphone - Green description"))
        techItems.add(Product("MacPro",900,"Black",R.drawable.ALa,"9999","MacPro - Description"))
        // Set the Layout Manager
        recyclerView1.layoutManager = LinearLayoutManager(this)
        // Create an object for the MyAdapter
        val adapter = ItemsListAdapter(techItems)
        // Set adapter to your RecyclerView
        recyclerView1.adapter = adapter
    }
}