package com.example.desafio03_marvel.view.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.desafio03_marvel.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.BlurTransformation

class DetailsActivity : AppCompatActivity() {

    val iv_cover by lazy { findViewById<ImageView>(R.id.iv_details_cover) }
    val iv_photo by lazy { findViewById<ImageView>(R.id.iv_details_photo) }
    val tv_price by lazy { findViewById<TextView>(R.id.tv_details_price) }
    val tv_page by lazy { findViewById<TextView>(R.id.tv_details_page) }
    val tv_published by lazy { findViewById<TextView>(R.id.tv_details_published) }
    val tv_title by lazy { findViewById<TextView>(R.id.tv_details_title) }
    val tv_description by lazy { findViewById<TextView>(R.id.tv_details_description) }
    val fb_details by lazy { findViewById<FloatingActionButton>(R.id.fab_detail) }



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

        supportActionBar?.hide()

        var dateFormated = FormatDate(release.toString())
        Log.d("DATA", dateFormated.toString())

        tv_published.text = dateFormated
        tv_price.text = "$ "+price
        tv_page.text = pages
        tv_title.text = title

        if(description.isNullOrBlank()){
            tv_description.text = "There is no description for this comic."
        } else tv_description.text = description


        Picasso.get().load(photo + ".jpg").resize(119,182).into(iv_photo)
        Picasso.get().load(photo + ".jpg").transform(BlurTransformation(this, 10,1)).into(iv_cover)

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

        fb_details.setOnClickListener {
            onBackPressed()
        }


    }

    fun FormatDate(date : String): String {
        var year = date.subSequence(0, 4)
        var month = date.subSequence(5, 7)
        var day = date.subSequence(8, 10)

        when {
            month.equals("01") -> { month = "January"}
            month.equals("02") -> { month = "February"}
            month.equals("03") -> { month = "March"}
            month.equals("04") -> { month = "April"}
            month.equals("05") -> { month = "May"}
            month.equals("06") -> { month = "June"}
            month.equals("07") -> { month = "July"}
            month.equals("08") -> { month = "August"}
            month.equals("09") -> { month = "September"}
            month.equals("10") -> { month = "October"}
            month.equals("11") -> { month = "November"}
            month.equals("12") -> { month = "December"}
        }

        return "${month} ${day}, ${year}"

    }


}