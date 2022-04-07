package com.miu.cvbuilder.fragment

import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

        tvPhone.setOnClickListener({ CallNumber() })
        img_phone.setOnClickListener({ CallNumber() })
        tvPhone2.setOnClickListener({ CallNumber() })

        tv_email.setOnClickListener({ SendEmail() })
        email.setOnClickListener({ SendEmail() })
        emailImg.setOnClickListener({ SendEmail() })

        tvlinkedIn.setOnClickListener({ OpenLinkedIn() })
        tvlinkedIn2.setOnClickListener({ OpenLinkedIn() })
        img_linkedIn.setOnClickListener({ OpenLinkedIn() })

        tvGit.setOnClickListener({ OpenGitHub() })
        tvGit2.setOnClickListener({ OpenGitHub() })
        gitImg.setOnClickListener({ OpenGitHub() })
    }

    private fun OpenLinkedIn() {
        val addressUri = Uri.parse("https://www.linkedin.com/in/mohamedsaleh1984/")
        val intent = Intent(Intent.ACTION_VIEW, addressUri)
        if (activity?.let { intent.resolveActivity(it.packageManager) } != null) {
            getActivity()?.startActivity(intent)
        } else {
            Toast.makeText(activity, "Doesn't support this action", Toast.LENGTH_LONG).show()
        }
    }

    private fun SendEmail() {
        val addressUri = Uri.parse("mailto:mohamedsaleh1984@hotmail.com")
        val intent = Intent(Intent.ACTION_SENDTO, addressUri)
        if (activity?.let { intent.resolveActivity(it.packageManager) } != null) {
            getActivity()?.startActivity(intent)
        } else {
            Toast.makeText(activity, "Doesn't support this action", Toast.LENGTH_LONG).show()
        }
    }

    private fun CallNumber() {
        val addressUri = Uri.parse("tel:+19292628798")
        val intent = Intent(Intent.ACTION_DIAL, addressUri)
        if (activity?.let { intent.resolveActivity(it.packageManager) } != null) {
            getActivity()?.startActivity(intent)
        } else {
            Toast.makeText(activity, "Doesn't support this action", Toast.LENGTH_LONG).show()
        }
    }

    private fun OpenGitHub() {
        val addressUri = Uri.parse("https://github.com/mohamedsaleh1984")
        val intent = Intent(Intent.ACTION_VIEW, addressUri)
        if (activity?.let { intent.resolveActivity(it.packageManager) } != null) {
            getActivity()?.startActivity(intent)
        } else {
            Toast.makeText(activity, "Doesn't support this action", Toast.LENGTH_LONG).show()
        }
    }
}