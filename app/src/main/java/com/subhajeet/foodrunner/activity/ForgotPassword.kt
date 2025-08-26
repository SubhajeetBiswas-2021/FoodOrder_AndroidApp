package com.subhajeet.foodrunner.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.subhajeet.foodrunner.R

class ForgotPassword : AppCompatActivity() {
    lateinit var etMobileNumber:EditText
    lateinit var etemailadrs:EditText
    lateinit var btnNext:Button

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etemailadrs = findViewById(R.id.etemailadrs)
        btnNext = findViewById(R.id.btnNext)
        auth = FirebaseAuth.getInstance()

       /* btnNext.setOnClickListener {

            // Retrieve entered data
            val mobileNumber = etMobileNumber.text.toString()
            val emailAddress = etemailadrs.text.toString()


            // Create an Intent
            val intent = Intent(this@ForgotPassword, ForgotCredentials::class.java)
            // Pass data to the next screen using Intent extras
            intent.putExtra("mobileNumber", mobileNumber)
            intent.putExtra("emailAddress", emailAddress)
            // Start the new activity
            startActivity(intent)
        }*/

        btnNext.setOnClickListener{
            val sEmail= etemailadrs.text.toString()
            auth.sendPasswordResetEmail(sEmail)
                .addOnSuccessListener {
                    Toast.makeText(this,"Plese Check your Email",Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Toast.makeText(this,it.toString(),Toast.LENGTH_SHORT).show()
                }
        }
    }
}