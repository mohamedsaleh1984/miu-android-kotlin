package com.miu.assigfour

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_quiz.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class QuizActivity : AppCompatActivity() {
    var q1: Boolean = false;
    var q2: Boolean = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        //Radio Buttons
        rbReadOnly.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                q1 = true;
            }
        };
        rbCanbeChange.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                q1 = false;
            }
        };
        rbStringInter.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                q1 = false;
            }
        };

        //CheckBoxList
        chkExtensionFunction.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked && chkNullSafety.isChecked) {
                q2 = true;
            }
        }
        chkNullSafety.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked && chkExtensionFunction.isChecked) {
                q2 = true;
            }
        }
        chkNotFunctional.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                q2 = false;
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun onSubmit(view: View) {
        var stringMessage:String="";
        val dateTime = LocalDateTime.now();
        var dateTimeFormatted:String = dateTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));

        if(q1 && q2){
            stringMessage ="Congratulations, You submitted on ${dateTimeFormatted}, Your achieved 100%"
        }
        else if(q1 || q2){
            stringMessage ="Congratulations, You submitted on ${dateTimeFormatted}, Your achieved 50%"
        }
        else if(q1 == false &&q2 == false){
            stringMessage ="Try again, You submitted on ${dateTimeFormatted}, Your achieved 0%"
        }

        // build alert dialog
        val dialogBuilder = AlertDialog.Builder(this)
        // set message of alert dialog
        dialogBuilder.setMessage(stringMessage)
            .setCancelable(false)
            .setPositiveButton("Ok", DialogInterface.OnClickListener { dialog, id -> dialog.cancel() })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, id -> dialog.cancel() })

        val alert = dialogBuilder.create()
        alert.setTitle("Results")
        alert.show()
    }

    fun onReset(view: View) {
        rg.clearCheck()
        chkExtensionFunction.isChecked = false;
        chkNotFunctional.isChecked = false;
        chkNullSafety.isChecked = false;
    }
}