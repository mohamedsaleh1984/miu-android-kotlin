package com.miu.assigfour


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_shopping_category.*

class ShoppingCategory : AppCompatActivity() {
    lateinit var userInfo: User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)

        val intent = intent
        val userForTest = intent.getStringExtra("name")
        //Toast.makeText(this,userForTest,Toast.LENGTH_SHORT).show()
        val userFromMainActivity = intent.getSerializableExtra("user")
        userInfo = userFromMainActivity as User;
        //Toast.makeText(this,userInfo.firstName,Toast.LENGTH_SHORT).show()
        tvUserEmailAddress.setText(userInfo.emailId)
    }

    fun onSelectCategory(view: View) {
        Toast.makeText(this,"Selected Category is " + view.tag.toString(),Toast.LENGTH_SHORT).show()
    }
}