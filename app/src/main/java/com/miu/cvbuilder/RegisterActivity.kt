package com.miu.cvbuilder

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.editTextEmailAddress
import kotlinx.android.synthetic.main.activity_register.editTextPassword

class RegisterActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        //Hid Action Bar
        supportActionBar?.hide()

        btnRegister.setOnClickListener({clickHandler()})
    }

    private fun clickHandler( ) {

        if (editTextEmailAddress.text.isNullOrEmpty()) {
            Toast.makeText(this, "Username is required.", Toast.LENGTH_LONG).show()
            return;
        }

        if (editTextPassword.text.isNullOrEmpty()) {
            Toast.makeText(this, "Password is required.", Toast.LENGTH_LONG).show()
            return;
        }



        // Create and Read the SharedPreferences
        val spf = getSharedPreferences("login", Context.MODE_PRIVATE)
        // To write a data using SharedPreferences Object
        val spe = spf.edit()
        // Using put method to write the data in SharedPreferences
        spe.putString("email", editTextEmailAddress.text.toString())
        spe.putString("password", editTextPassword.text.toString())
        spe.apply() //

        Toast.makeText(this, "Registered", Toast.LENGTH_LONG).show()
        // Once finished writing we need to go back to the main activity to show the Login
        finish() // automatically destroy the activity and give the visibility of Main Activity
    }

}