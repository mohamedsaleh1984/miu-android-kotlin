package com.miu.cvbuilder

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.miu.cvbuilder.models.User
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    lateinit var spf:SharedPreferences
    var usersList: ArrayList<User> = ArrayList<User>();
    var userInfo: User? = User("", "", "", "");
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Hid Action Bar from Main Activity
        supportActionBar?.hide()

        usersList.add(User("Mohamed", "Saleh", "Mohamed@hotmail.com", "password"));
        usersList.add(User("Max", "Pain", "mohamedsaleh1984@hotmail.com", "password"));

        spf = getSharedPreferences("login", Context.MODE_PRIVATE)
        val emailAddress = spf.getString("email","");
        val pwd = spf.getString("password","");

        editTextEmailAddress.setText(emailAddress)
        editTextPassword.setText(pwd)
        //editTextEmailAddress.setText( "Mohamed@hotmail.com")
        //editTextPassword.setText("password")
    }

    fun onClickSignIn(view: View) {
        val emailAddress = spf.getString("email","Mohamed@hotmail.com");
        val pwd = spf.getString("password","password");

        //var userName = editTextEmailAddress.text.toString();
        //var password = editTextPassword.text.toString();

        if (emailAddress.isNullOrEmpty()) {
            Toast.makeText(this, "Username is required.", Toast.LENGTH_LONG).show()
            return;
        }

        if (pwd.isNullOrEmpty()) {
            Toast.makeText(this, "Password is required.", Toast.LENGTH_LONG).show()
            return;
        }

        userInfo = validateUserInputs(emailAddress, pwd);
        if (userInfo != null) {
            Toast.makeText(applicationContext,"Successful Login",Toast.LENGTH_LONG).show()
            //Show Main Activity
            var intent = Intent(this,MainActivity::class.java);
            startActivity(intent)

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

    fun onForgetPassword(view:View){
        var emailAddress:String= "";
        for (user in usersList) {
            if (user.emailId?.lowercase().equals(editTextEmailAddress.text.toString())) {
                emailAddress = user.emailId.toString();
                break;
            }
        }

        if(emailAddress.isNotEmpty()){
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, emailAddress)
            startActivity(intent)
        }
        else{
            Toast.makeText(this, "Email is not found", Toast.LENGTH_LONG).show()
        }
    }
}