package com.miu.assigfour

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class ShoppingCategory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)
    }

    fun onSelectCategory(view: View) {
        var ItemsListActivityIntent = Intent(this, ItemsListActivity::class.java)
        ItemsListActivityIntent.putExtra("category", view.tag.toString())
        startActivity(ItemsListActivityIntent)
    }
}