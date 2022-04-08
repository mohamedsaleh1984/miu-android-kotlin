package com.miu.cvbuilder

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    lateinit var spf:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Hid Action Bar from Main Activity
        supportActionBar?.hide()

        //Fetch Login Info from the SharedPreference
        spf = getSharedPreferences("login", Context.MODE_PRIVATE)
        val emailAddress = spf.getString("email","");
        val pwd = spf.getString("password","");

        editTextEmailAddress.setText(emailAddress)
        editTextPassword.setText(pwd)
    }

    fun onRegister(view:View){
        val i = Intent(applicationContext, RegisterActivity::class.java)
        startActivity(i)
    }

    fun onClickSignIn(view: View) {

        if (editTextEmailAddress.text.isNullOrEmpty()) {
            Toast.makeText(this, "Email address is required.", Toast.LENGTH_LONG).show()
            return;
        }

        if (editTextPassword.text.isNullOrEmpty()) {
            Toast.makeText(this, "Password is required.", Toast.LENGTH_LONG).show()
            return;
        }

        val email = spf.getString("email","no value")
        val pwd = spf.getString("password","no value")

        if ( email.equals(editTextEmailAddress.text.toString(),ignoreCase = true ) &&  editTextPassword.text.toString() == pwd) {
            Toast.makeText(applicationContext,"Successful Login",Toast.LENGTH_LONG).show()
            //Show Main Activity
            var intent = Intent(this,MainActivity::class.java);
            startActivity(intent)

        } else {
            Toast.makeText(this, "Wrong email address or password.", Toast.LENGTH_LONG).show()
        }
    }
}