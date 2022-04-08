package com.miu.cvbuilder.fragment

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.miu.cvbuilder.R
import kotlinx.android.synthetic.main.fragment_contact.*

class ContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvPhone.setOnClickListener({ callNumber() })
        img_phone.setOnClickListener({ callNumber() })
        tvPhone2.setOnClickListener({ callNumber() })

        tv_email.setOnClickListener({ sendEmail() })
        email.setOnClickListener({ sendEmail() })
        emailImg.setOnClickListener({ sendEmail() })

        tvlinkedIn.setOnClickListener({ openLinkedIn() })
        tvlinkedIn2.setOnClickListener({ openLinkedIn() })
        img_linkedIn.setOnClickListener({ openLinkedIn() })

        tvGit.setOnClickListener({ openGitHub() })
        tvGit2.setOnClickListener({ openGitHub() })
        gitImg.setOnClickListener({ openGitHub() })
    }

    private fun openLinkedIn() {
        val addressUri = Uri.parse("https://www.linkedin.com/in/mohamedsaleh1984/")
        val intent = Intent(Intent.ACTION_VIEW, addressUri)
        startActivity(intent)
    }

    private fun sendEmail() {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, "mohamedsaleh1984@hotmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Email Subject");
        startActivity(Intent.createChooser(intent, "Email via..."));
    }

    private fun callNumber() {
        val addressUri = Uri.parse("tel:+19292628798")
        val intent = Intent(Intent.ACTION_DIAL, addressUri)
        startActivity(intent)
    }

    private fun openGitHub() {
        val addressUri = Uri.parse("https://github.com/mohamedsaleh1984")
        val intent = Intent(Intent.ACTION_VIEW, addressUri)
        startActivity(intent)
    }
}