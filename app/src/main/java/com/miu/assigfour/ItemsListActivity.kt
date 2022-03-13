package com.miu.assigfour

import android.content.Intent
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
                "Clothing 1",
                500,
                "Blue",
                R.drawable.cloth1,
                "777899",
                "Clothing 1 Desc"
            )
        )
        clothingItems.add(
            Product(
                "Clothing 2",
                500,
                "Green",
                R.drawable.cloth2,
                "748596",
                "Clothing 2 Desc"
            )
        )
        clothingItems.add(
            Product(
                "Clothing 3",
                500,
                "Light Blue",
                R.drawable.cloth3,
                "748596",
                "Clothing 3 Desc"
            )
        )


        val beautyItems = ArrayList<Product>()
        beautyItems.add(
            Product(
                "Beauty Item 1",
                500,
                "Off-White",
                R.drawable.beautyitem,
                "777899",
                "Beauty Item Desc"
            )
        )
        beautyItems.add(
            Product(
                "Beauty Item 2",
                500,
                "Pink",
                R.drawable.beautyitem2,
                "777899",
                "Beauty Item2 Desc"
            )
        )


        val foodItems = ArrayList<Product>()
        foodItems.add(
            Product(
                "Bell Peper",
                500,
                "Green",
                R.drawable.bellpeper,
                "777899",
                "Green Pepper"
            )
        )
        foodItems.add(
            Product(
                "Egg Plant",
                415,
                "Black",
                R.drawable.eggplant,
                "777899",
                "Black Egg Plant"
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
            var itemActivityIntent = Intent(this, ItemActivity::class.java)
            itemActivityIntent.putExtra("id",product.ItemId )
            itemActivityIntent.putExtra("name",product.Title )
            itemActivityIntent.putExtra("desc",product.Desc )
            itemActivityIntent.putExtra("image",product.Image )
            itemActivityIntent.putExtra("color",product.Color )
            startActivity(itemActivityIntent)
        }
    }
}