package com.miu.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.miu.firstname.R

class MainActivity : AppCompatActivity() {
    val MyLog = "LifeCycle"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
    }
    override fun onResume(){
        super.onResume()
        Log.i(MyLog,"onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(MyLog,"onDestroy")
    }

    override fun onStart() {
        super.onStart()
        Log.i(MyLog,"onStart")
    }



}