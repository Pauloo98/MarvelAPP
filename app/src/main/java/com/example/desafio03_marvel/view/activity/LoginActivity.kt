package com.example.desafio03_marvel.view.activity

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.desafio03_marvel.R
//import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

//    private lateinit var firebaseAuth : FirebaseAuth
    val et_email by lazy { findViewById<EditText>(R.id.et_login_email) }
    val et_password by lazy { findViewById<EditText>(R.id.et_login_email) }
    val bt_login by lazy { findViewById<Button>(R.id.bt_login) }
    val bt_create_acc by lazy { findViewById<TextView>(R.id.tv_create_acc) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailValidation()



        bt_login.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        bt_create_acc.setOnClickListener {
            val intent_create = Intent(this, CreateAccActivity::class.java)
            startActivity(intent_create)

        }

    }


    private fun emailValidation(){
        et_email.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(et_email.text.toString()).matches())
                    bt_login.isEnabled = true
                else{
                    bt_login.isEnabled = false
                    et_email.setError("Insira um email válido")
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }


}