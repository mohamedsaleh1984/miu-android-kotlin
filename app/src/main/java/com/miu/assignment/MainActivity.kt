package com.miu.assignment


import android.graphics.Color
import android.os.Bundle
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var tableLayoutid: TableLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tableLayoutid = findViewById<TableLayout>(R.id.tableLayoutRef) as TableLayout
    }

    fun onClickAdd(view: android.view.View) {

        val tableRow = TableRow(getApplicationContext())//this
        //set new Table row Layout Paramters
        val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        tableRow.setLayoutParams(layoutParams)

        //Add values into row by calling addView()
        var androidVersionVw = TextView(this)
        androidVersionVw.setText(editTextAndroidVersion.getText())
        androidVersionVw.setBackgroundColor(Color.CYAN);

        var androidCodeVw = TextView(this);
        androidCodeVw.setText(editTextAndroidCode.getText())
        androidCodeVw.setBackgroundColor(Color.CYAN);
        //clear controls
        editTextAndroidVersion.setText("")
        editTextAndroidCode.setText("")
        //Add Views...
        tableRow.addView(androidVersionVw, 0)
        tableRow.addView(androidCodeVw, 1)

        tableLayoutid.addView(tableRow) // id from Layout_file

    }

}