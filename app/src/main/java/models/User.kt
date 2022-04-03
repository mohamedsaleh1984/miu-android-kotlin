package com.miu.cvbuilder.modles
import java.io.Serializable;
class User(var firstName: String?, var lastName: String?, var emailId: String?, var pwd: String?) :
    Serializable {
    override fun toString(): String {
        return "User(firstName=$firstName, lastName=$lastName, emailId=$emailId, pwd=$pwd)"
    }
}