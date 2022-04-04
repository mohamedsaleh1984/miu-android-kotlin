package com.miu.cvbuilder.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.miu.cvbuilder.R
import kotlinx.android.synthetic.main.fragment_contact.*

class ContactFragment : Fragment( ) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvPhone.setOnClickListener(object : OnClickListener {
            override fun onClick(view: View?) {
                val addressUri = Uri.parse("tel:+1292628798")
                val intent = Intent(Intent.ACTION_DIAL, addressUri)
                getActivity()?.startActivity(intent)
            }
        })

        tv_email.setOnClickListener(object : OnClickListener {
            override fun onClick(view: View?) {
                val addressUri = Uri.parse("mailto:mohamedsaleh1984@hotmail.com")
                val intent = Intent(Intent.ACTION_SENDTO, addressUri)
                getActivity()?.startActivity(intent)
            }
        })

        tvlinkedIn.setOnClickListener(object : OnClickListener {
            override fun onClick(view: View?) {
                val addressUri = Uri.parse("https://www.linkedin.com/in/mohamedsaleh1984/")
                val intent = Intent(Intent.ACTION_VIEW, addressUri)
                getActivity()?.startActivity(intent)
            }
        })

        tvGit.setOnClickListener(object : OnClickListener {
            override fun onClick(view: View?) {
                val addressUri = Uri.parse("https://github.com/mohamedsaleh1984")
                val intent = Intent(Intent.ACTION_VIEW, addressUri)
                getActivity()?.startActivity(intent)
            }
        })

    }
}