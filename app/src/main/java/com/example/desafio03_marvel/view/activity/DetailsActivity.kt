package com.example.desafio03_marvel.view.activity

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.desafio03_marvel.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso

class DetailsActivity : AppCompatActivity() {

    val iv_cover by lazy { findViewById<ImageView>(R.id.iv_details_cover) }
    val iv_photo by lazy { findViewById<ImageView>(R.id.iv_details_photo) }
    val tv_price by lazy { findViewById<TextView>(R.id.tv_details_price) }
    val tv_page by lazy { findViewById<TextView>(R.id.tv_details_page) }
    val tv_published by lazy { findViewById<TextView>(R.id.tv_details_published) }
    val tv_title by lazy { findViewById<TextView>(R.id.tv_details_title) }
    val tv_description by lazy { findViewById<TextView>(R.id.tv_details_description) }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comic_detail)

        val intent = intent.extras
        val title = intent?.getString("title")
        val description = intent?.getString("description")
        val price = intent?.getString("price")
        val release = intent?.getString("release")
        val pages = intent?.getString("pages")
        val photo = intent?.getString("photo")



        tv_published.text = release
        tv_price.text = "$ "+price
        tv_page.text = pages
        tv_title.text = title
        tv_description.text = description
        Picasso.get().load(photo + ".jpg").resize(119,182).into(iv_photo)

        Log.d("EXTRAS", title.toString())
        Log.d("EXTRAS", description.toString())
        Log.d("EXTRAS", price.toString())
        Log.d("EXTRAS", pages.toString())
        Log.d("EXTRAS", release.toString())

        iv_photo.setOnClickListener {
            val intent= Intent(this, PhotoActivity::class.java)
            intent.putExtra("photo", photo)
            startActivity(intent)
        }








    }

}