package com.example.desafio03_marvel.view.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.desafio03_marvel.R

class CreateAccActivity : AppCompatActivity() {

    val bt_save by lazy { findViewById<Button>(R.id.bt_register_save) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        bt_save.setOnClickListener {
            Toast.makeText(this, "Isso devia fazer algo" , Toast.LENGTH_LONG).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }


}