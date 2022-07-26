package com.rupinder.javaapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var etName: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var tvForgotPass: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etName=findViewById(R.id.etName)
        etPassword=findViewById(R.id.etPassword)
        btnLogin=findViewById(R.id.btnLogin)
        tvForgotPass=findViewById(R.id.tvForgotPass)

        tvForgotPass.setOnClickListener{
            var intent = Intent(this,signup::class.java)
            startActivity(intent)
            Toast.makeText(this,resources.getString(R.string.imp_soon), Toast.LENGTH_LONG).show()
        }
        btnLogin.setOnClickListener{
            var name=etName.text.toString()
            var Password=etPassword.text.toString()
            if(name.isNullOrEmpty()==true){
                etName.error=resources.getString(R.string.ENTER_NAME)
                etName.requestFocus()
            }
            else if(Password.isNullOrEmpty()==true){
                etPassword.error=resources.getString(R.string.enter_pass)
                etPassword.requestFocus()
            }
            else if (Password.length<6){
                etPassword.error=resources.getString(R.string.pass_length)
                etPassword.requestFocus()
            }
            else {
                var intent = Intent()
                Toast.makeText(this, resources.getString(R.string.login_success), Toast.LENGTH_LONG).show()
            }
        }

    }
}