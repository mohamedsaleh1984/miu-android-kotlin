package com.miu.assigfour

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_create_user.*

class CreateUser : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)
    }

    fun onCreateAccount(view: View) {
        var mainActivityIntent = Intent(this, MainActivity::class.java)

        var fn = editFirstName.text.toString()
        var ln = editLastName.text.toString()
        var email = editTextEmailAddress.text.toString()
        var pwd = editTextPassword.text.toString()

        var userInfo:User? = User(fn,ln,email,pwd)
        mainActivityIntent.putExtra("user", userInfo)
        startActivity(mainActivityIntent)
    }
}