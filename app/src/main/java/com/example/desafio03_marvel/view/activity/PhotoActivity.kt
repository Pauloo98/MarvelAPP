package com.example.desafio03_marvel.view.activity

import android.app.Dialog
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.desafio03_marvel.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso

class PhotoActivity :AppCompatActivity() {

    val fab_close by lazy { findViewById<FloatingActionButton>(R.id.fb_dialog_close) }
    val iv_photo by lazy { findViewById<ImageView>(R.id.iv_dialog_photo) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)
        supportActionBar?.hide()

        fab_close.setOnClickListener {
            onBackPressed()
        }

        val intent = intent.extras
        val photo = intent?.getString("photo")
        Picasso.get().load(photo + ".jpg").resize(290, 540).into(iv_photo)




    }
}