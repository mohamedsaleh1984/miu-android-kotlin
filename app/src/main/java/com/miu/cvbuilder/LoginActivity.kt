package com.miu.cvbuilder

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.miu.cvbuilder.modles.User
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    var usersList: ArrayList<User> = ArrayList<User>();
    var userInfo: User? = User("", "", "", "");
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usersList.add(User("Mohamed", "Saleh", "Mohamed@hotmail.com", "password"));
        usersList.add(User("Max", "Pain", "mohamedsaleh1984@hotmail.com", "password"));

        editTextEmailAddress.setText( "Mohamed@hotmail.com")
        editTextPassword.setText("password")
    }

    fun onClickSignIn(view: View) {
        var userName = editTextEmailAddress.text.toString();
        var password = editTextPassword.text.toString();

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