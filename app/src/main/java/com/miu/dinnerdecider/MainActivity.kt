package com.miu.dinnerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.miu.firstname.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var food:ArrayList<String> =ArrayList<String>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.gray_background));
        food.add("Hamburger");
        food.add("Pizza") ;
        food.add("Mexican");
        food.add( "American");
        food.add( "Chinese");
    }

    fun onClickDecide(view: android.view.View){
        var randChoice= Random.nextInt(0, food.size);
        tvChoice.text = food[randChoice];
    }

    fun onClickAdd(view: android.view.View) {
        if(editAddFood.text.length != 0){
            food.add(editAddFood.text.toString());
            editAddFood.getText().clear();
        }
    }

}