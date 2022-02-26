package com.miu.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableRow

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
    }

    fun onClickAdd(view: android.view.View){
        /*
        val tableRow = TableRow(getApplicationContext())//this
        //set new Table row Layout Paramters
        val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        tableRow.setLayoutParams(layoutParams)
        //Add values into row by calling addView()

        var androidVersion = editTextAndroidVersion.getText();
        var androidCode = editTextAndroidCode.getText();

        tableRow.addView(androidVersion,0);
        tableRow.addView(androidCode,1);
        tableLayoutid.addView(tableRow) // id from Layout_file
*/

    }

}