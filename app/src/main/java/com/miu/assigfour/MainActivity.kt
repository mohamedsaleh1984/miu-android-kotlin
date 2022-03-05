package com.miu.assigfour

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var usersList: ArrayList<User> = ArrayList<User>();
    var userInfo: User? = User("", "", "", "");
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usersList.add(User("Mohamed", "Saleh", "Mohamed@hotmail.com", "password"));
        usersList.add(User("Max", "Pain", "mohamedsaleh1984@hotmail.com", "password"));
        usersList.add(User("Mark", "Williams", "Mark@hotmail.com", "password"));
        usersList.add(User("Tolu", "Ademi", "Tolu@hotmail.com", "password"));
        usersList.add(User("Fomi", "Deleki", "Fomi@hotmail.com", "password"));
        usersList.add(User("mega", "cccc", "1", "1"));
    }

    fun onClickSignIn(view: View) {
        var userName = editTextTextEmailAddress.text.toString();
        var password = editTextTextPassword.text.toString();

        if (userName.isNullOrEmpty()) {
            Toast.makeText(this, "Username is required.", Toast.LENGTH_LONG).show()
            return;
        }

        if (password.isNullOrEmpty()) {
            Toast.makeText(this, "Password is required.", Toast.LENGTH_LONG).show()
            return;
        }

        userInfo = validateUserInputs(userName, password);
        if (userInfo != null) {

            var shoppingIntent = Intent(this, ShoppingCategory::class.java)
         //   Log.i("ddd", userInfo.toString())
            shoppingIntent.putExtra("user", userInfo)
            shoppingIntent.putExtra("name","Mohamed Saleh")
            startActivity(shoppingIntent)
        } else {
            Toast.makeText(this, "Wrong username or password.", Toast.LENGTH_LONG).show()
        }
    }

    fun validateUserInputs(userName: String, password: String): User? {

        var bResult: User = User("", "", "", "");
        for (user in usersList) {
            if (user.emailId?.lowercase()
                    .equals(userName.lowercase()) && user.pwd.equals(password)
            ) {
                return user;
                break;
            }
        }
        return null
    }

    fun onCeateAccount(view: View) {
        var createIndent: Intent = Intent(this@MainActivity, CreateUser::class.java)
        startActivity(createIndent)

    }

    fun onText(view: View) {
        var createIndent: Intent = Intent(this@MainActivity, ShoppingCategory::class.java)
        startActivity(createIndent)
    }
}