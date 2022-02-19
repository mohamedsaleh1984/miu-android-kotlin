package com.miu.dinnerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.miu.firstname.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var food =arrayOf<String>("Hamburger","Pizza","Mexican", "American", "Chinese");

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickDecide(view: android.view.View){
        var randChoice= Random.nextInt(0, food.size);
        tvChoice.text = food[randChoice];
    }
    fun onClickAdd(view: android.view.View) {

    }

}