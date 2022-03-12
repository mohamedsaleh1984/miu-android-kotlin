package com.miu.assigfour


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_shopping_category.*

class ShoppingCategory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)
    }

    fun onSelectCategory(view: View) {
        //Toast.makeText(this,"Selected Category is " + view.tag.toString(),Toast.LENGTH_SHORT).show()
    }
}