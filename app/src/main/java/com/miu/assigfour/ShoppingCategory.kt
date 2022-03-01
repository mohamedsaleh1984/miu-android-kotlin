package com.miu.assigfour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class ShoppingCategory : AppCompatActivity() {
    lateinit var userInfo: User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)

        val temp = intent.getSerializableExtra("user")
        userInfo = temp as User
    }
}