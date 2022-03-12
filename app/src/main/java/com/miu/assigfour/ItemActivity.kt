package com.miu.assigfour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_item.*

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val intent = intent
        val itemId = intent.getStringExtra("id")
        val itemName = intent.getStringExtra("name")
        val itemDec= intent.getStringExtra("desc")
        val itemImage = intent.getIntExtra("image",R.drawable.blue_iphone)
        val itemColor = intent.getStringExtra("color")

        tvItemId.setText(itemId);
        tvItemName.setText(itemName)
        tvItemDesc.setText(itemDec)
        tvColor.setText(itemColor)

        if (itemImage != null) {
            imgViewPic.setImageResource(itemImage)
        }
        else{
            imgViewPic.setImageResource(R.drawable.mac_pro)
        }

    }
}