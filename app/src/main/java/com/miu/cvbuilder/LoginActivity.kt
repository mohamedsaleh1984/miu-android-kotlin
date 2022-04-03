package com.miu.cvbuilder

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    var usersList: ArrayList<User> = ArrayList<User>();
    var userInfo: User? = User("", "", "", "");
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val intent = intent
        val userFromCreateUserActivity = intent.getSerializableExtra("user")
        if (userFromCreateUserActivity != null) {
            userInfo = userFromCreateUserActivity as User;
            usersList.add(
                User(
                    userInfo?.firstName,
                    userInfo?.lastName,
                    userInfo?.emailId,
                    userInfo?.pwd
                )
            );
        }


        usersList.add(User("Mohamed", "Saleh", "Mohamed@hotmail.com", "password"));
        usersList.add(User("Max", "Pain", "mohamedsaleh1984@hotmail.com", "password"));
        usersList.add(User("Mark", "Williams", "Mark@hotmail.com", "password"));
        usersList.add(User("Tolu", "Ademi", "Tolu@hotmail.com", "password"));
        usersList.add(User("Fomi", "Deleki", "Fomi@hotmail.com", "password"));
        usersList.add(User("mega", "cccc", "1", "1"));
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "onResume.", Toast.LENGTH_SHORT).show()
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
           //Go to Main Activity

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

    fun onCreateUser(view: View) {

    }

    fun onForgetPassword(view:View){
        var emailAddress:String= "";
        for (user in usersList) {
            if (user.emailId?.lowercase().equals(editTextEmailAddress.text.toString())) {
                emailAddress = user.emailId.toString();
                break;
            }
        }

        if(emailAddress.length > 0){
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