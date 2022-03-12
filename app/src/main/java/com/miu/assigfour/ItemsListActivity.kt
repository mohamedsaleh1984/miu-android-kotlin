package com.miu.assigfour

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_items_list.*

class ItemsListActivity : AppCompatActivity() {
    lateinit var adapter: ItemsListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items_list)

        val techItems = ArrayList<Product>()
        techItems.add(
            Product(
                "Iphone",
                500,
                "Blue",
                R.drawable.blue_iphone,
                "777899",
                "IPhone - Blue Desc"
            )
        )
        techItems.add(
            Product(
                "Iphone",
                600,
                "Green",
                R.drawable.green_iphone,
                "8888",
                "Iphone - Green description"
            )
        )
        techItems.add(
            Product(
                "MacPro",
                900,
                "Black",
                R.drawable.mac_pro,
                "9999",
                "MacPro - Description"
            )
        )

        val clothingItems = ArrayList<Product>()
        clothingItems.add(
            Product(
                "Iphone",
                500,
                "Blue",
                R.drawable.blue_iphone,
                "777899",
                "IPhone - Blue Desc"
            )
        )
        clothingItems.add(
            Product(
                "Iphone",
                600,
                "Green",
                R.drawable.green_iphone,
                "8888",
                "Iphone - Green description"
            )
        )

        val beautyItems = ArrayList<Product>()
        beautyItems.add(
            Product(
                "Iphone",
                500,
                "Blue",
                R.drawable.blue_iphone,
                "777899",
                "IPhone - Blue Desc"
            )
        )


        val foodItems = ArrayList<Product>()
        foodItems.add(
            Product(
                "Iphone",
                500,
                "Blue",
                R.drawable.blue_iphone,
                "777899",
                "IPhone - Blue Desc"
            )
        )


        val intent = intent
        val category = intent.getStringExtra("category")
        // Set the Layout Manager
        recyclerView1.layoutManager = LinearLayoutManager(this)

        if (category.equals("Electronics")) {
            adapter = ItemsListAdapter(techItems)
        } else if (category.equals("Beauty")) {
            adapter = ItemsListAdapter(beautyItems)
        } else if (category.equals("Clothing")) {
            adapter = ItemsListAdapter(clothingItems)
        } else if (category.equals("Food")) {
            adapter = ItemsListAdapter(foodItems)
        }
        // Set adapter to your RecyclerView
        recyclerView1.adapter = adapter

        adapter.onItemClick = {product ->
            Toast.makeText(this,product.Title,Toast.LENGTH_SHORT).show();

        }
    }
}